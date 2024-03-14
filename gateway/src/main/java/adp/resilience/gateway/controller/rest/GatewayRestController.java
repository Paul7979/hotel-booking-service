package adp.resilience.gateway.controller.rest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import adp.resilience.gateway.model.dto.RoomDto;
import adp.resilience.gateway.service.GatewayRoomService;
import adp.resilience.gateway.service.RoomsCacheManagerService;

@RestController
public class GatewayRestController {

    private final GatewayRoomService roomService;
    private final RoomsCacheManagerService roomsCache;

    public GatewayRestController(@Qualifier("roomService") GatewayRoomService roomService,
            @Qualifier("roomsCacheManagerService") RoomsCacheManagerService roomsCache) {
        this.roomService = roomService;
        this.roomsCache = roomsCache;
    }

    @GetMapping("/rooms")
    public RoomDto[] getRooms() throws Throwable {
        var cache = roomsCache.cacheManager.getCache(roomsCache.ROOMS_CACHE_KEY, String.class, RoomDto[].class);
        var rooms = cache.get(roomsCache.ROOMS_CACHE_KEY);
        if (rooms == null || rooms.length == 0) {
            rooms = roomService.getRooms();
            cache.put(roomsCache.ROOMS_CACHE_KEY, rooms);
        }
        return rooms;
    }

    @GetMapping("/rooms/{id}")
    public RoomDto getRoom(@PathVariable Long id) throws Throwable {
        var cache = roomsCache.cacheManager.getCache(roomsCache.SINGLE_ROOM_CACHE_KEY, Long.class, RoomDto.class);
        var room = cache.get(id);
        if (room == null) {
            room = roomService.getRoom(id);
            cache.put(id, room);
        }
        return room;
    }
}

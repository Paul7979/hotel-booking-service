package adp.resilience.room.service;

import adp.resilience.room.service.model.RoomDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Primary
@Service
@RequiredArgsConstructor
public class CachingRoomServiceImpl implements RoomService {
  private final RoomServiceImpl roomService;
  private final ConcurrentHashMap<Long, RoomDto> roomsCache = new ConcurrentHashMap<>();
  private List<RoomDto> allRoomsCache = null;

  @Override
  public List<RoomDto> getRooms() {
    if (allRoomsCache == null) {
      allRoomsCache = roomService.getRooms();
    }
    return allRoomsCache;
  }

  @Override
  public RoomDto getRoomDetails(Long roomId) {
    return roomsCache.computeIfAbsent(roomId, roomService::getRoomDetails);
  }
}

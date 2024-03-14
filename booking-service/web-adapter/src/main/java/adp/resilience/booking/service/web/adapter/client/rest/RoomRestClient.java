package adp.resilience.booking.service.web.adapter.client.rest;

import adp.resilience.booking.service.business.usecase.out.RoomOutPort;
import adp.resilience.booking.service.web.adapter.mapper.RoomMapper;
import adp.resilience.booking.service.web.adapter.model.response.RoomResponseModel;
import adp.resilience.common.model.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class RoomRestClient implements RoomOutPort {

    @Value("${room.service.base.url}")
    private String roomServiceBaseUrl;

    @Value("${room.service.rooms.endpoint}")
    private String roomsEndpoint;

    private final RoomMapper roomMapper;

    @Override
    public Room getRoom(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        RoomResponseModel roomResponseModel = restTemplate.getForObject(roomServiceBaseUrl + roomsEndpoint + "/" + id, RoomResponseModel.class);
        return roomMapper.mapToRoom(roomResponseModel);
    }
}

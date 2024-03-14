package adp.resilience.room.service.business.room;


import adp.resilience.room.service.model.RoomDto;

import java.util.List;

public interface RoomService {
  List<RoomDto> getRooms();

  RoomDto getRoomDetails(Long roomId);
}

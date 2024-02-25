package at.technikum.hotelbookingservice.room;

import at.technikum.hotelbookingservice.room.model.Room;
import at.technikum.hotelbookingservice.room.model.RoomDto;

import java.util.List;

public interface RoomService {
  List<RoomDto> getRooms();

  RoomDto getRoomDetails(Long roomId);
}

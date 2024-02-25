package at.technikum.hotelbookingservice.room;

import at.technikum.hotelbookingservice.room.model.RoomDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoomController {
  private final RoomService roomService;

  @GetMapping("/rooms")
  public List<RoomDto> getRooms() {
    return roomService.getRooms();
  }

  @GetMapping("/rooms/{id}")
  public RoomDto getRoomById(@PathVariable Long id) {
    return roomService.getRoomDetails(id);
  }
}

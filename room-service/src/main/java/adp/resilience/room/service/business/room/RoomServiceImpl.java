package adp.resilience.room.service.business.room;

import adp.resilience.common.model.Room;
import adp.resilience.room.service.model.RoomDto;
import adp.resilience.room.service.persistence.repository.JpaRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoomServiceImpl implements RoomService {
  private final JpaRoomRepository roomRepository;

  @Override
  public List<RoomDto> getRooms() {
    log.info("Getting rooms");
    return roomRepository.findAll().stream().map(this::toDto).toList();
  }

  @Override
  public RoomDto getRoomDetails(Long roomId) {
    log.info("Getting room by id {}", roomId);
    return roomRepository.findById(roomId).map(this::toDto)
      .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "No room with id " + roomId));
  }

  private RoomDto toDto(Room room) {
    return new RoomDto(room.getId(), room.getName(), room.getCapacity(), room.getAmenities());
  }
}

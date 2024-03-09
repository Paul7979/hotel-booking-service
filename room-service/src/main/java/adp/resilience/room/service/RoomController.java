package adp.resilience.room.service;

import adp.resilience.room.service.model.RoomDto;
import adp.resilience.room.service.offer.OfferCalculationStrategy;
import adp.resilience.room.service.offer.OfferDto;
import adp.resilience.room.service.offer.OfferStrategyFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoomController {
  private final RoomService roomService;

  private final OfferStrategyFactory offerStrategyFactory;

  @GetMapping("/rooms")
  public List<RoomDto> getRooms() {
    return roomService.getRooms();
  }

  @GetMapping("/rooms/{id}")
  public RoomDto getRoomById(@PathVariable Long id) {
    return roomService.getRoomDetails(id);
  }

  @GetMapping("/room/{id}/offer")
  public OfferDto getOffer(@PathVariable Long id,
                           @RequestParam(name = "guestName") String guestName,
                           @RequestParam(name = "startTime") LocalDateTime startTime,
                           @RequestParam(name = "endTime") LocalDateTime endTime) {
    var room = roomService.getRoomDetails(id);

    OfferCalculationStrategy strategy = offerStrategyFactory.getOfferCalculationStrategy(guestName);

    int totalPrice = strategy.calculateOfferPrice(room, startTime, endTime);

    return new OfferDto(room.id(), startTime, endTime, guestName, totalPrice);

  }
}

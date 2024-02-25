package at.technikum.hotelbookingservice.offer;

import at.technikum.hotelbookingservice.room.RoomService;
import at.technikum.hotelbookingservice.room.model.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class OfferController {

  private final RoomService roomService;
  private final OfferStrategyFactory offerStrategyFactory;

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

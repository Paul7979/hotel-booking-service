package at.technikum.hotelbookingservice.booking;

import at.technikum.hotelbookingservice.booking.model.BookingDTO;
import at.technikum.hotelbookingservice.booking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookingController {
  private final BookingService bookingService;

  @PostMapping(path = "/booking")
  public ResponseEntity<Void> book(@RequestBody BookingDTO bookingDTO) {
    bookingService.bookRoom(bookingDTO);
    return ResponseEntity.accepted().build();
  }
}

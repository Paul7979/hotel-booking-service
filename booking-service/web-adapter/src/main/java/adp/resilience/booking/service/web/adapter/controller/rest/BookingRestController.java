package adp.resilience.booking.service.web.adapter;

import adp.resilience.booking.service.controller.model.request.BookRoomRequestModel;
import adp.resilience.booking.service.usecase.BookRoomInPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookingRestController {
  private final BookRoomInPort bookRoomInPort;

  @PostMapping(path = "/booking")
  public ResponseEntity<Void> book(@RequestBody BookRoomRequestModel bookingDTO) {

    bookingService.bookRoom(bookingDTO);
    return ResponseEntity.accepted().build();
  }
}

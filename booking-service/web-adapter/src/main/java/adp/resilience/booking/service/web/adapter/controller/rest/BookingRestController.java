package adp.resilience.booking.service.web.adapter.controller.rest;

import adp.resilience.booking.service.business.usecase.BookRoomInPort;
import adp.resilience.booking.service.web.adapter.model.request.BookRoomRequestModel;
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

        /**
         * TODO
         bookingService.bookRoom(bookingDTO);
         return ResponseEntity.accepted().build();
         */
        return ResponseEntity.accepted().build();
    }
}

package adp.resilience.booking.service.web.adapter.controller.rest;

import adp.resilience.booking.service.business.usecase.BookRoomInPort;
import adp.resilience.booking.service.business.usecase.BookRoomInPort.BookRoomRequest;
import adp.resilience.booking.service.business.usecase.BookRoomInPort.BookRoomResponse;
import adp.resilience.booking.service.web.adapter.mapper.BookRoomMapper;
import adp.resilience.booking.service.web.adapter.model.request.BookRoomRequestModel;
import adp.resilience.booking.service.web.adapter.model.response.BookRoomResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookingRestController {
    private final BookRoomInPort bookRoomInPort;
    private final BookRoomMapper mapper;

    @PostMapping(path = "/booking")
    public BookRoomResponseModel book(@RequestBody BookRoomRequestModel bookRoomRequestModel) {
        BookRoomRequest bookRoomRequest = mapper.mapToBookRoomRequest(bookRoomRequestModel);

        BookRoomResponse acceptedBooking = bookRoomInPort.bookRoom(bookRoomRequest);
        return mapper.mapToBookRoomResponseModel(acceptedBooking);
    }
}

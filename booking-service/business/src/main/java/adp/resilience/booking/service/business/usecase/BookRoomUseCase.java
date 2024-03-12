package adp.resilience.booking.service.business.usecase;

import adp.resilience.common.model.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookRoomUseCase implements BookRoomInPort {

    private final BookRoomChain bookingChain;

    @Override
    public BookRoomResponse bookRoom(BookRoomRequest request) {
        Booking booking = bookingChain.bookRoom(request);
        return new BookRoomResponse(booking);
    }
}

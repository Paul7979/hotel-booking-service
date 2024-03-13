package adp.resilience.booking.service.business.service;

import adp.resilience.booking.service.business.usecase.BookRoomInPort;
import adp.resilience.booking.service.business.usecase.BookingHandler;
import adp.resilience.booking.service.business.usecase.out.BookingOutPort;
import adp.resilience.common.model.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookingPersistenceHandlerImpl implements BookingPersistenceHandler {

    private final BookingOutPort bookingRepository;

    private BookingHandler nextHandler;

    @Override
    public Booking handleBooking(BookRoomInPort.BookRoomRequest bookRoomRequest) {
        var booking = bookRoomRequest.booking();
        booking = bookingRepository.save(booking);
        nextHandler.handleBooking(bookRoomRequest);
        return booking;
    }

    @Override
    public void setNextHandler(BookingHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}

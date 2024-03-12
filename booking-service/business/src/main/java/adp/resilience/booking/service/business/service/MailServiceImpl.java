package adp.resilience.booking.service.business.service;

import adp.resilience.booking.service.business.usecase.BookRoomInPort;
import adp.resilience.booking.service.business.usecase.BookingHandler;
import adp.resilience.common.model.Booking;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MailServiceImpl implements MailService {
    @Override
    public Booking handleBooking(BookRoomInPort.BookRoomRequest bookRoomRequest) {
        Booking booking = bookRoomRequest.booking();
        log.info("Sending mail for booking {} to customer {}", booking.getId(), booking.getGuestName());
        return null;
    }

    @Override
    public void setNextHandler(BookingHandler nextHandler) {
        // Do nothing as this should be the last handler
    }
}

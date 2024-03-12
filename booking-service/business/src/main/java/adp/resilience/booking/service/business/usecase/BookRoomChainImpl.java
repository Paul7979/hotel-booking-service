package adp.resilience.booking.service.business.usecase;

import adp.resilience.booking.service.business.service.AvailabilityService;
import adp.resilience.booking.service.business.service.BookingPersistenceHandler;
import adp.resilience.booking.service.business.service.MailService;
import adp.resilience.booking.service.business.service.PaymentHandler;
import adp.resilience.common.model.Booking;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookRoomChainImpl implements BookRoomChain {

    private final AvailabilityService availabilityOutPort;

    private final MailService mailOutPort;

    private final PaymentHandler paymentOutPort;

    private final BookingPersistenceHandler bookRoomOutPort;

    @PostConstruct
    private void init() {
        availabilityOutPort.setNextHandler(paymentOutPort);
        paymentOutPort.setNextHandler(bookRoomOutPort);
        bookRoomOutPort.setNextHandler(mailOutPort);
    }

    @Override
    public Booking bookRoom(BookRoomInPort.BookRoomRequest bookRoomRequest) {
        return availabilityOutPort.handleBooking(bookRoomRequest);
    }
}

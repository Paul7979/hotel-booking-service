package adp.resilience.booking.service;

import adp.resilience.booking.service.controller.model.request.BookRoomRequestModel;
import adp.resilience.booking.service.repository.BookingRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final PaymentService paymentService;

    private BookingHandler availabilityService;
    private BookingHandler mailHandler;
    private BookingHandler paymentHandler;
    private BookingHandler bookingPersistenceHandler;

    @PostConstruct
    void init() {
        availabilityService = new AvailabilityService(bookingRepository);
        mailHandler = new MailHandler();
        bookingPersistenceHandler = new BookingPersistenceHandler(bookingRepository, roomRepository);
        paymentHandler = new PaymentHandler(paymentService);
        availabilityService.setNextHandler(paymentHandler);
        paymentHandler.setNextHandler(mailHandler);
        paymentHandler.setNextHandler(bookingPersistenceHandler);
    }

    @Transactional
    public void bookRoom(BookRoomRequestModel booking) {
        availabilityService.handleBooking(booking);
    }


}

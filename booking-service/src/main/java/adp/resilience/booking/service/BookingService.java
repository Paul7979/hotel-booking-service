package at.technikum.hotelbookingservice.booking.service;

import at.technikum.hotelbookingservice.booking.BookingRepository;
import at.technikum.hotelbookingservice.booking.model.Booking;
import at.technikum.hotelbookingservice.booking.model.BookingDTO;
import at.technikum.hotelbookingservice.room.RoomRepository;
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
    public void bookRoom(BookingDTO booking) {
        availabilityService.handleBooking(booking);
    }


}

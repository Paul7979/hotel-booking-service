package at.technikum.hotelbookingservice.initializer;

import at.technikum.hotelbookingservice.booking.BookingRepository;
import at.technikum.hotelbookingservice.booking.model.Booking;
import at.technikum.hotelbookingservice.room.RoomPriceRepository;
import at.technikum.hotelbookingservice.room.RoomRepository;
import at.technikum.hotelbookingservice.room.model.PriceType;
import at.technikum.hotelbookingservice.room.model.Room;
import at.technikum.hotelbookingservice.room.model.RoomPrice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class SampleDataInitializer {

    private final RoomRepository roomRepository;

    private final RoomPriceRepository roomPriceRepository;

    private final BookingRepository bookingRepository;

    @PostConstruct
    public void run() {
        // Create bookings
        createBooking(room1, LocalDateTime.of(2024, 2, 28, 14, 0), LocalDateTime.of(2024, 3, 3, 12, 0), "John Doe", "FINISHED");
        createBooking(room2, LocalDateTime.of(2024, 3, 5, 15, 0), LocalDateTime.of(2024, 3, 10, 10, 0), "Alice Smith", "FINISHED");
    }
    private Booking createBooking(Room room, LocalDateTime startTime, LocalDateTime endTime, String guestName, String paymentStatus) {
        Booking booking = new Booking();
        booking.setRoom(room);
        booking.setStartTime(startTime);
        booking.setEndTime(endTime);
        booking.setGuestName(guestName);
        booking.setPaymentStatus(paymentStatus);
        return bookingRepository.save(booking);
    }
}

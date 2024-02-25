package at.technikum.hotelbookingservice.booking;

import at.technikum.hotelbookingservice.booking.model.Booking;
import at.technikum.hotelbookingservice.room.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByRoomIdAndStartTimeBetweenOrEndTimeBetween(Long roomId, LocalDateTime start1, LocalDateTime end1, LocalDateTime start2, LocalDateTime end2);
}

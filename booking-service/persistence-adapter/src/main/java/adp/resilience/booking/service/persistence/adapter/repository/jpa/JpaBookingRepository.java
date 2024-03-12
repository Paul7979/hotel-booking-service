package adp.resilience.booking.service.persistence.adapter.repository.jpa;


import adp.resilience.booking.service.persistence.adapter.model.jpa.JpaBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface JpaBookingRepository extends JpaRepository<JpaBooking, Long> {
    List<JpaBooking> findByRoomIdAndStartTimeBetweenOrEndTimeBetween(Long roomId, LocalDateTime start1, LocalDateTime end1, LocalDateTime start2, LocalDateTime end2);
}

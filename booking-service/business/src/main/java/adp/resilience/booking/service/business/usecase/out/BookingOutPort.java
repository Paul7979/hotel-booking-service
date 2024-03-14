package adp.resilience.booking.service.business.usecase.out;

import adp.resilience.common.model.Booking;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingOutPort {

    List<Booking> findByRoomIdAndStartTimeBetweenOrEndTimeBetween(Long roomId, LocalDateTime start1, LocalDateTime end1, LocalDateTime start2, LocalDateTime end2);

    Booking save(Booking booking);

}

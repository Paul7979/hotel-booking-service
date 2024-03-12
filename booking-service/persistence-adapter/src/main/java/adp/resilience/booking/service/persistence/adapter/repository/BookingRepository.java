package adp.resilience.booking.service.persistence.adapter.repository;

import adp.resilience.booking.service.business.usecase.out.BookingOutPort;
import adp.resilience.booking.service.business.usecase.out.RoomOutPort;
import adp.resilience.booking.service.persistence.adapter.mapper.JpaBookingMapper;
import adp.resilience.booking.service.persistence.adapter.model.jpa.JpaBooking;
import adp.resilience.booking.service.persistence.adapter.repository.jpa.JpaBookingRepository;
import adp.resilience.common.model.Booking;
import adp.resilience.common.model.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BookingRepository implements BookingOutPort {

    private final JpaBookingRepository jpaBookingRepository;

    private final RoomOutPort roomOutPort;

    private final JpaBookingMapper mapper;

    @Override
    public List<Booking> findByRoomIdAndStartTimeBetweenOrEndTimeBetween(Long roomId, LocalDateTime start1, LocalDateTime end1, LocalDateTime start2, LocalDateTime end2) {
        List<JpaBooking> jpaBookings = jpaBookingRepository.findByRoomIdAndStartTimeBetweenOrEndTimeBetween(roomId, start1, end1, start2, end2);

        return jpaBookings.stream().map(mapper::mapToBooking).map(this::loadReferences).toList();
    }

    @Override
    public Booking save(Booking booking) {
        return jpaBookingRepository.save(mapper.mapToJpaBooking(booking));
    }

    private Booking loadReferences(Booking booking) {
        Room room = roomOutPort.getRoom(booking.getRoomId());
        booking.setRoom(room);
        return booking;
    }
}

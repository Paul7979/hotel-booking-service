package adp.resilience.booking.service.persistence.adapter.mapper;

import adp.resilience.booking.service.persistence.adapter.model.jpa.JpaBooking;
import adp.resilience.common.model.Booking;
import org.mapstruct.Mapper;

@Mapper
public interface JpaBookingMapper {
    Booking mapToBooking(JpaBooking jpaBooking);

    JpaBooking mapToJpaBooking(Booking booking);
}

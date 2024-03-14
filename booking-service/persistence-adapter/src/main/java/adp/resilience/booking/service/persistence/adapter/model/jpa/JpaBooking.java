package adp.resilience.booking.service.persistence.adapter.model.jpa;

import adp.resilience.common.model.Booking;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@AllArgsConstructor
public class JpaBooking extends Booking {

}

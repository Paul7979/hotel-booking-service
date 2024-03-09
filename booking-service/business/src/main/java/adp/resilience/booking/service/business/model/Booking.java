package adp.resilience.booking.service.business.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Builder
public class Booking {

    public Booking(BookingBuilder builder){

    }

    private Long id;

    private Room room;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String guestName;

    private String paymentStatus;
}

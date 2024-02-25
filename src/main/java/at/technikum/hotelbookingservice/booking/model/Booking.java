package at.technikum.hotelbookingservice.booking.model;

import at.technikum.hotelbookingservice.room.model.Room;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String guestName;

    private String paymentStatus;
}

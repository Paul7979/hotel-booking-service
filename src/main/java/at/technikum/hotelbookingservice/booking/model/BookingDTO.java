package at.technikum.hotelbookingservice.booking.model;

import java.time.LocalDateTime;
import java.util.UUID;

public record BookingDTO(
    Long id,
    Long roomId,
    LocalDateTime startTime,
    LocalDateTime endTime,
    String guestName,
    UUID paymentId
) {}

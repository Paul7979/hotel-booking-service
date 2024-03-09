package adp.resilience.room.service.offer;

import java.time.LocalDateTime;

public record OfferDto(
    long roomId,
    LocalDateTime startTime,
    LocalDateTime endTime,
    String guestName,
    int totalPrice
) {}

package adp.resilience.booking.service.web.adapter.model.request;

import java.time.LocalDateTime;
import java.util.UUID;

public record BookRoomRequestModel(
    Long id,
    Long roomId,
    LocalDateTime startTime,
    LocalDateTime endTime,
    String guestName,
    UUID paymentId
) {}

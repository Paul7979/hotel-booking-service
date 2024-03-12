package adp.resilience.booking.service.web.adapter.model.request;

import java.time.LocalDateTime;

public record BookingRequestModel(
        Long roomId,
        LocalDateTime startTime,
        LocalDateTime endTime,
        String guestName
) {}
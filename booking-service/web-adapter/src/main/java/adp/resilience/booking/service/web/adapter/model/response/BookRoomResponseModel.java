package adp.resilience.booking.service.web.adapter.model.response;

import java.time.LocalDateTime;

public record BookRoomResponseModel(
        Long bookingId,
        Long roomId,
        LocalDateTime startTime,
        LocalDateTime endTime,
        String guestName
) {
}

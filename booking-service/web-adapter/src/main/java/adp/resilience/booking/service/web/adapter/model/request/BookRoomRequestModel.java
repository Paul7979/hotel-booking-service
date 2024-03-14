package adp.resilience.booking.service.web.adapter.model.request;

import java.util.UUID;

public record BookRoomRequestModel(
        BookingRequestModel bookingInfo,
        UUID paymentId
) {
}

package adp.resilience.booking.service.business.usecase;


import adp.resilience.common.model.Booking;

import java.util.UUID;

public interface BookRoomInPort {

    record BookRoomRequest(Booking booking, UUID paymentId) {}

    record BookRoomResponse(Booking booking) {}
    BookRoomResponse bookRoom(BookRoomRequest request);
}

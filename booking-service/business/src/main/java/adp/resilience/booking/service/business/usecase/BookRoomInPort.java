package adp.resilience.booking.service.usecase;

import adp.resilience.booking.service.model.Booking;

public interface BookRoomInPort {

    record BookRoomRequest() {}

    record BookRoomResponse() {}
    BookRoomResponse bookRoom(BookRoomRequest request);
}

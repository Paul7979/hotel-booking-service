package adp.resilience.booking.service;

import adp.resilience.booking.service.model.BookingDTO;

public interface BookRoomChain {
    void bookRoom(BookingDTO booking);
}

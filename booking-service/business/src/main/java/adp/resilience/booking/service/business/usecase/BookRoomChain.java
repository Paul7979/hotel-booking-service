package adp.resilience.booking.service.business.usecase;

import adp.resilience.common.model.Booking;

public interface BookRoomChain {
    Booking bookRoom(BookRoomInPort.BookRoomRequest bookRoomRequest);
}

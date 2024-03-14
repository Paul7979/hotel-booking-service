package adp.resilience.booking.service.business.usecase;


import adp.resilience.booking.service.business.usecase.BookRoomInPort.BookRoomRequest;
import adp.resilience.common.model.Booking;

public interface BookingHandler {
    Booking handleBooking(BookRoomRequest bookRoomRequest);
    void setNextHandler(BookingHandler nextHandler);
}

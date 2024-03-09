package adp.resilience.booking.service;


import adp.resilience.booking.service.controller.model.request.BookRoomRequestModel;

public interface BookingHandler {
    void handleBooking(BookRoomRequestModel booking);
    void setNextHandler(BookingHandler nextHandler);
}

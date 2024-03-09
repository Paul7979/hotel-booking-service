package at.technikum.hotelbookingservice.booking.service;

import at.technikum.hotelbookingservice.booking.model.Booking;
import at.technikum.hotelbookingservice.booking.model.BookingDTO;

public interface BookingHandler {
    void handleBooking(BookingDTO booking);
    void setNextHandler(BookingHandler nextHandler);
}

package at.technikum.hotelbookingservice.booking.service;

import at.technikum.hotelbookingservice.booking.model.Booking;
import at.technikum.hotelbookingservice.booking.model.BookingDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailHandler implements BookingHandler {
  private BookingHandler nextHandler;

  @Override
  public void handleBooking(BookingDTO booking) {
    log.info("Sending mail for booking {} to customer {}", booking.id(), booking.guestName());
    nextHandler.handleBooking(booking);
  }

  @Override
  public void setNextHandler(BookingHandler nextHandler) {
    this.nextHandler = nextHandler;
  }
}

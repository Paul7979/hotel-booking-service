package adp.resilience.booking.service;

import adp.resilience.booking.service.controller.model.request.BookRoomRequestModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailHandler implements BookingHandler {
  private BookingHandler nextHandler;

  @Override
  public void handleBooking(BookRoomRequestModel booking) {
    log.info("Sending mail for booking {} to customer {}", booking.id(), booking.guestName());
    nextHandler.handleBooking(booking);
  }

  @Override
  public void setNextHandler(BookingHandler nextHandler) {
    this.nextHandler = nextHandler;
  }
}

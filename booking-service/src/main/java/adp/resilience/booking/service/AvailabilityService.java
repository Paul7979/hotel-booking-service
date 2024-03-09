package adp.resilience.booking.service;

import adp.resilience.booking.service.model.Booking;
import adp.resilience.booking.service.controller.model.request.BookRoomRequestModel;
import adp.resilience.booking.service.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
public class AvailabilityService implements BookingHandler {
  private BookingHandler nextHandler;
  private final BookingRepository bookingRepository;
  @Override
  public void handleBooking(BookRoomRequestModel booking) {
    List<Booking> collisions = bookingRepository.findByRoomIdAndStartTimeBetweenOrEndTimeBetween(
      booking.roomId(), booking.startTime(), booking.endTime(),
      booking.startTime(), booking.endTime()
    );
    if (!collisions.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, "There is already a booking for the given time period");
    }
    nextHandler.handleBooking(booking);
  }

  @Override
  public void setNextHandler(BookingHandler nextHandler) {
    this.nextHandler = nextHandler;
  }
}

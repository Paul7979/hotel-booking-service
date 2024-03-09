package at.technikum.hotelbookingservice.booking.service;

import at.technikum.hotelbookingservice.booking.BookingRepository;
import at.technikum.hotelbookingservice.booking.model.Booking;
import at.technikum.hotelbookingservice.booking.model.BookingDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
public class AvailabilityService implements BookingHandler {
  private BookingHandler nextHandler;
  private final BookingRepository bookingRepository;
  @Override
  public void handleBooking(BookingDTO booking) {
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

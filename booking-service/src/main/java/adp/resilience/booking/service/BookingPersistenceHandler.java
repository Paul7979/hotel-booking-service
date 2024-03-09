package at.technikum.hotelbookingservice.booking.service;

import at.technikum.hotelbookingservice.booking.BookingRepository;
import at.technikum.hotelbookingservice.booking.model.Booking;
import at.technikum.hotelbookingservice.booking.model.BookingDTO;
import at.technikum.hotelbookingservice.room.RoomRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BookingPersistenceHandler implements BookingHandler {

  private final BookingRepository bookingRepository;
  private final RoomRepository roomRepository;
  @Override
  public void handleBooking(BookingDTO booking) {
    var bookingEntity = toEnitity(booking);
    bookingRepository.save(bookingEntity);
  }

  public Booking toEnitity(BookingDTO bookingDTO) {
    var booking = new Booking();
    booking.setId(bookingDTO.id());
    booking.setRoom(roomRepository.getReferenceById(bookingDTO.roomId()));
    booking.setStartTime(bookingDTO.startTime());
    booking.setEndTime(bookingDTO.endTime());
    booking.setGuestName(bookingDTO.guestName());
    booking.setPaymentStatus("FINISHED");
    return booking;
  }

  @Override
  public void setNextHandler(BookingHandler nextHandler) {
    throw new UnsupportedOperationException("Persistence Handler has to be final handler!");
  }
}

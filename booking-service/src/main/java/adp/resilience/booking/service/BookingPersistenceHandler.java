package adp.resilience.booking.service;

import adp.resilience.booking.service.model.Booking;
import adp.resilience.booking.service.controller.model.request.BookRoomRequestModel;
import adp.resilience.booking.service.repository.BookingRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BookingPersistenceHandler implements BookingHandler {

  private final BookingRepository bookingRepository;
  private final RoomRepository roomRepository;
  @Override
  public void handleBooking(BookRoomRequestModel booking) {
    var bookingEntity = toEnitity(booking);
    bookingRepository.save(bookingEntity);
  }

  public Booking toEnitity(BookRoomRequestModel bookingDTO) {
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

package adp.resilience.booking.service.business.service;

import adp.resilience.booking.service.business.exception.BusinessRuleException;
import adp.resilience.booking.service.business.exception.ErrorStatus;
import adp.resilience.booking.service.business.usecase.BookRoomInPort.BookRoomRequest;
import adp.resilience.booking.service.business.usecase.BookingHandler;
import adp.resilience.booking.service.business.usecase.out.BookingOutPort;
import adp.resilience.common.model.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class AvailabilityServiceImpl implements AvailabilityService {
    private BookingHandler nextHandler;

    private final BookingOutPort bookingOutPort;

    @Override
    public Booking handleBooking(BookRoomRequest bookRoomRequest) {
        Booking booking = bookRoomRequest.booking();
        boolean isBookingFeasible = this.isBookingFeasible(booking);
        if (!isBookingFeasible) {
            throw new BusinessRuleException("There is already a booking for the given time period", ErrorStatus.CONFLICT);
        }
        return nextHandler.handleBooking(bookRoomRequest);
    }

    @Override
    public void setNextHandler(BookingHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public boolean isBookingFeasible(Booking booking) {
        List<Booking> collisions = bookingOutPort.findByRoomIdAndStartTimeBetweenOrEndTimeBetween(
                booking.getRoomId(), booking.getStartTime(), booking.getEndTime(),
                booking.getStartTime(), booking.getEndTime());
        return collisions.isEmpty();
    }
}

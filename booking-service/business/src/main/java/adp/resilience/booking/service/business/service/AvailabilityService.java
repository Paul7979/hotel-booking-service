package adp.resilience.booking.service.business.service;

import adp.resilience.booking.service.business.usecase.BookingHandler;
import adp.resilience.common.model.Booking;

public interface AvailabilityService extends BookingHandler {
    boolean isBookingFeasible(Booking booking);
}

package at.technikum.hotelbookingservice.booking.service;

import at.technikum.hotelbookingservice.booking.model.BookingDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
public class PaymentHandler implements BookingHandler {
  private BookingHandler nextHandler;
  private final PaymentService paymentService;

  @Override
  public void handleBooking(BookingDTO booking) {
    var paymentStatus = paymentService.getPaymentStatus(booking.paymentId());

    switch (paymentStatus) {
      case FAILED -> throw new ResponseStatusException(HttpStatus.PAYMENT_REQUIRED, "Payment is not finished");
      case FINISHED -> nextHandler.handleBooking(booking);
      case null, default -> throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error while checking payment");
    }
  }

  @Override
  public void setNextHandler(BookingHandler nextHandler) {
    this.nextHandler = nextHandler;
  }
}

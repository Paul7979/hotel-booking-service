package adp.resilience.booking.service.business.service;

import adp.resilience.booking.service.business.exception.BusinessRuleException;
import adp.resilience.booking.service.business.exception.ErrorStatus;
import adp.resilience.booking.service.business.usecase.BookRoomInPort.BookRoomRequest;
import adp.resilience.booking.service.business.usecase.BookingHandler;
import adp.resilience.booking.service.business.usecase.out.PaymentOutPort;
import adp.resilience.common.model.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PaymentHandlerImpl implements PaymentHandler {
    private BookingHandler nextHandler;
    private final PaymentOutPort paymentOutPort;

    @Override
    public Booking handleBooking(BookRoomRequest bookRoomRequest) {
        var paymentStatus = paymentOutPort.getPaymentStatus(bookRoomRequest.paymentId());

        switch (paymentStatus) {
            case FAILED -> throw new BusinessRuleException("Payment is not finished", ErrorStatus.PAYMENT_REQUIRED);
            case FINISHED -> {
                return nextHandler.handleBooking(bookRoomRequest);
            }
            case null, default ->
                    throw new BusinessRuleException("Invalid PaymentStatus");
        }
    }

    @Override
    public void setNextHandler(BookingHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}

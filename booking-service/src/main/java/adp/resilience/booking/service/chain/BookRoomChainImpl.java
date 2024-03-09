package adp.resilience.booking.service.chain;

import adp.resilience.booking.service.AvailabilityService;
import adp.resilience.booking.service.MailHandler;
import adp.resilience.booking.service.PaymentHandler;
import adp.resilience.booking.service.controller.model.request.BookRoomRequestModel;
import org.springframework.stereotype.Component;

@Component
public class BookRoomChainImpl implements BookRoomChain{

    private final AvailabilityService availabilityService;

    private final MailHandler mailHandler;

    private final PaymentHandler paymentHandler;

    public BookRoomChainImpl(AvailabilityService availabilityService, MailHandler mailHandler, PaymentHandler paymentHandler){
        this.availabilityService = availabilityService;
        this.mailHandler = mailHandler;
        this.paymentHandler = paymentHandler;
        availabilityService.setNextHandler(paymentHandler);
        paymentHandler.setNextHandler(mailHandler);
    }

    @Override
    public void bookRoom(BookRoomRequestModel booking) {

    }
}

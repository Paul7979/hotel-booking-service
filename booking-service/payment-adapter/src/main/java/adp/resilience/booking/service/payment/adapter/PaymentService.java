package adp.resilience.booking.service.payment.adapter;

import adp.resilience.booking.service.business.usecase.out.PaymentOutPort;
import adp.resilience.common.model.PaymentStatus;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PaymentService implements PaymentOutPort {

    //mocked payment status check against a payment service provider
    public PaymentStatus getPaymentStatus(UUID paymentId) {
        if (UUID.fromString("00000000-0000-0000-0000-000000000000").equals(paymentId)) {
            return PaymentStatus.FAILED;
        }
        return PaymentStatus.FINISHED;
    }

}

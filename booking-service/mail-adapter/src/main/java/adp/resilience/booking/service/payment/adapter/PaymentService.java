package adp.resilience.booking.service.payment.adapter;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {

  //mocked payment status check against a payment service provider
  public PaymentStatus getPaymentStatus(UUID paymentId) {
    if (UUID.fromString("00000000-0000-0000-0000-000000000000").equals(paymentId)) {
      return PaymentStatus.FAILED;
    }
    return PaymentStatus.FINISHED;
  }

  public enum PaymentStatus {
    FINISHED,
    FAILED
  }

}

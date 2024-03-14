package adp.resilience.booking.service.business.usecase.out;

import adp.resilience.common.model.PaymentStatus;

import java.util.UUID;

public interface PaymentOutPort {
    PaymentStatus getPaymentStatus(UUID uuid);
}

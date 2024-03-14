package adp.resilience.booking.service.business.exception;

import lombok.Getter;

@Getter
public class BusinessRuleException extends RuntimeException{

    private final ErrorStatus errorStatus;

    public BusinessRuleException(String message) {
        super(message);
        this.errorStatus = ErrorStatus.GENERAL;
    }

    public BusinessRuleException(String message, ErrorStatus errorStatus) {
        super(message);
        this.errorStatus = errorStatus;
    }

    public BusinessRuleException(String message, Throwable cause, ErrorStatus errorStatus) {
        super(message, cause);
        this.errorStatus = errorStatus;
    }
}

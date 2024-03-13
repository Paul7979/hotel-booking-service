package adp.resilience.bookingservice.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"adp.resilience.booking.service"})
@EnableJpaRepositories(basePackages = {"adp.resilience.booking.service.persistence.adapter"})
@EntityScan(basePackages = {"adp.resilience.booking.service.persistence.adapter"})
public class BookingService {

    public static void main(String[] args) {
        SpringApplication.run(BookingService.class, args);
    }

}
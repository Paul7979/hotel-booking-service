package adp.resilience.room.service.persistence.repository;


import adp.resilience.room.service.persistence.model.jpa.JpaRoomPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaRoomPriceRepository extends JpaRepository<JpaRoomPrice, Long> {
    // Custom queries if needed
}

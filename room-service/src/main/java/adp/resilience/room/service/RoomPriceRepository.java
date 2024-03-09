package adp.resilience.room.service;


import adp.resilience.room.service.model.RoomPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomPriceRepository extends JpaRepository<RoomPrice, Long> {
    // Custom queries if needed
}

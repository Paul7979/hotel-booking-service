package at.technikum.hotelbookingservice.room;

import at.technikum.hotelbookingservice.room.model.RoomPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomPriceRepository extends JpaRepository<RoomPrice, Long> {
    // Custom queries if needed
}

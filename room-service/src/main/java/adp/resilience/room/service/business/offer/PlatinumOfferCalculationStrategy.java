package adp.resilience.room.service.business.offer;

import adp.resilience.room.service.persistence.repository.JpaRoomRepository;
import adp.resilience.common.model.PriceType;
import adp.resilience.common.model.Room;
import adp.resilience.room.service.model.RoomDto;
import adp.resilience.common.model.RoomPrice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public final class PlatinumOfferCalculationStrategy implements OfferCalculationStrategy {
    private final JpaRoomRepository roomRepository;
    @Override
    public int calculateOfferPrice(RoomDto room, LocalDateTime startTime, LocalDateTime endTime) {
        var roomEnitiy = roomRepository.findById(room.id()).orElseThrow();
        return calculateSpecialPrice(roomEnitiy, startTime, endTime);
    }
    
    private int calculateSpecialPrice(Room room, LocalDateTime startTime, LocalDateTime endTime) {
        var numberOfDays = Duration.between(startTime, endTime).toDays();
        if (numberOfDays > 10) {
            numberOfDays = numberOfDays - 1;
        }
        if (numberOfDays > 5) {
            numberOfDays = numberOfDays - 1;
        }
        return (int) numberOfDays *  room.getPrices().stream()
                .filter(price -> price.getType() == PriceType.PLATINUM)
                .findFirst()
                .map(RoomPrice::getPrice)
                .orElseThrow();
    }
}

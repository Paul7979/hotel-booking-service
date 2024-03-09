package adp.resilience.room.service.offer;

import adp.resilience.room.service.RoomRepository;
import adp.resilience.room.service.model.PriceType;
import adp.resilience.room.service.model.Room;
import adp.resilience.room.service.model.RoomDto;
import adp.resilience.room.service.model.RoomPrice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public final class RegularOfferCalculationStrategy implements OfferCalculationStrategy {
    private final RoomRepository roomRepository;

    @Override
    public int calculateOfferPrice(RoomDto room, LocalDateTime startTime, LocalDateTime endTime) {
        var roomEnitiy = roomRepository.findById(room.id()).orElseThrow();
        return calculateStandardPrice(roomEnitiy, startTime, endTime);
    }
    
    private int calculateStandardPrice(Room room, LocalDateTime startTime, LocalDateTime endTime) {
        var numberOfDays = Duration.between(startTime, endTime).toDays();
        return (int) numberOfDays * room.getPrices().stream()
                .filter(price -> price.getType() == PriceType.STANDARD)
                .findFirst()
                .map(RoomPrice::getPrice)
                .orElseThrow();
    }
}

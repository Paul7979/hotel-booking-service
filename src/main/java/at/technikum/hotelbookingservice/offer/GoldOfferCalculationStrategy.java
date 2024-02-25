package at.technikum.hotelbookingservice.offer;

import at.technikum.hotelbookingservice.room.RoomRepository;
import at.technikum.hotelbookingservice.room.model.PriceType;
import at.technikum.hotelbookingservice.room.model.Room;
import at.technikum.hotelbookingservice.room.model.RoomDto;
import at.technikum.hotelbookingservice.room.model.RoomPrice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public final class GoldOfferCalculationStrategy implements OfferCalculationStrategy {
    private final RoomRepository roomRepository;
    @Override
    public int calculateOfferPrice(RoomDto room, LocalDateTime startTime, LocalDateTime endTime) {
        var roomEnitiy = roomRepository.findById(room.id()).orElseThrow();
        return calculateSpecialPrice(roomEnitiy, startTime, endTime);
    }
    
    private int calculateSpecialPrice(Room room, LocalDateTime startTime, LocalDateTime endTime) {
        var numberOfDays = Duration.between(startTime, endTime).toDays();
        return (int) numberOfDays *  room.getPrices().stream()
                .filter(price -> price.getType() == PriceType.GOLD)
                .findFirst()
                .map(RoomPrice::getPrice)
                .orElseThrow();
    }
}

package at.technikum.hotelbookingservice.offer;

import at.technikum.hotelbookingservice.room.model.RoomDto;

import java.time.LocalDateTime;

public sealed interface OfferCalculationStrategy permits PlatinumOfferCalculationStrategy, RegularOfferCalculationStrategy, GoldOfferCalculationStrategy{
    int calculateOfferPrice(RoomDto room, LocalDateTime startTime, LocalDateTime endTime);
}

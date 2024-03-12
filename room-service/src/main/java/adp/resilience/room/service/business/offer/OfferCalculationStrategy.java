package adp.resilience.room.service.business.offer;


import adp.resilience.room.service.model.RoomDto;

import java.time.LocalDateTime;

public sealed interface OfferCalculationStrategy permits PlatinumOfferCalculationStrategy, RegularOfferCalculationStrategy, GoldOfferCalculationStrategy{
    int calculateOfferPrice(RoomDto room, LocalDateTime startTime, LocalDateTime endTime);
}

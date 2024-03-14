package adp.resilience.room.service.model;

import adp.resilience.common.model.PriceType;

public record RoomPriceDto(
    PriceType type,
    double price
) {}

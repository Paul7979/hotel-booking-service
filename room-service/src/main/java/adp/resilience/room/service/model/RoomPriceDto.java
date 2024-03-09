package adp.resilience.room.service.model;

public record RoomPriceDto(
    PriceType type,
    double price
) {}

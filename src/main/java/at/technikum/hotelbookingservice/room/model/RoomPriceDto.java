package at.technikum.hotelbookingservice.room.model;

public record RoomPriceDto(
    PriceType type,
    double price
) {}

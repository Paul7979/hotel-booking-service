package adp.resilience.gateway.model.dto;

public record RoomDto(long id,
    String name,
    int capacity,
    String amenities) {
}

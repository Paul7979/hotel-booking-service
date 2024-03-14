package adp.resilience.room.service.model;

public record RoomDto(long id,
                      String name,
                      int capacity,
                      String amenities) {
}

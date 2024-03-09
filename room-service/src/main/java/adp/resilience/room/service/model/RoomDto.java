package adp.resilience.room.service.model;

import java.util.List;

public record RoomDto(long id,
                      String name,
                      int capacity,
                      String amenities) {
}

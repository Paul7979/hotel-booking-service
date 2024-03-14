package adp.resilience.booking.service.web.adapter.model.response;

public record RoomResponseModel(
        Long id,
        String name,
        Integer capacity,
        String amenities
) {
}

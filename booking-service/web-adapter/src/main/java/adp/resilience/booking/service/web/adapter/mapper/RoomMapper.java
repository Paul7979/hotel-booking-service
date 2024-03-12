package adp.resilience.booking.service.web.adapter.mapper;

import adp.resilience.booking.service.web.adapter.model.response.RoomResponseModel;
import adp.resilience.common.model.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface RoomMapper {

    @Mapping(target = "prices", ignore = true)
    @Mapping(target = "bookings", ignore = true)
    Room mapToRoom(RoomResponseModel roomResponseModel);
}

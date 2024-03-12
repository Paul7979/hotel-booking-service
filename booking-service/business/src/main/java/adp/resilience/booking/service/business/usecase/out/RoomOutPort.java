package adp.resilience.booking.service.business.usecase.out;

import adp.resilience.common.model.Room;

public interface RoomOutPort {
    Room getRoom(Long id);
}

package adp.resilience.booking.service.chain;

import adp.resilience.booking.service.controller.model.request.BookRoomRequestModel;

public interface BookRoomChain {
    void bookRoom(BookRoomRequestModel booking);
}

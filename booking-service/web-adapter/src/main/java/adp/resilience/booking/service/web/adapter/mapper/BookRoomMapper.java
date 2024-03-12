package adp.resilience.booking.service.web.adapter.mapper;

import adp.resilience.booking.service.business.usecase.BookRoomInPort;
import adp.resilience.booking.service.web.adapter.model.request.BookRoomRequestModel;
import adp.resilience.booking.service.web.adapter.model.response.BookRoomResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface BookRoomMapper {

    @Mapping(source = "bookingInfo", target = "booking")
    BookRoomInPort.BookRoomRequest mapToBookRoomRequest(BookRoomRequestModel bookRoomRequestModel);

    @Mapping(source = "booking", target = ".")
    @Mapping(source = "booking.id", target = "bookingId")
    BookRoomResponseModel mapToBookRoomResponseModel(BookRoomInPort.BookRoomResponse bookRoomResponse);

}

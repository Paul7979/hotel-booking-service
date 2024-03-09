package adp.resilience.booking.service.business.usecase;

import adp.resilience.booking.service.chain.BookRoomChain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookRoomUseCase implements BookRoomInPort{
    private final BookRoomChain bookRoomChain;

    @Override
    public BookRoomResponse bookRoom(BookRoomRequest request) {

        return null;
    }
}

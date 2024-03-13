package adp.resilience.gateway.service.web.adapter.controller.rest;

import adp.resilience.gateway.service.web.adapter.service.GatewayRoomService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class GatewayRestController {

    private final GatewayRoomService roomService;

    public GatewayRestController(@Qualifier("roomService") GatewayRoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/rooms")
    public String getRooms() throws IOException, InterruptedException {
        return this.roomService.getRooms();
    }

}

package adp.resilience.gateway.controller.rest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import adp.resilience.gateway.service.GatewayRoomService;

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

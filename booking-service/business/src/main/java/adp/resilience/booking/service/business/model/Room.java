package adp.resilience.booking.service.business.model;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private Long id;

    private String name;

    private int capacity;

    private String amenities;

    private List<Booking> bookings = new ArrayList<>();

    private List<RoomPrice> prices = new ArrayList<>();
}

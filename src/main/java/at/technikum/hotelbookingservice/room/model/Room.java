package at.technikum.hotelbookingservice.room.model;
import at.technikum.hotelbookingservice.booking.model.Booking;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Room {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private int capacity;

  private String amenities;

  @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
  private List<Booking> bookings = new ArrayList<>();

  @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
  private List<RoomPrice> prices = new ArrayList<>();

}

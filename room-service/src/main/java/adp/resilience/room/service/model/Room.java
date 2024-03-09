package adp.resilience.room.service.model;
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
  private List<RoomPrice> prices = new ArrayList<>();

}
package adp.resilience.room.service.persistence.model.jpa;

import adp.resilience.common.model.RoomPrice;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class JpaRoomPrice extends RoomPrice {

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private JpaRoom jpaRoom;
}

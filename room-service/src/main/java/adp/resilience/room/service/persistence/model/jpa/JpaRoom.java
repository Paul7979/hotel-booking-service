package adp.resilience.room.service.persistence.model.jpa;

import adp.resilience.common.model.Room;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class JpaRoom extends Room {

    @OneToMany(mappedBy = "jpaRoom", cascade = CascadeType.ALL)
    private List<JpaRoomPrice> jpaPrices;
}

package adp.resilience.common.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.util.ProxyUtils;

import java.util.List;
import java.util.Objects;

@MappedSuperclass
@Getter
@SuperBuilder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int capacity;

    private String amenities;

    @Transient
    private List<RoomPrice> prices;

    @Transient
    private List<Booking> bookings;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || ProxyUtils.getUserClass(this) != ProxyUtils.getUserClass(o))
            return false;
        Room room = (Room) o;
        return getId() != null && Objects.equals(getId(), room.getId());
    }

    @Override
    public final int hashCode() {
        return ProxyUtils.getUserClass(this).hashCode();
    }
}

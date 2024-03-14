package adp.resilience.common.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

import java.util.Objects;

@MappedSuperclass
@Getter
@SuperBuilder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RoomPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private Room room;

    @Enumerated(EnumType.STRING)
    private PriceType type;

    private int price;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || ProxyUtils.getUserClass(this) != ProxyUtils.getUserClass(o))
            return false;
        RoomPrice roomPrice = (RoomPrice) o;
        return getId() != null && Objects.equals(getId(), roomPrice.getId());
    }

    @Override
    public final int hashCode() {
        return ProxyUtils.getUserClass(this).hashCode();
    }
}

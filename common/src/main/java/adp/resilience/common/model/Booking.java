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

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@SuperBuilder
@ToString
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private Room room;

    private Long roomId;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String guestName;

    private String paymentStatus;

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || ProxyUtils.getUserClass(this) != ProxyUtils.getUserClass(o))
            return false;
        Booking booking = (Booking) o;
        return getId() != null && Objects.equals(getId(), booking.getId());
    }

    @Override
    public final int hashCode() {
        return ProxyUtils.getUserClass(this).hashCode();
    }
}

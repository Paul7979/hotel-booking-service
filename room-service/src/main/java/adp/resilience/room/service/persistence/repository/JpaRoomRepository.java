package adp.resilience.room.service.persistence.repository;


import adp.resilience.room.service.persistence.model.jpa.JpaRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface JpaRoomRepository extends ListCrudRepository<JpaRoom, Long>, JpaRepository<JpaRoom, Long> {

}

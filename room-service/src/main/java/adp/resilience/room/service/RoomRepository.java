package adp.resilience.room.service;


import adp.resilience.room.service.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface RoomRepository extends ListCrudRepository<Room, Long>, JpaRepository<Room, Long> {

}

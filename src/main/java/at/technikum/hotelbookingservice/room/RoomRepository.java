package at.technikum.hotelbookingservice.room;

import at.technikum.hotelbookingservice.room.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface RoomRepository extends ListCrudRepository<Room, Long>, JpaRepository<Room, Long> {

}

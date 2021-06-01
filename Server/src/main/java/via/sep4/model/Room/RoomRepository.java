package via.sep4.model.Room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findByRoomname(String roomname);
}

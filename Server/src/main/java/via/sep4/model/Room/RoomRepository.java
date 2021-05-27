package via.sep4.model.Room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import via.sep4.model.Sensor.Sensor;
@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findOne(String roomname);
}

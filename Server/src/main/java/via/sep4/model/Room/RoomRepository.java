package via.sep4.model.Room;

import org.springframework.data.jpa.repository.JpaRepository;
import via.sep4.model.Sensor.Sensor;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}

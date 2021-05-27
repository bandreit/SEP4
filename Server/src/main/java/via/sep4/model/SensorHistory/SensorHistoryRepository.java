package via.sep4.model.SensorHistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import via.sep4.model.Sensor.Sensor;

@Repository
public interface SensorHistoryRepository extends JpaRepository<Sensor, Long> {
}
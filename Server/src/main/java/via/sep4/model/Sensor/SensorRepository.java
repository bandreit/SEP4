package via.sep4.model.Sensor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface SensorRepository extends JpaRepository<Sensor, Long> {
}
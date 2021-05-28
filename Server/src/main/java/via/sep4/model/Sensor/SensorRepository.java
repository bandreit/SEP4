package via.sep4.model.Sensor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Component
public interface SensorRepository extends JpaRepository<Sensor, Long> {
}
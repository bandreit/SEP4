package via.sep4.model.Sensor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * The interface Sensor repository. It contains methods for performing CRUD operations,
 *  * sorting and paginating data
 */
@Component
public interface SensorRepository extends JpaRepository<Sensor, Long> {
}
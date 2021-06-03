package via.sep4.model.SensorHistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Sensor history repository. It contains methods for performing CRUD operations,
 *  * sorting and paginating data
 */
@Repository
public interface SensorHistoryRepository extends JpaRepository<SensorHistory, Long> {
}
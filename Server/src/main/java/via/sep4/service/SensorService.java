package via.sep4.service;

import org.springframework.stereotype.Service;
import via.sep4.model.Sensor.Sensor;
import via.sep4.model.Sensor.SensorRepository;
import via.sep4.model.SensorHistory.SensorHistoryRepository;

/**
 * The type Sensor service.
 */
@Service
public class SensorService {
    private final SensorRepository repository;
    private SensorHistoryRepository historyRepository;

    /**
     * Instantiates a new Sensor service.
     *
     * @param repository        the repository
     * @param historyRepository the history repository
     */
    public SensorService(SensorRepository repository, SensorHistoryRepository historyRepository) {
        this.repository = repository;
        this.historyRepository = historyRepository;
    }

    /**
     * Updates the min and max values of a sensor.
     *
     * @param id  the id
     * @param min the min
     * @param max the max
     */
    public void update(long id, double min, double max) {
        Sensor sensor = repository.getOne(id);
        sensor.setMaxValue(max);
        sensor.setMinValue(min);
        repository.save(sensor);
    }

}
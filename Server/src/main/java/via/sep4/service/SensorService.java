package via.sep4.service;

import org.springframework.stereotype.Service;
import via.sep4.model.Room.Room;
import via.sep4.model.Room.RoomRepository;
import via.sep4.model.Sensor.Sensor;
import via.sep4.model.Sensor.SensorRepository;

import java.util.List;

@Service
public class SensorService {
    private final SensorRepository repository;

    public SensorService(SensorRepository repository) {
        this.repository = repository;
    }

    public void update(long id, double min, double max) {
        Sensor sensor = repository.getOne(id);
        sensor.setMaxValue(max);
        sensor.setMinValue(min);
        repository.save(sensor);
    }
}

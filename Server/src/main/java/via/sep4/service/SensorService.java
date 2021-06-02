package via.sep4.service;

import org.springframework.stereotype.Service;
import via.sep4.model.Room.Room;
import via.sep4.model.Room.RoomRepository;
import via.sep4.model.Sensor.Sensor;
import via.sep4.model.Sensor.SensorRepository;
import via.sep4.model.SensorHistory.SensorHistory;
import via.sep4.model.SensorHistory.SensorHistoryRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class SensorService {
    private final SensorRepository repository;
    private SensorHistoryRepository historyRepository;

    public SensorService(SensorRepository repository, SensorHistoryRepository historyRepository) {
        this.repository = repository;
        this.historyRepository = historyRepository;
    }

    public void update(long id, double min, double max) {
        Sensor sensor = repository.getOne(id);
        sensor.setMaxValue(max);
        sensor.setMinValue(min);
        repository.save(sensor);
    }

}
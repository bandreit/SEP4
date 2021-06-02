package via.sep4.service;

import org.springframework.stereotype.Service;
import via.sep4.model.Charts.Chart;
import via.sep4.model.Charts.SensorValue;
import via.sep4.model.Room.Room;
import via.sep4.model.Room.RoomRepository;
import via.sep4.model.Sensor.Sensor;
import via.sep4.model.Sensor.SensorRepository;
import via.sep4.model.Sensor.SensorType;
import via.sep4.model.SensorHistory.SensorHistory;
import via.sep4.model.SensorHistory.SensorHistoryRepository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.*;

@Service
public class SensorHistoryService {
    private final RoomRepository roomRepository;

    public SensorHistoryService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Chart> getSensorsHistoryByPeriod(long id, int period) {
        List<Chart> charts = new ArrayList<>();
        Room room = roomRepository.findByRoomidIs(id);

        // create a date that is X(period) days ago
        LocalDate date = LocalDate.now().minusDays(period);
        Date periodDate = java.sql.Date.valueOf(date);

        // get all the sensors in the room
        for (Sensor sensor : room.getSensors()) {
            Chart sensorChart = new Chart();
            sensorChart.setRoomId(room.getRoomid());
            sensorChart.setSensorId(sensor.getSensorID());
            sensorChart.setName(sensor.getSensorType());

            // get all their history
            List<SensorValue> sensorValues = new ArrayList<>();
            for (SensorHistory sensorHistory : sensor.getHistory()) {

                // check if the history for the sensor is within our needed period
                if (sensorHistory.getTimestamp().after(periodDate)) {

                    // new SensorValue class to make the timestamp and value together
                    SensorValue sensorValue = new SensorValue(sensorHistory.getValue(), sensorHistory.getTimestamp().getTime());
                    sensorValues.add(sensorValue);
                }
            }
            sensorChart.setValues(sensorValues);
            charts.add(sensorChart);
        }
        return charts;
    }
}

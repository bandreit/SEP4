package via.sep4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import via.sep4.model.Room.Room;
import via.sep4.model.Room.RoomRepository;
import via.sep4.model.Sensor.Sensor;
import via.sep4.model.Sensor.SensorRepository;
import via.sep4.model.Sensor.SensorType;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);


    @Bean
    CommandLineRunner initDatabase(SensorRepository sensorRepository, RoomRepository roomRepository) {
        return args -> {
            Room room = new Room("Freezer");
            Room room1 = new Room("Main");
            roomRepository.save(room);
            roomRepository.save(room1);


            Sensor sensor1 = new Sensor(SensorType.TEMPERATURE, "°C", room);
            Sensor sensor2 = new Sensor(SensorType.HUMIDITY, "%", room);
            Sensor sensor3 = new Sensor(SensorType.CO2, "PPM", room);
            Sensor sensor4 = new Sensor(SensorType.TEMPERATURE, "°C", room1);
            Sensor sensor5 = new Sensor(SensorType.HUMIDITY, "%", room1);
            Sensor sensor6 = new Sensor(SensorType.CO2, "PPM", room1);
            sensorRepository.save(sensor1);
            sensorRepository.save(sensor2);
            sensorRepository.save(sensor3);
            sensorRepository.save(sensor4);
            sensorRepository.save(sensor5);
            sensorRepository.save(sensor6);
        };
    }
}

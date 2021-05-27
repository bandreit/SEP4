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
//            Room room = new Room("Freezer");
//            Room room1 = new Room("Main");
//            roomRepository.save(room);
//            roomRepository.save(room1);
//
//            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//            Date date = dateFormat.parse("23/09/2007");
//            long time = date.getTime();
//            Timestamp timestamp = new Timestamp(time);
//            SensorType sensorType = SensorType.valueOf("TEMPERATURE");
//            Sensor sensor1 = new Sensor(sensorType, "Celcius", 43, timestamp, room);
//            Sensor sensor2 = new Sensor(sensorType, "Celcius", 99, timestamp, room1);
//            sensorRepository.save(sensor1);
//            sensorRepository.save(sensor2);
        };
    }
}

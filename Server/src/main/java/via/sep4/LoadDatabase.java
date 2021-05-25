package via.sep4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import via.sep4.model.Parameter;
import via.sep4.model.ParameterRepository;
import via.sep4.model.SensorType;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ParameterRepository parameterRepo) {
        return args -> {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = dateFormat.parse("23/09/2007");
            long time = date.getTime();
            Timestamp timestamp = new Timestamp(time);
            SensorType sensorType = SensorType.valueOf("TEMPERATURE");
            Parameter parameter = new Parameter(sensorType, "Celcius",12,timestamp);
            log.info("Preloading " + parameterRepo.save(parameter));
        };
    }
}

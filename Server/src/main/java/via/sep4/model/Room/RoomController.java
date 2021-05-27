package via.sep4.model.Room;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import via.sep4.model.Sensor.Sensor;
import via.sep4.model.Sensor.SensorRepository;

import java.util.List;

@RequestMapping("/SEP4")
@RestController
public class RoomController {
    private final RoomRepository repository;

    RoomController(RoomRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/rooms")
    List<Room> all() {
        return repository.findAll();
    }

}

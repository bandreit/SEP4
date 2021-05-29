package via.sep4.model.Room;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import via.sep4.model.Sensor.Sensor;
import via.sep4.model.Sensor.SensorRepository;
import via.sep4.service.RoomService;

import java.util.List;

@RequestMapping("/SEP4")
@RestController
public class RoomController {
    private final RoomService roomService;

    RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/rooms")
    List<Room> all() {
        return roomService.findAll();
    }
}

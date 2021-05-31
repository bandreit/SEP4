package via.sep4.model.Sensor;

import org.springframework.web.bind.annotation.*;
import via.sep4.service.SensorService;

import java.util.List;

@RequestMapping("/SEP4")
@RestController
public class SensorController {
    private final SensorService service;

    SensorController(SensorService service) {
        this.service = service;
    }

    @PutMapping("/sensor/{id}")
    public void update(@PathVariable long id, @RequestParam double min, @RequestParam double max) {
        service.update(id, min, max);
    }

}

package via.sep4.model.Sensor;

import org.springframework.web.bind.annotation.*;
import via.sep4.service.SensorService;

/**
 * The type Sensor controller.
 */
@RequestMapping("/SEP4")
@RestController
public class SensorController {
    private final SensorService service;

    /**
     * Instantiates a new Sensor controller.
     *
     * @param service the service
     */
    SensorController(SensorService service) {
        this.service = service;
    }

    /**
     * Updates the min and max values for a sensor.
     *
     * @param id  the id
     * @param min the min
     * @param max the max
     */
    @PutMapping("/sensor/{id}")
    public void update(@PathVariable long id, @RequestParam double min, @RequestParam double max) {
        service.update(id, min, max);
    }

}

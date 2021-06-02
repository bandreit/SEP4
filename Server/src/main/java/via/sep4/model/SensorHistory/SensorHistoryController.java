package via.sep4.model.SensorHistory;

import org.springframework.web.bind.annotation.*;
import via.sep4.model.Charts.Chart;
import via.sep4.service.SensorHistoryService;

import java.util.List;

/**
 * The type Sensor history controller.
 */
@RequestMapping("/SEP4")
@RestController
public class SensorHistoryController {
    private final SensorHistoryService service;

    /**
     * Instantiates a new Sensor history controller.
     *
     * @param service the service
     */
    SensorHistoryController(SensorHistoryService service) {
        this.service = service;
    }

    /**
     * Gets the timestamp and value of all sensors from a period of time.
     *
     * @param id     the id
     * @param period the period
     * @return the statistics
     */
    @GetMapping("/sensorHistory/{id}")
    public List<Chart> getStatistics(@PathVariable long id, @RequestParam int period) {
        return service.getSensorsHistoryByPeriod(id, period);
    }

}

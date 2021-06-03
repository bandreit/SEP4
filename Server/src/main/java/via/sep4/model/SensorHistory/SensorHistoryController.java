package via.sep4.model.SensorHistory;

import org.springframework.web.bind.annotation.*;
import via.sep4.model.Charts.DataToSendHistory;
import via.sep4.service.SensorHistoryService;

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
    public DataToSendHistory getStatistics(@PathVariable long id, @RequestParam int period) {
        return service.getSensorsHistoryByPeriod(id, period);
    }

}

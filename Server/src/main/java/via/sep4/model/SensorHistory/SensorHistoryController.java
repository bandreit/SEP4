package via.sep4.model.SensorHistory;

import org.springframework.web.bind.annotation.*;
import via.sep4.model.Charts.Chart;
import via.sep4.service.SensorHistoryService;
import via.sep4.service.SensorService;

import java.util.List;

@RequestMapping("/SEP4")
@RestController
public class SensorHistoryController {
    private final SensorHistoryService service;

    SensorHistoryController(SensorHistoryService service) {
        this.service = service;
    }

    @GetMapping("/sensorHistory/{id}")
    public List<Chart> getStatistics(@PathVariable long id, @RequestParam int period) {
        return service.getSensorHistoryByPeriod(id, period);
    }

}

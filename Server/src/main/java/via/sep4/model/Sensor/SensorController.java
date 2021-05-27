package via.sep4.model.Sensor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/SEP4")
@RestController
public class SensorController {
    private final SensorRepository repository;

    SensorController(SensorRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/sensors")
    List<Sensor> all() {
        return repository.findAll();
    }


//    @PutMapping("/sensor/{id}")
//    Parameter updateSensorMinMaxValues(@RequestBody Parameter newParameter, @PathVariable Long id) {
//        return repository.findById(id)
//                .map(parameter -> {
//                    parameter.setCurrentCo2(parameter.getCurrentCo2());
//                    parameter.setCurrentTemp(parameter.getCurrentTemp());
//                    parameter.setCurrentHum(parameter.getCurrentHum());
//                    return repository.save(parameter);
//                })
//                .orElseGet(() -> {
//                    newParameter.setId(id);
//                    return repository.save(newParameter);
//                });
//    }
}

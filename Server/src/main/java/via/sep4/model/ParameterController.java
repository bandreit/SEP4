package via.sep4.model;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/SEP4")
@RestController
public class ParameterController {
    private final ParameterRepository repository;

    ParameterController(ParameterRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/parameters")
    List<Parameter> all() {
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

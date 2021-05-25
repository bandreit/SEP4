package via.sep4.model;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParameterController {
    private final ParameterRepository repository;

    ParameterController(ParameterRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/parameters")
    List<Parameter> all() {
        List<Parameter> thelist = repository.findAll();
        System.out.println("This is the id of the list 1 object " + thelist.get(0).getId());
        return thelist;
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

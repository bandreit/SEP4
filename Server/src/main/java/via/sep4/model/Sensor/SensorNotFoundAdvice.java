package via.sep4.model.Sensor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Sensor not found advice.
 */
@ControllerAdvice
public class SensorNotFoundAdvice {
    /**
     * Parameter not found handler string.
     *
     * @param ex the ex
     * @return the string
     */
    @ResponseBody
    @ExceptionHandler(SensorNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String parameterNotFoundHandler(SensorNotFoundException ex) {
        return ex.getMessage();
    }
}

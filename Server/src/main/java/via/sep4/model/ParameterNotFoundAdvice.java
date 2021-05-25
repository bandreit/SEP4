package via.sep4.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ParameterNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ParameterNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String parameterNotFoundHandler(ParameterNotFoundException ex) {
        return ex.getMessage();
    }
}

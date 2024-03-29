package via.sep4.model.Room;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Room not found advice.
 */
@ControllerAdvice
public class RoomNotFoundAdvice {
    /**
     * Parameter not found handler string.
     *
     * @param ex the ex
     * @return the string
     */
    @ResponseBody
    @ExceptionHandler(RoomNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String parameterNotFoundHandler(RoomNotFoundException ex) {
        return ex.getMessage();
    }
}

package via.sep4.model;

public class ParameterNotFoundException extends RuntimeException {
    ParameterNotFoundException()
    {
        super("Could not access the parameter");
    }
}

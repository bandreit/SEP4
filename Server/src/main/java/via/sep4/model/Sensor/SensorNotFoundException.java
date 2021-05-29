package via.sep4.model.Sensor;

public class SensorNotFoundException extends RuntimeException {
    SensorNotFoundException()
    {
        super("Could not access the parameter");
    }
}

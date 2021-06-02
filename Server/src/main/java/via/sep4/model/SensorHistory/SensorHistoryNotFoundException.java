package via.sep4.model.SensorHistory;

public class SensorHistoryNotFoundException extends RuntimeException {
    SensorHistoryNotFoundException()
    {
        super("Could not access the parameter");
    }
}

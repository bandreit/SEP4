package via.sep4.utility;

public class DatabaseQueries {
    public static final String GET_SENSOR_FROM_DW = "SELECT sensor_dim.name, sensor_dim.valueType, sensor_dim.value, sensor_dim.timestamp from sensor_dim;";
}
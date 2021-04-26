package via.sep4.persistance;

import utility.persistence.MyDatabase;
import via.sep4.Parameter;
import via.sep4.utility.DatabaseQueries;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class DatabasePersistence implements DatabaseAdaptor {
    private MyDatabase db;

    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres?currentSchema=sep4";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    public DatabasePersistence() {
        try {
            this.db = new MyDatabase(DRIVER, URL, USER, PASSWORD);
            System.out.println("connecting...");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("connection error");
        }
    }

    /**
     * The method is loading all the data for the sensor which are name, unit, value
     * and timestamp from the data warehouse
     * and creates a list with these information
     *
     * @return list
     * @throws SQLException
     */
    @Override
    public List<Parameter> getData() throws SQLException {
        List<Parameter> list = new ArrayList<>();
        ArrayList<Object[]> dataList = db.query(DatabaseQueries.GET_SENSOR_FROM_DW);

        for (int i = 0; i < dataList.size(); i++) {
            Object[] array = dataList.get(i);

            String str = String.valueOf(array[2]);
            double value = Double.parseDouble(str);
            Timestamp timestamp = Timestamp.valueOf(array[3] + "");

            //create the sensor object
            Parameter sensorInfo = new Parameter(String.valueOf(array[0]), String.valueOf(array[1]), value, timestamp.toString());
            list.add(sensorInfo);
        }
        return list;
    }

    @Override
    public Parameter getLastParam() throws SQLException {
        List<Parameter> all = new ArrayList<>(getData());
        List<Parameter> last = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            last.add(all.get(i));
        }
        return last.get(0);
    }
}
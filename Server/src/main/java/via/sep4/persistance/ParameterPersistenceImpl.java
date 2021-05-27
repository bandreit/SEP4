//ackage via.sep4.persistance;


//public class ParameterPersistenceImpl implements ParameterPersistance {
//
//    private static final String URL = "jdbc:sqlserver://localhost\\SEP4;portNumber=1433";
//    private static final String USER = "admin";
//    private static final String PASSWORD = "admin";
//
//    private Connection conn;
//
//    public ParameterPersistenceImpl() {
//        try {
//            conn = DriverManager.getConnection(URL, USER, PASSWORD);
//
//            if (conn != null) {
//                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
//                System.out.println("Driver name: " + dm.getDriverName());
//                System.out.println("Driver version: " + dm.getDriverVersion());
//                System.out.println("Product name: " + dm.getDatabaseProductName());
//                System.out.println("Product version: " + dm.getDatabaseProductVersion());
//            }
//
//            System.out.println("connecting...");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("connection error");
//        }
//    }
//
//    /**
//     * The method is loading all the data for the sensor which are name, unit, value
//     * and timestamp from the data warehouse
//     * and creates a list with these information
//     *
//     * @return list
//     * @throws SQLException
//     */
//    @Override
//    public List<Parameter> getData() throws SQLException {
//        List<Parameter> list = new ArrayList<>();
//        String sql = "select * from SEP4.dbo.Parameter";
//
//        Statement statement = conn.createStatement();
//        ResultSet result = statement.executeQuery(sql);
//
//        while (result.next()) {
//            String value = result.getString("unitType");
//            String name = result.getString("sensorName");
//            Double sensorValue = result.getDouble("sensorValue");
//            Timestamp timestamp = result.getTimestamp("sensorTimeStamp");
//            Parameter parameter = new Parameter(SensorType.valueOf(name), value, sensorValue, timestamp);
//            list.add(parameter);
//            System.out.println(parameter.toString());
//        }
//        return list;
//    }
//
//    @Override
//    public Parameter getLastParam() throws SQLException {
//            List<Parameter> all = new ArrayList<>(getData());
//            List<Parameter> last = new ArrayList<>();
//            for (int i = 0; i < all.size(); i++) {
//                last.add(all.get(i));
//            }
//            return last.get(0);
//    }
//}
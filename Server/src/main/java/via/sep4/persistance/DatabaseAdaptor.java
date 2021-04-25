package via.sep4.persistance;

import via.sep4.Parameter;

import java.sql.SQLException;
import java.util.List;

public interface DatabaseAdaptor {
    List<Parameter> getData() throws SQLException;

    public List<Parameter> getLastParam() throws SQLException;
}
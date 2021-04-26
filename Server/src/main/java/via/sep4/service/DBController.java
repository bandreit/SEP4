package via.sep4.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import via.sep4.Parameter;
import via.sep4.persistance.DatabaseAdaptor;
import via.sep4.persistance.DatabasePersistence;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/SEP4")
public class DBController {
    DatabaseAdaptor db = new DatabasePersistence();

    @GetMapping("/parameters")
    public Parameter getSensorInfo() throws SQLException {
        System.out.println("Data sent to client.");
        return db.getLastParam();
    }

}
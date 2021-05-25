package via.sep4.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import via.sep4.model.Parameter;


import java.sql.SQLException;

//@RestController
//@RequestMapping("/SEP4")
//public class DBController {
//    ParameterPersistance db = new ParameterPersistenceImpl();
//
//    @GetMapping("/parameters")
//    public Parameter getSensorInfo() throws SQLException {
//        System.out.println("Data sent to client.");
//        return db.getLastParam();
//    }
//
//}
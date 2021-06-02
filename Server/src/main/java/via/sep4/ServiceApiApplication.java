package via.sep4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import via.sep4.mediator.ClientConnector;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * The type Service api application.
 */
@SpringBootApplication
public class ServiceApiApplication {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ServiceApiApplication.class);
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("spring.datasource.driver-class-name", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put("spring.datasource.url", "jdbc:sqlserver://ec2-3-124-3-27.eu-central-1.compute.amazonaws.com:10001;DatabaseName=SEP4");
        properties.put("spring.datasource.username", "Admin");
        properties.put("spring.datasource.password", "12345678");
        properties.put("spring.jpa.hibernate.ddl-auto", "create-drop");
        properties.put("spring.jpa.properties.hibernate.default_schema", "dbo");
        properties.put("spring.jpa.properties.hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
        properties.put("spring.jpa.show-sql", "true");
        properties.put("spring.jpa.properties.hibernate.format_sql", "true");
        properties.put("spring.jpa.properties.hibernate.enable_lazy_load_no_trans", "true");
        properties.put("server.port", "10002");
        app.setDefaultProperties(properties);
        app.run(args);

        System.out.println("Service started.");

        try {
            ClientConnector clientConnector = new ClientConnector();
            Thread serverThread = new Thread(clientConnector);
            serverThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

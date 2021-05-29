package via.sep4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import via.sep4.mediator.ClientConnector;

import java.io.IOException;
import java.util.Collections;

@SpringBootApplication
public class ServiceApiApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ServiceApiApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "10001"));
        app.run(args);

        System.out.println("Service started.");

        // jut to test a guess
        try {
            ClientConnector clientConnector = new ClientConnector();
            Thread serverThread = new Thread(clientConnector);
            serverThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

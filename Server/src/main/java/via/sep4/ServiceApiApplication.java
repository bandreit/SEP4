package via.sep4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import via.sep4.mediator.ClientConnector;

import java.io.IOException;

@SpringBootApplication
public class ServiceApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceApiApplication.class, args);
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

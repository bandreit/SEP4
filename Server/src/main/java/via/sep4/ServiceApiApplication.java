package via.sep4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceApiApplication.class, args);
        System.out.println("Service started.");
    }
}

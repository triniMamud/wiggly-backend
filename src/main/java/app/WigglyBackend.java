package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication()
@EntityScan("app.model.entity")
public class WigglyBackend {
    public static void main(String[] args) {
        SpringApplication.run(WigglyBackend.class, args);
    }
}

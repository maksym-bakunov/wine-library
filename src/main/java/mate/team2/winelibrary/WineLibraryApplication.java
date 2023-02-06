package mate.team2.winelibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class WineLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(WineLibraryApplication.class, args);
    }

}

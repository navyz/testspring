package sonlmz.configuration;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sonlmz.repository.EmployeeRepository;

import java.net.URL;
import java.net.URLClassLoader;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {

        return args -> {
            //log.info("Preloading " + repository.save(new Employee("Bilbo Baggins", "burglar")));
            //log.info("Preloading " + repository.save(new Employee("Frodo Baggins", "thief")));
        };
    }

    @Bean
    CommandLineRunner printProjectInfo() {

        return args -> {
            System.out.println("----------------------------------------------");
            ClassLoader cl = ClassLoader.getSystemClassLoader();
            URL[] urls = ((URLClassLoader)cl).getURLs();
            for(URL url: urls){
                System.out.println(url.getFile());
            }
        };


    }
}
package sonlmz.test;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import sonlmz.repository.EmployeeRepository;

@Profile("test")
@Configuration
public class NameServiceTestConfiguration {
    @Bean
    @Primary
    public EmployeeRepository employeeRepository() {
        return Mockito.mock(EmployeeRepository.class);
    }
}

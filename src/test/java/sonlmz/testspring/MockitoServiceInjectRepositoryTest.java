package sonlmz.testspring;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import sonlmz.entity.Employee;
import sonlmz.repository.EmployeeRepository;
import sonlmz.service.EmployeeService;
import sonlmz.service.impl.EmployeeServiceImpl;

import java.util.ArrayList;
import java.util.List;

//@RunWith(MockitoJUnitRunner.class)
@RunWith(SpringRunner.class)
public class MockitoServiceInjectRepositoryTest {

    @MockBean
    EmployeeRepository mockEmployeeRepository;

    @InjectMocks
    EmployeeService employeeService = new EmployeeServiceImpl();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void injectEmployeeRepositoryTest()
    {
        List<Employee> dummyEmployees = new ArrayList<>();
        dummyEmployees.add(new Employee("Test Name 1", "Tester"));
        dummyEmployees.add(new Employee("Test Name 2", "Tester"));
        dummyEmployees.add(new Employee("Test Name 3", "Tester"));

        Mockito.when(mockEmployeeRepository.findAll()).thenReturn(dummyEmployees);

        Assertions.assertEquals(3, employeeService.getAll().size());
        Assertions.assertEquals("Test Name 1", employeeService.getAll().get(0).getName());
        Assertions.assertEquals("Test Name 2", employeeService.getAll().get(1).getName());
        Assertions.assertEquals("Test Name 3", employeeService.getAll().get(2).getName());
        Assertions.assertEquals("Tester", employeeService.getAll().get(0).getRole());
    }

}

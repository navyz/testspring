package sonlmz.test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sonlmz.entity.Employee;
import sonlmz.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MockitoRepositoryTest {
    @Mock
    private EmployeeRepository employeeRepository;

    @BeforeMethod
    public void setup() {
        System.out.println("@BeforeMethod RepositoryTest");
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void mockEmployeeRepositoryTest()
    {
        List<Employee> dummyEmployees = new ArrayList<>();
        dummyEmployees.add(new Employee("Test Name 1", "Tester"));
        dummyEmployees.add(new Employee("Test Name 2", "Tester"));
        dummyEmployees.add(new Employee("Test Name 3", "Tester"));


        when(employeeRepository.findAll()).thenReturn(dummyEmployees);

        assertEquals(3, employeeRepository.findAll().size());
        assertEquals("Test Name 1", employeeRepository.findAll().get(0).getName());
        assertEquals("Test Name 2", employeeRepository.findAll().get(1).getName());
        assertEquals("Test Name 3", employeeRepository.findAll().get(2).getName());
        assertEquals("Tester", employeeRepository.findAll().get(0).getRole());
    }

}

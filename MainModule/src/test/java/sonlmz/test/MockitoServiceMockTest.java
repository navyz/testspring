package sonlmz.test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sonlmz.entity.Employee;
import sonlmz.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MockitoServiceMockTest {
    @Mock
    private EmployeeService employeeService;

    @BeforeMethod
    public void setup() {
        System.out.println("@BeforeMethod RepositoryTest");
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void mockemployeeServiceTest()
    {
        List<Employee> dummyEmployees = new ArrayList<>();
        dummyEmployees.add(new Employee("Test Name 1", "Tester"));
        dummyEmployees.add(new Employee("Test Name 2", "Tester"));
        dummyEmployees.add(new Employee("Test Name 3", "Tester"));

        when(employeeService.getAll()).thenReturn(dummyEmployees);

        assertEquals(3, employeeService.getAll().size());
        assertEquals("Test Name 1", employeeService.getAll().get(0).getName());
        assertEquals("Test Name 2", employeeService.getAll().get(1).getName());
        assertEquals("Test Name 3", employeeService.getAll().get(2).getName());
        assertEquals("Tester", employeeService.getAll().get(0).getRole());
    }

}

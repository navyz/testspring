package sonlmz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sonlmz.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
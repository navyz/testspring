package sonlmz.service.impl;

import org.springframework.stereotype.Service;
import sonlmz.entity.Employee;
import sonlmz.repository.EmployeeRepository;
import sonlmz.service.EmployeeService;

import javax.annotation.Resource;
import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}

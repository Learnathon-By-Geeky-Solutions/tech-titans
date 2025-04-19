package Job.Portal.System.service;

import Job.Portal.System.model.Employee;
import Job.Portal.System.model.User;
import Job.Portal.System.repository.EmployeeRepository;
import Job.Portal.System.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    // Inject the EmployeeRepository bean
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee registerEmployee(Employee employee) {
        return employeeRepository.save(employee);  // Save and return the registered employee.
    }


    @Override
    public Employee updateEmployeeProfile(Employee employee) {
        return employeeRepository.save(employee);  // Save and return the updated employee profile.
    }

    @Override
    public Employee findByUser(User user) {
        return employeeRepository.findByUser(user);  // Find and return the employee associated with the given user.
    }
}

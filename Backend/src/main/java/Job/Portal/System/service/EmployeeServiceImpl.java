package Job.Portal.System.service;

import Job.Portal.System.model.Employee;
import Job.Portal.System.model.User;
import Job.Portal.System.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * This method saves the employee object to the repository and returns the saved employee
     */
    @Override
    public Employee registerEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


    /**
     * This method updates the employee's profile by saving the changes to the repository
     */

    @Override
    public Employee updateEmployeeProfile(Employee employee) {
        return employeeRepository.save(employee);
    }

    /**
     * This method retrieves an employee from the repository using the associated user object
     */

    @Override
    public Employee findByUser(User user) {
        return employeeRepository.findByUser(user);
    }
}

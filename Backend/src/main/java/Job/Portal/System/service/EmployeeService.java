package Job.Portal.System.service;

import Job.Portal.System.model.Employee;
import Job.Portal.System.model.User;

public interface EmployeeService {


    // Method to register a new employee
    Employee registerEmployee(Employee employee);


    // Method to update an employee's profile
    Employee updateEmployeeProfile(Employee employee);


    // Method to find an employee by their associated user
    Employee findByUser(User user);
}

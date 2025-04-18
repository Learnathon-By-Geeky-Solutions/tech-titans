package Job.Portal.System.service;

import Job.Portal.System.model.Employee;
import Job.Portal.System.model.User;

public interface EmployeeService {

    Employee registerEmployee(Employee employee);

    Employee updateEmployeeProfile(Employee employee);

    Employee findByUser(User user);
}

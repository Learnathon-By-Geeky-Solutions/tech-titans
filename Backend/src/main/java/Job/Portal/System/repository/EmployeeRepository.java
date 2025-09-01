package Job.Portal.System.repository;

import Job.Portal.System.model.Employee;
import Job.Portal.System.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


//         Find an employee by their associated user.

            Employee findByUser(User user);
}

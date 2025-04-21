package Job.Portal.System.controller;

import Job.Portal.System.model.Employee;
import Job.Portal.System.model.User;
import Job.Portal.System.service.EmployeeService;
import Job.Portal.System.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    // Logger for logging purposes
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Employee> registerEmployee(@RequestBody Employee employee) {
        User user = userService.registerUser(employee.getUser());
        employee.setUser(user);
        Employee registeredEmployee = employeeService.registerEmployee(employee);
        return ResponseEntity.ok(registeredEmployee);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployeeProfile(@RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployeeProfile(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Employee> getEmployeeByUserId(@PathVariable Long userId) {
        logger.info("Fetching employee for user with ID: {}", userId);  // Log the operation
        Optional<User> user = userService.findById(userId);
        // Check if the user is found
        if (user.isPresent()) {
            Employee employee = employeeService.findByUser(user.get());
            if (employee != null) {
                logger.info("Found employee for user with ID: {}", userId);  // Log success
                return ResponseEntity.ok(employee);
            } else {
                logger.warn("Employee not found for user with ID: {}", userId);  // Log warning
                return ResponseEntity.notFound().build();
            }
        } else {
            logger.warn("User with ID {} not found", userId);  // Log warning if user not found
            return ResponseEntity.notFound().build(); // Return 404 response
        }
    }
}

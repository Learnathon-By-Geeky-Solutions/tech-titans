package Job.Portal.System.controller;

import Job.Portal.System.model.Employee;
import Job.Portal.System.model.User;
import Job.Portal.System.service.EmployeeService;
import Job.Portal.System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

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
        Optional<User> user = userService.findById(userId);
        if (user.isPresent()) {
            Employee employee = employeeService.findByUser(user.get());
            if (employee != null) {
                return ResponseEntity.ok(employee);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

package Job.Portal.System.service;

import Job.Portal.System.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public interface UserService {

    // Method to register a new user
    User registerUser(User user);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    // Method to find a user by their ID
    Optional<User> findById(Long id);

    // Method to find a user by their username
    User findByUsername(String username);

    // Method to find a user by their email
    User findByEmail(String email);
}

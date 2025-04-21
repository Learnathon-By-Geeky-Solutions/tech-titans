package Job.Portal.System.service;

import Job.Portal.System.model.User;
import Job.Portal.System.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * This method registers a new user in the system after checking for existing usernames and emails.
     */
    @Override
    public User registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("Username already exists");
        }
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Email already exists");
        }

        // Encode the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    /**
     * Load user by username
     * This method loads a user by their username for authentication purposes.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);  // Find the user by username
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        // Return a UserDetails object for Spring Security
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }

    /**
     * This method finds a user by their ID.
     */
    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
    /**
     * This method finds a user by their username.
     */
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * This method finds a user by their email.
     */
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}

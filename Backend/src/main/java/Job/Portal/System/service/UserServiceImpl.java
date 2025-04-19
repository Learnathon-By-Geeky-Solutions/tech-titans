package Job.Portal.System.service;

import Job.Portal.System.model.User;
import Job.Portal.System.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("Username already exists");
        }
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Email already exists");
        }
        return userRepository.save(user);
    }


     // This method finds a user by their ID.

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }



    // This method finds a user by their username.
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    //This method finds a user by their email.
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}

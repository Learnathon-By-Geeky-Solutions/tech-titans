package Job.Portal.System.service;

import Job.Portal.System.model.User;
import java.util.Optional;

public interface UserService {

    User registerUser(User user);

    Optional<User> findById(Long id);

    User findByUsername(String username);

    User findByEmail(String email);
}

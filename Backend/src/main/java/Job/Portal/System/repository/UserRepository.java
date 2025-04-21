package Job.Portal.System.repository;

import Job.Portal.System.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Find a user by their username.
     */
    User findByUsername(String username);

    /**
     * Find a user by their email address.
     */
    User findByEmail(String email);
}

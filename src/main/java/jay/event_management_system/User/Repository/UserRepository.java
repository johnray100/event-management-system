package jay.event_management_system.User.Repository;

import jay.event_management_system.User.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Find a user by email (for authentication or registration validation)
    Optional<User> findByEmail(String email);

    // Check if a user with a specific email exists
    boolean existsByEmail(String email);
}

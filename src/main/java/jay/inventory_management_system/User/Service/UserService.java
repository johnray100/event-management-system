package jay.inventory_management_system.User.Service;

import jay.inventory_management_system.User.Model.User;
import jay.inventory_management_system.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Hash the password
        userRepository.save(user);
    }
}

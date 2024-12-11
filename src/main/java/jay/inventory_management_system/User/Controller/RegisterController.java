package jay.inventory_management_system.User.Controller;

import jay.inventory_management_system.User.Model.User;
import jay.inventory_management_system.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService; // Replace with your actual service for user management

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        userService.registerUser(user); // Save the user to the database
        return "redirect:/login"; // Redirect to the login page after registration
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "views/frontend/register"; // Render the register form
    }
}

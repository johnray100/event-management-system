package jay.event_management_system;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("activePage", "dashboard");
        return "views/backend/dashboard/index";
    }
}

package study.santoliver.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import study.santoliver.services.LoggedUserManagementService;

@Controller
public class MainController {

    private final LoggedUserManagementService loggedUserManagementService;

    public MainController(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }

    @GetMapping("/main")
    public String home() {
        String username = loggedUserManagementService.getUsername();

        if (username == null) {
            return "redirect:/";
        }

        return "main.html";
    }

}

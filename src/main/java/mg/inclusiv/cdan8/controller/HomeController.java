package mg.inclusiv.cdan8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        String message = "Hello, Thymeleaf!";
        model.addAttribute("message", message);
        return "index";
    }
}
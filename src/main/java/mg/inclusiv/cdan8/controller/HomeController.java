package mg.inclusiv.cdan8.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("")
    public String example(Model model){
        String message = "Hello, Thymeleaf!";
        // ModelAndView modelAndView = new ModelAndView("index");
        // modelAndView.addObject("message", message);
        model.addAttribute("message", message);
        return "index";
        
    }
}

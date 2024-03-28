package mg.inclusiv.cdan8.controller;

import mg.inclusiv.cdan8.Services.TacheService;
import mg.inclusiv.cdan8.entity.Tache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/dashboard")

public class TachesController {
    
    TacheService tacheService;
    @GetMapping("")
    public String viewhome(Model model) {
        //List<Tache> tacheList= tacheService.tacheList();
        //model.addAttribute("tacheList", tacheList);
        return "dashboard";
    }
}

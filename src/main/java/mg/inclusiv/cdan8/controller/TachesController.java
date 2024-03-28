package mg.inclusiv.cdan8.controller;


import mg.inclusiv.cdan8.Services.TacheService;
import mg.inclusiv.cdan8.entity.Tache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TachesController {
    @Autowired
    TacheService tacheService;
    @GetMapping("/")
    public String viewhome(Model model) {
       List<Tache> tacheList= tacheService.tacheList();
        model.addAttribute("tacheList", tacheList);
        return "dasboard";
    }
}

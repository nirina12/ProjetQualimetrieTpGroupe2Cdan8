package mg.inclusiv.cdan8.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import mg.inclusiv.cdan8.Services.TacheService;
import mg.inclusiv.cdan8.entity.Tache;

@Controller
public class TachesController {
    @Autowired
    TacheService tacheService;
    
    @GetMapping("/viewhome")
    public String viewhome(Model model) {
       List<Tache> tacheList= tacheService.tacheList();
        model.addAttribute("tacheList", tacheList);
        return "dasboard";
    }
}

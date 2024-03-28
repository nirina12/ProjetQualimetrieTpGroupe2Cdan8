package mg.inclusiv.cdan8.controller;


import java.util.List;

import mg.inclusiv.cdan8.repository.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import mg.inclusiv.cdan8.Services.TacheService;
import mg.inclusiv.cdan8.entity.Tache;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/dashboard")
public class TachesController {
    @Autowired
    TacheRepository tacheRepository;

    @GetMapping("/list")
    public String listTache(Model model) {
        List<Tache> tacheList = tacheRepository.findAll();
        model.addAttribute("tacheList", tacheList);
        return "dashboard";
    }
    @PostMapping("/save")
    public void saveTache(Tache tache){
        tacheRepository.save(tache);
    }
    @PostMapping("/update")
    public void Modif(long id){
        tacheRepository.getById(id);
    }
    @PostMapping("/delete")
    public void del(long id){
        tacheRepository.deleteById(id);
    }
}

package mg.inclusiv.cdan8.controller;

import java.util.List;

import mg.inclusiv.cdan8.Services.TacheService;
import mg.inclusiv.cdan8.repository.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.JmsProperties.Listener.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import mg.inclusiv.cdan8.entity.Tache;
import mg.inclusiv.cdan8.entity.Utilisateur;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/dashboardtache")
public class TachesController {
    @Autowired
    private HttpSession session;

    @Autowired
    TacheRepository tacheRepository;

    @Autowired
    TacheService tacheService;

    @GetMapping("")
    public String listTache(Model model) {
        if (session != null && session.getAttribute("user") != null){
            Utilisateur currentUser = (Utilisateur) session.getAttribute("user");
            model.addAttribute("tacheList",tacheService.getAllByIdUser(currentUser.getUtilisateur_id()) );
            return "dashboard";
        }else{
            System.out.println("non");
            return "/";
        }

        
    }

    @PostMapping("/save")
    public void saveTache(Tache tache){
        tacheRepository.save(tache);
    }
    @PostMapping("/update")
    public void Modif(@RequestBody Tache tache){
        tacheService.modifier(tache);
    }

    @PostMapping("updateEtatTache")
    public void modifierEtatTache(Tache tache) {tacheService.modifierEtatTache(tache);}
    
    @PostMapping("/delete")
    public void del(long id){
        tacheRepository.deleteById(id);
    }
}

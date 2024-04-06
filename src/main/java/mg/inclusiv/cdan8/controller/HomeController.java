package mg.inclusiv.cdan8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.session.*;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mg.inclusiv.cdan8.Services.UtilisateurService;
import mg.inclusiv.cdan8.entity.Utilisateur;
import mg.inclusiv.cdan8.repository.UtilisateurRepository;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private HttpSession session;
    
    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    UtilisateurService utilisateurService;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "index";
    }

    @PostMapping("/authentification")
    public RedirectView authentification(@RequestParam String mailUser,@RequestParam String password, HttpSession session,Model model ) {        
        Utilisateur currentUser = utilisateurService.authentUser(mailUser, password);
        if (currentUser!=null) {
            session.setAttribute("user", currentUser);
            model.addAttribute("utilisateur", currentUser.toString());
            return new RedirectView("/dashboardtache");
        }else{
            model.addAttribute("NotificationError", "Erreur D'authentification");
            return new RedirectView("/");
        }
    }

    // Invalider la session de l'utilisateur
    @GetMapping("/logout")
    public RedirectView logout(HttpSession session) {
        
        session.invalidate();
        return new RedirectView("/") ;
    }

    @GetMapping ("/inscription")
    public String inscription(Model model,Utilisateur utilisateur){
        return "inscription";
    }

    @PostMapping ("/inscriptionUtilisateur")
    public RedirectView inscription(@ModelAttribute Utilisateur utilisateur,@RequestParam String confirmPassword, Model model ) {
        
        if (utilisateur.getPassword().equals(confirmPassword)) {
            model.addAttribute("message","Succés///");
            utilisateurService.signupUtilisateur(utilisateur);
            return new RedirectView("/");
        }else{
            model.addAttribute("NotificationError", "Erreur D'authentification");

            return new RedirectView("/");
        }
    }}


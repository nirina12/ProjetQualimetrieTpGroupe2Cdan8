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

import mg.inclusiv.cdan8.entity.Utilisateur;
import mg.inclusiv.cdan8.repository.UtilisateurRepository;


import java.util.List;

@Controller
public class HomeController {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @RequestMapping("/")
    public String home(Model model) {
        //String message = "Hello, Thymeleaf!";
        model.addAttribute("utilisateur", new Utilisateur());
        return "index";
    }

    @PostMapping("/authentification")
    public RedirectView authentification(@RequestParam String mailUser,@RequestParam String password, HttpSession session,Model model ) {
        Utilisateur currentUser = authentUser(mailUser, password);
        if (currentUser!=null) {
            session.setAttribute("user", currentUser.toString());
            model.addAttribute("utilisateur", currentUser.toString());
            return new RedirectView("/dashboard");
        }else{
            model.addAttribute("NotificationError", "Erreur D'authentification");
            return new RedirectView("/");
        }
    }

    @GetMapping("/logout")
    public RedirectView logout(HttpSession session) {
        // Invalider la session de l'utilisateur
        session.invalidate();
        return new RedirectView("/") ;
    }

    private Utilisateur authentUser(String emailUser, String password){
        List <Utilisateur> users= utilisateurRepository.authentificationUser(emailUser, password);
        
        Utilisateur currentUser = null;
        if (users.isEmpty()) {
            currentUser=users.get(0);
        }
        
        return currentUser;
    }

    @GetMapping ("/inscription")
    public String inscription(Model model,Utilisateur utilisateur){
        model.addAttribute("message","Bonjour");
        return "inscription";
    }

    @PostMapping ("/inscriptionUtilisateur")
    public RedirectView inscription(@ModelAttribute Utilisateur utilisateur,@RequestParam String confirmPassword, Model model ) {
        //Utilisateur currentUser = authentUser(mailUser, password);
        System.out.println(utilisateur.toString());
        System.out.println(confirmPassword);
        if (utilisateur.getPassword().equals(confirmPassword)) {
            System.out.println("oui");
            model.addAttribute("message","Succés///");

            utilisateurRepository.save(utilisateur);
            //utilisateurRepository.inscriptionUtilisateur(utilisateur.getEmail(), utilisateur.getLastname(), utilisateur.getName(), utilisateur.getPassword());
            ;  //model.addAttribute("utilisateur", currentUser.toString());
            return new RedirectView("/");
        }else{
            System.out.println("non");
            model.addAttribute("NotificationError", "Erreur D'authentification");

            return new RedirectView("/");
        }
    }}


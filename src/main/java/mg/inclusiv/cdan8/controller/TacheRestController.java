package mg.inclusiv.cdan8.controller;

import java.util.List;

import mg.inclusiv.cdan8.Services.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import mg.inclusiv.cdan8.entity.Tache;
import mg.inclusiv.cdan8.entity.Utilisateur;
import mg.inclusiv.cdan8.repository.TacheRepository;


@RestController
@RequestMapping("/api/tache")
public class TacheRestController {
    @Autowired
    private HttpSession session;

    @Autowired
    TacheRepository tacheRepository;

    @Autowired
    TacheService tacheService;
    @PutMapping("updateEtatTache")
    public ResponseEntity<String> receiveData(@RequestBody Tache tache) {
        tacheService.modifierEtatTache(tache);
        return ResponseEntity.ok("Données reçues avec succès !");
    }

    @GetMapping("list_tache")
    public List<Tache> listContact() {
        if (session != null && session.getAttribute("user") != null){
            Utilisateur currentUser = (Utilisateur) session.getAttribute("user");
            return tacheService.getAllByIdUser(currentUser.getUtilisateur_id()) ;
        }else{
            return null;
        }   
    }
    
    @PostMapping("add_tache")
    public ResponseEntity<String> addContact(@RequestBody Tache tache) {
        Utilisateur currentUser = (Utilisateur) session.getAttribute("user");
        tache.setUtilisateur(currentUser);
        tache.setStatus(false);
        tacheService.creer(tache);
        return ResponseEntity.ok("Données reçues avec succès !");
    }

    @PutMapping("update_tache")
    public ResponseEntity<String> updateContact(@RequestBody Tache tache) {
        Utilisateur currentUser = (Utilisateur) session.getAttribute("user");
        tache.setUtilisateur(currentUser);

        tacheService.modifier(tache);
        return ResponseEntity.ok("Données reçues avec succès !");
    }

    @DeleteMapping("delete_tache/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        tacheRepository.deleteById(id);
        return ResponseEntity.ok("Données reçues avec succès !");
    }
}

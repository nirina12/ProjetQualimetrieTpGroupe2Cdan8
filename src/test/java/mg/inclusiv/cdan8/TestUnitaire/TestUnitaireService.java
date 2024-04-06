package mg.inclusiv.cdan8.TestUnitaire;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import mg.inclusiv.cdan8.Services.TacheService;
import mg.inclusiv.cdan8.Services.UtilisateurService;
import mg.inclusiv.cdan8.entity.Tache;
import mg.inclusiv.cdan8.entity.Utilisateur;
import mg.inclusiv.cdan8.repository.UtilisateurRepository;

public class TestUnitaireService {
    @Autowired
    TacheService tacheService;
    @Autowired
    UtilisateurService utilisateurService;
    @Autowired
    UtilisateurRepository utilisateurRepository;


    @Test
    void signupAndAuthUtilisateur(){
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setEmail("test@gmail.com");
        utilisateur.setPassword("test");
        utilisateur.setName("testNom");
        utilisateur.setLastname("testPrenom");
        
        //utilisateurService.signupUtilisateur(utilisateur);

        //Utilisateur currentUser=utilisateurService.authentUser(utilisateur.getEmail(), utilisateur.getPassword());
        

        // List<Tache>tacheService.listTacheList(1);;
    }
}

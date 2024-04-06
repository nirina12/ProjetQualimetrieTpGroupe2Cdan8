package mg.inclusiv.cdan8.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mg.inclusiv.cdan8.entity.Utilisateur;
import mg.inclusiv.cdan8.repository.UtilisateurRepository;

@Service
@Transactional
public class UtilisateurService {
    @Autowired
    UtilisateurRepository utilisateurRepository;

    public void signupUtilisateur(Utilisateur utilisateur){
        utilisateurRepository.save(utilisateur);
    }

    public Utilisateur authentUser(String emailUser, String password){
        //List <Utilisateur> users= utilisateurRepository.authentificationUser(emailUser, password);
        Utilisateur userFounded = utilisateurRepository.findByEmail(emailUser);
        System.out.println(userFounded.toString());
        Utilisateur currentUser = null;
        if (userFounded!=null) {
            if (userFounded.getPassword().equals(password)) {
                return userFounded;
            }
        }
        return currentUser;
    }

    


    
}

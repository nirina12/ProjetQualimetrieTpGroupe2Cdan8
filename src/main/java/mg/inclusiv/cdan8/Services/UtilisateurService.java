package mg.inclusiv.cdan8.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mg.inclusiv.cdan8.entity.Utilisateur;
import mg.inclusiv.cdan8.repository.UtilisateurRepository;

@Component
@Transactional
public class UtilisateurService {
    @Autowired
    UtilisateurRepository utilisateurRepository;

    public void signupUtilisateur(Utilisateur utilisateur){
        utilisateurRepository.save(utilisateur);
    }
    public Utilisateur authentUser(String emailUser, String password){
        Utilisateur userFounded = utilisateurRepository.findByEmail(emailUser);
        Utilisateur currentUser = null;
        if (userFounded!=null && (userFounded.getPassword().equals(password))) {
                return userFounded;
        }
        return currentUser;
    }
    public void test(Utilisateur utilisateur){
        System.out.println(utilisateur);
    }
}

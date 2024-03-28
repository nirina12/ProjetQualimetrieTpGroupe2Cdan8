package mg.inclusiv.cdan8.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mg.inclusiv.cdan8.entity.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    
    //@Query("SELECT u FROM utilisateur u WHERE u.email = ?1 AND u.password = ?2")
    //List<Utilisateur> authentificationUser(String emailUser, String pwd);
    Utilisateur findByEmail(String email);
    //@Query("INSERT INTO utilisateur (email,lastname,name,password) values(?1,?2,?3,?4)")
    //void inscriptionUtilisateur(String email, String lastname, String name, String password);
}

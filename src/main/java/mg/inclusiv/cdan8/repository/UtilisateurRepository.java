package mg.inclusiv.cdan8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mg.inclusiv.cdan8.entity.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    
    Utilisateur findByEmail(String email);
}

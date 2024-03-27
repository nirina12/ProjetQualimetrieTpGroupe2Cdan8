package mg.inclusiv.cdan8.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mg.inclusiv.cdan8.entity.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    
}

package mg.inclusiv.cdan8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mg.inclusiv.cdan8.entity.Tache;
@Repository
public interface TacheRepository extends JpaRepository<Tache, Long>  {
    // @Query("FROM tache WHERE utilisateur_id = ?1")
    // public List<Tache> getAllTacheUser(Long idutilisateur);
    
    @Query("SELECT t FROM Tache t WHERE t.utilisateur.id = :idUtilisateur")
    List<Tache> findAllTachesByUtilisateurId(@Param("idUtilisateur") Long idUtilisateur);

    // @Query("SELECT * FROM Tache t WHERE t.utilisateur_id = :utilisateur_id")
    // List<Tache> getAllTacheUser(@Param("utilisateur_id") Long idutilisateur);
    //List<Tache> 
    
} 

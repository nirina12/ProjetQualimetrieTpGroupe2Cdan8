package mg.inclusiv.cdan8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.jpa.repository.Modifying;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import mg.inclusiv.cdan8.entity.Tache;

@Repository
public interface TacheRepository extends JpaRepository<Tache, Long>  {
    
    @Query("SELECT t FROM Tache t WHERE t.utilisateur.id = :idUtilisateur ORDER BY t.tache_id")
    List<Tache> findAllTachesByUtilisateurId(@Param("idUtilisateur") Long idUtilisateur);

    @Modifying
    @Query("UPDATE Tache t SET t.status = :status WHERE t.tache_id = :tache_id")
    void updateEtatTache(@Param("tache_id") long tache_id, @Param("status") boolean status);

    
} 



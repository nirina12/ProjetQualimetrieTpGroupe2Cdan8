package mg.inclusiv.cdan8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mg.inclusiv.cdan8.entity.Tache;
@Repository
public interface TacheRepository extends JpaRepository<Tache, Long>  {
} 

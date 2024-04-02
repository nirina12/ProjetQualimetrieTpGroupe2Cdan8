package mg.inclusiv.cdan8.Services;

import mg.inclusiv.cdan8.entity.Tache;
import mg.inclusiv.cdan8.repository.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TacheService {
    @Autowired
    TacheRepository tacheRepository;

    public List<Tache> getAll(){
        return tacheRepository.findAll();
    }
    public void creer(Tache tache){
        tacheRepository.save(tache);
    }
    public void modifier (Tache tache){
        tacheRepository.save(tache);
    }

    public void modifierEtatTache (Tache tache){
        tacheRepository.updateEtatTache(tache.getTache_id(),tache.getStatus());
    }
    public void supprime (Long id){
        tacheRepository.deleteById(id);
    }


  }
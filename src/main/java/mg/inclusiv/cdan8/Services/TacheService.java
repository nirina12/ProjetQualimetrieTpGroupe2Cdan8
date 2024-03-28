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
    private TacheRepository tacheRepository;

    public List<Tache> tacheList(){
        return tacheRepository.findAll();
    }
    public void save(Tache tache){
        tacheRepository.save(tache);
    }
    public Tache update(long id){
        return  tacheRepository.findById(id).get();
    }
    public void delete(long id){
        tacheRepository.deleteById(id);
    }


}

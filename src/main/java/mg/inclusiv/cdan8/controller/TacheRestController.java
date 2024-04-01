package mg.inclusiv.cdan8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mg.inclusiv.cdan8.entity.Tache;
import mg.inclusiv.cdan8.repository.TacheRepository;


@RestController
@RequestMapping("/api/tache")
public class TacheRestController {
    
    @Autowired
    TacheRepository tacheRepository;

    @GetMapping("list_tache")
    public List<Tache> listContact() {
        return tacheRepository.findAll();
    }

    @PostMapping("add_tache")
    public Tache addContact(@RequestBody Tache tache) {
        return tacheRepository.save(tache);
    }

    @PutMapping("update_tache")
    public Tache updateContact(@RequestBody Tache contact) {
        return tacheRepository.save(contact);
    }

    @DeleteMapping("delete_tache/{id}")
    public void deleteContact(@PathVariable Long id) {
        tacheRepository.deleteById(id);
    }
}

package mg.inclusiv.cdan8.controller;

import mg.inclusiv.cdan8.Services.TacheService;
import mg.inclusiv.cdan8.entity.Tache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/dashboard")
public class TachesController {
    
    @Autowired
    TacheService tacheService;

    @GetMapping("/list")
    public List<Tache> getAll(){
        return tacheService.getAll();
    }

    @PostMapping("/add")
    public void addTache(@RequestBody Tache tache){
        tacheService.creer(tache);
    }
    @PostMapping("/delete/{id}")
    public void deleteTache(@PathVariable Long id){
        tacheService.supprime(id);
    }
}

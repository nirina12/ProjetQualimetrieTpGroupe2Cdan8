package mg.inclusiv.cdan8.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import mg.inclusiv.cdan8.Services.TacheService;
import mg.inclusiv.cdan8.entity.Tache;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tache")
public class TachesController {
    @Autowired
    TacheService tacheService;
    
    @GetMapping("list")
    public List<Tache> listTache() {
       return tacheService.tacheList();
    }
    @PostMapping("Save")
    public void saveTache(Tache tache){
        tacheService.save(tache);
    }
    @PostMapping("Update")
    public Tache Modif(long id){
        return  tacheService.update(id);
    }
    @PostMapping("delete")
    public void del(long id){
        tacheService.delete(id);
    }
}

package mg.inclusiv.cdan8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndView;

import mg.inclusiv.cdan8.entity.Contact;
import mg.inclusiv.cdan8.repository.ContactRepository;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    ContactRepository contactRepository;

    @GetMapping("list")
    public List<Contact> listContact() {
        //long nbutilisateur = contactRepository.count();
        //boolean has_exists = contactRepository.existsById(id.objet);
        
        return contactRepository.findAll();
    }

    @GetMapping("getindex")
    public ModelAndView getUser(){
        String message = "Hello, Thymeleaf!";
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @PostMapping("/add")
    public Contact addContact(@RequestBody Contact contact){
        return contactRepository.save(contact);
    }

}

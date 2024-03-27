package mg.inclusiv.cdan8.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mg.inclusiv.cdan8.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>  {
//afaka mamorina fonction ana requete ato anaty jpa repository
    
    
}

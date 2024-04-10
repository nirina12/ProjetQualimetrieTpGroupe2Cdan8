package mg.inclusiv.cdan8.entity;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long utilisateur_id;
    private String name;
    private String lastname;
    private String email;
    private String password;

    // public Utilisateur(String nom,String prenom,String Email,String password){
    //     this.lastname = nom;
    //     this.lastname = prenom;
    //     this.email = email;
    //     this.password = password;
    // }
}

package mg.inclusiv.cdan8.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import mg.inclusiv.cdan8.Services.TacheService;
import mg.inclusiv.cdan8.Services.UtilisateurService;
import mg.inclusiv.cdan8.entity.Tache;
import mg.inclusiv.cdan8.entity.Utilisateur;
import mg.inclusiv.cdan8.repository.TacheRepository;
import mg.inclusiv.cdan8.repository.UtilisateurRepository;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class TestUnitaireService {
    
    // @Autowired
    // private TacheRepository tacheRepository;
    
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    // @Test
    // public void UtilisateurRepository_SaveAll_ReturnSavedUtilisateur(){
    //     // Arrange
    //         Utilisateur utilisateur = Utilisateur.builder()
    //             .name("rakoto")
    //             .lastname("be")
    //             .email("email@gmail.com")
    //             .password("null")
    //             .build();

    // }
        
    //     // Arrange
    //     // Utilisateur utilisateur = Utilisateur.builder()
    //     //     .name("rakoto")
    //     //     .lastname("be")
    //     //     .email("email@gmail.com")
    //     //     .password("null")
    //     //     .build();
    //     // // Act
    //     // Utilisateur savedUtilisateur = utilisateurRepository.save(utilisateur);

    //     // // Assert
    //     // Assertions.assertThat(savedUtilisateur).isNotNull();
    //     // Assertions.assertThat(savedUtilisateur.getUtilisateur_id()).isGreaterThan(0);
    // }
}

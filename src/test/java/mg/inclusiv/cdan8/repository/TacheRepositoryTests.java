package mg.inclusiv.cdan8.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import mg.inclusiv.cdan8.entity.Utilisateur;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@SpringBootTest
public class TacheRepositoryTests {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Test
    public void UtilisateurRepository_Savedall_ReturnsSavedUtilisateur(){

        // Arrange
        Utilisateur utilisateur = Utilisateur.builder()
                .name("rakoto")
                .lastname("be")
                .email("email@gmail.com")
                .password("null")
                .build();
        // Act
        // Utilisateur savedUtilisateur = utilisateurRepository.save(utilisateur);
        // Assert
    }
}

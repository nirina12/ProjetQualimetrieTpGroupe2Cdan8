package mg.inclusiv.cdan8.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tache_id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private Boolean status;
    @Column
    @JoinColumn(name = "utilisateur_id")
    private Long utilisateur_id;
}

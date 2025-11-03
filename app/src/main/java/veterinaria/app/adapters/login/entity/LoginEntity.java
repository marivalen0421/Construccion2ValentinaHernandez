package veterinaria.app.adapters.login.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import veterinaria.app.adapters.person.entity.PersonEntity;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "login")
public class LoginEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loginId;

    @JoinColumn(name = "person_id")
    @OneToOne
    private PersonEntity person;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;
}

package veterinaria.app.adapters.person.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import veterinaria.app.domain.model.enums.Role;

@Entity
@Table(name = "person")
@Getter
@Setter
public class PersonEntity {

    @Id
    @Column(name = "id")
    private Long document;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;
}

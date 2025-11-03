package veterinaria.app.domain.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import veterinaria.app.domain.model.enums.Role;

@NoArgsConstructor
@Getter
@Setter
public class Person {
    private Long document;
    private String name;
    private int age;
    private Role role;
    private String userName;
    private String password;

    public Person(Long document, String name, int age, Role role) {
        this.document = document;
        this.name = name;
        this.age = age;
        this.role = role;
    }
}

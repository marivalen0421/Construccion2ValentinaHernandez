package veterinaria.app.adapters.rest.request;

import veterinaria.app.domain.model.enums.Role;

public class PersonRequest {
    private Long document;
    private String name;
    private int age;
    private Role role;
    private String userName;
    private String password;
    private String userNameAdmin;
    private String passwordAdmin;

    private String userNameVet;
    private String passwordVet;

    public String getUserNameVet() {
        return userNameVet;
    }

    public void setUserNameVet(String userNameVet) {
        this.userNameVet = userNameVet;
    }

    public String getPasswordVet() {
        return passwordVet;
    }

    public void setPasswordVet(String passwordVet) {
        this.passwordVet = passwordVet;
    }

    public Long getDocument() {
        return document;
    }

    public void setDocument(Long document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserNameAdmin() {
        return userNameAdmin;
    }

    public void setUserNameAdmin(String userNameAdmin) {
        this.userNameAdmin = userNameAdmin;
    }

    public String getPasswordAdmin() {
        return passwordAdmin;
    }

    public void setPasswordAdmin(String passwordAdmin) {
        this.passwordAdmin = passwordAdmin;
    }
    @Override
    public String toString() {
        return "PersonRequest [document=" + document + ", name=" + name + ", age=" + age + ", role=" + role + ", userName=" + userName + ", password=" + password+ "]";
    }
}

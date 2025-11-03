package veterinaria.app.adapters.rest.request;

import veterinaria.app.domain.model.enums.Role;

public class UserRequest {
    private long document;
    private String name;
    private int age;
    private String role;
    private String userName;
    private String password;
    private String userNameAdmin;
    private String passwordAdmin;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getDocument() {
        return document;
    }

    public void setDocument(long document) {
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
        return "UserRequest{" +
                "document=" + document +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", role='" + role + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userNameAdmin='" + userNameAdmin + '\'' +
                ", passwordAdmin='" + passwordAdmin + '\'' +
                '}';
    }
}

package edu.mum.cs544.bean;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    @NotBlank(message = "Name Can't be blank")
    private String name;
    @NotBlank(message = "Username can't be blank ")
    private String username;
    @NotBlank(message = "Password can't be blank")
    @Size(min=6, message = "Password can't be less than 6 characters")
    private String password;
    @Email(message = "Email badly formatted")
    @NotBlank(message = "Email can't be blank")
    private String email;
    private Role role;

    public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
}

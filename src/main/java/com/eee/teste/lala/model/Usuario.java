package com.eee.teste.lala.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class Usuario {

    @Id
    private String username;
    private String password;
    private boolean enabled;

    
    // @Enumerated(EnumType.STRING)
    // private Role roles;
    
    //getters and setters


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

    // public Role getRole() {
    //     return roles;
    // }

    // public void setRole(Role role) {
    //     this.roles = role;
    // }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    

    
    
}

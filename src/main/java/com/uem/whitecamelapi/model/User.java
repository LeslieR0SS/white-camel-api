package com.uem.whitecamelapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity  // con @Entity y @Table creamos una entidad que se va a almacenar en bbdd
@Table(name = "users") 
public class User {
    
    // con @Id definieremos la PK y con @GeneratedValue para los ID se autoincrementen
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @Column(unique = true) // para que los nombres no se repitan 
    private String username;

    private String password;


    private Date registrationDate;

    //constructor vacío 
    public User() {
    }

    // constructor con todos sus atributos
    public User(Long id, String username, String password, Date registrationDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.registrationDate = registrationDate;
    }


    // getter y setters de todos los campos 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    // método toString para todos los atributos
    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", registrationDate=" + registrationDate + "]";
    }

    public void save(User updatedUser) {
        if (updatedUser.getUsername() != null) {
            this.setUsername(updatedUser.getUsername());
        }

        if (updatedUser.getPassword() != null) {
            this.setPassword(updatedUser.getPassword());
        }

        return;
    }

}

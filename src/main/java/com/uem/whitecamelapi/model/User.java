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
    private Date signUpDate;

    //constructor vacío 
    public User() {
    }

    // constructor con todos sus atributos
    public User(Long id, String user, String password, Date signUpDate) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.signUpDate = signUpDate;
    }


    // getter y setters de todos los campos 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getSignUpDate() {
        return signUpDate;
    }

    public void setSignUpDate(Date signUpDate) {
        this.signUpDate = signUpDate;
    }

    // método toString para todos los atributos
    @Override
    public String toString() {
        return "User [id=" + id + ", user=" + user + ", password=" + password + ", signUpDate=" + signUpDate + "]";
    }
    

}

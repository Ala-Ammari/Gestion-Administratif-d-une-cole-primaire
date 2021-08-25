package com.school.myschool.entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int userId;

    @Column(name="genre")
    private int genre;

    @Column(name="user_FName")
    private char userFName;  //first name

    @Column(name="user_LName")
    private char userLName;//last name
    @Column(name="email")
    private char email;

    @Column(name="password")
    private char password;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="ecoleid")
    private Ecole ecole;   //attribut ecole est classe ?
     @OneToMany(mappedBy="enseignant")
   private List<AffectationEnseignant> affectationEnseignant;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public char getUserFName() {
        return userFName;
    }

    public void setUserFName(char userFName) {
        this.userFName = userFName;
    }

    public char getUserLName() {
        return userLName;
    }

    public void setUserLName(char userLName) {
        this.userLName = userLName;
    }

    public char getEmail() {
        return email;
    }

    public void setEmail(char email) {
        this.email = email;
    }

    public char getPassword() {
        return password;
    }

    public void setPassword(char password) {
        this.password = password;
    }

    public Ecole getEcole() {
        return ecole;
    }

    public void setEcole(Ecole ecole) {
        this.ecole = ecole;
    }
}

package com.school.myschool.entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Userss")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int userId;

    @Column(name="genre")
    private int genre;

    @Column(name="user_FName")
    private String userFName;  //first name

    @Column(name="user_LName")
    private String userLName;//last name
    @Column(name="email")
    private String email;
    @OneToMany(mappedBy="enseignant")
    private List<emploiEntity> emploiEntity;

    @Column(name="password")
    private String password;

    @OneToMany(mappedBy="enseignant")
    private List<AffectationEnseignant> affectationEnseignant;
    @ManyToMany(mappedBy = "userss")
    private List<AnneeScolaire> AnneeScolaire;

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

    public String getUserFName() {
        return userFName;
    }

    public void setUserFName(String userFName) {
        this.userFName = userFName;
    }

    public String getUserLName() {
        return userLName;
    }

    public void setUserLName(String userLName) {
        this.userLName = userLName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<AffectationEnseignant> getAffectationEnseignant() {
        return affectationEnseignant;
    }

    public void setAffectationEnseignant(List<AffectationEnseignant> affectationEnseignant) {
        this.affectationEnseignant = affectationEnseignant;
    }

    public List<com.school.myschool.entity.AnneeScolaire> getAnneeScolaire() {
        return AnneeScolaire;
    }

    public void setAnneeScolaire(List<com.school.myschool.entity.AnneeScolaire> anneeScolaire) {
        AnneeScolaire = anneeScolaire;
    }
}

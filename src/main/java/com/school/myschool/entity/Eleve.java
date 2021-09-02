package com.school.myschool.entity;

import javax.persistence.*;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table(name="Eleve")
public class Eleve {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int eleveId;
    @NotBlank
    @Column(name="eleveFName")

    private String eleveFName;  //first name
    @Column(name="eleveLname")

    private String eleveLname;   //last name
    @Column(name="sexe")

    private int sexe;  //1 garcon  0 fille
    @Column(name="numIscription")

    private int numIscription;
    @Valid
    @Column(name="dateNaissance")
    private String dateNaissance;  //type cv ou non ?

    @OneToMany(mappedBy="eleve")
    private List<AffectationEleve> AffectationEleve;
    @ManyToMany(mappedBy = "Eleve")
    private List<AnneeScolaire> AnneeScolaire;

    public Eleve() {
    }


    public int getEleveId() {
        return eleveId;
    }

    public void setEleveId(int eleveId) {
        this.eleveId = eleveId;
    }

    public String getEleveFName() {
        return eleveFName;
    }

    public void setEleveFName(String eleveFName) {
        this.eleveFName = eleveFName;
    }

    public String getEleveLname() {
        return eleveLname;
    }

    public void setEleveLname(String eleveLname) {
        this.eleveLname = eleveLname;
    }

    public int getSexe() {
        return sexe;
    }

    public void setSexe(int sexe) {
        this.sexe = sexe;
    }

    public int getNumIscription() {
        return numIscription;
    }

    public void setNumIscription(int numIscription) {
        this.numIscription = numIscription;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}

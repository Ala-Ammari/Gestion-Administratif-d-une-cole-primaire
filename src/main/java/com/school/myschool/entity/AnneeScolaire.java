package com.school.myschool.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="AnneeScolaire")
public class AnneeScolaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int anneeId;
    @Column(name = "anneeName")
    private String anneeName;

    @ManyToMany
    @JoinTable(name = "Matiere_annee",
            joinColumns = @JoinColumn(name = "annee_id"),
            inverseJoinColumns = @JoinColumn(name = "matiere_id"))
    private List<Matiere> Matiere;
    @ManyToMany
    @JoinTable(name = "classe_annee",
            joinColumns = @JoinColumn(name = "annee_id"),
            inverseJoinColumns = @JoinColumn(name = "classe_id"))
    private List<Classe> Classe;
    @ManyToMany
    @JoinTable(name = "Eleve_annee",
            joinColumns = @JoinColumn(name = "annee_id"),
            inverseJoinColumns = @JoinColumn(name = "Eleve_id"))
    private List<Eleve> Eleve;
    @ManyToMany
    @JoinTable(name = "user_annee",
            joinColumns = @JoinColumn(name = "annee_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> user;

    public int getAnneeId() {
        return anneeId;
    }

    public void setAnneeId(int anneeId) {
        this.anneeId = anneeId;
    }

    public String getAnneeName() {
        return anneeName;
    }

    public void setAnneeName(String anneeName) {
        this.anneeName = anneeName;
    }

    public List<com.school.myschool.entity.Matiere> getMatiere() {
        return Matiere;
    }

    public void setMatiere(List<com.school.myschool.entity.Matiere> matiere) {
        Matiere = matiere;
    }

    public List<com.school.myschool.entity.Classe> getClasse() {
        return Classe;
    }

    public void setClasse(List<com.school.myschool.entity.Classe> classe) {
        Classe = classe;
    }

    public List<com.school.myschool.entity.Eleve> getEleve() {
        return Eleve;
    }

    public void setEleve(List<com.school.myschool.entity.Eleve> eleve) {
        Eleve = eleve;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}
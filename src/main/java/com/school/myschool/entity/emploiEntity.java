package com.school.myschool.entity;

import javax.persistence.*;

@Entity
@Table(name="emploiEntity")
public class emploiEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int emploiEntityId;

    @ManyToOne
    @JoinColumn(name="matiereId")
    private Matiere matiere;

    @ManyToOne
    @JoinColumn(name="classe_id")
    private Classe classe;

    @ManyToOne
    @JoinColumn(name="enseignant_id")
    private User enseignant ;

    @ManyToOne
    @JoinColumn(name="horaire_id")
    private Horaire horaire ;

    @ManyToOne
    @JoinColumn(name="days_id")
    private days days ;

    public emploiEntity() {
    }

    public emploiEntity(Matiere matiere, Classe classe, User enseignant, Horaire horaire, com.school.myschool.entity.days days) {
        this.matiere = matiere;
        this.classe = classe;
        this.enseignant = enseignant;
        this.horaire = horaire;
        this.days = days;
    }

    public int getEmploiEntityId() {
        return emploiEntityId;
    }

    public void setEmploiEntityId(int emploiEntityId) {
        this.emploiEntityId = emploiEntityId;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public User getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(User enseignant) {
        this.enseignant = enseignant;
    }

    public Horaire getHoraire() {
        return horaire;
    }

    public void setHoraire(Horaire horaire) {
        this.horaire = horaire;
    }

    public com.school.myschool.entity.days getDays() {
        return days;
    }

    public void setDays(com.school.myschool.entity.days days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return "emploiEntity{" +
                "emploiEntityId=" + emploiEntityId +
                ", matiere=" + matiere +
                ", classe=" + classe +
                ", enseignant=" + enseignant +
                ", horaire=" + horaire +
                ", days=" + days +
                '}';
    }
}

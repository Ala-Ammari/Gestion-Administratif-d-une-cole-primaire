package com.school.myschool.entity;

import javax.persistence.*;

@Entity
@Table(name="AffectationEnseignant")
public class AffectationEnseignant {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int affEnsId;
    @ManyToOne
    @JoinColumn(name="enseignant_id")
    private User enseignant ;
    @ManyToOne
    @JoinColumn(name="classe_id")
    private Classe classe;
    @ManyToOne
    @JoinColumn(name="matiereId")
    private Matiere matiere;

    public AffectationEnseignant() {
    }

    public AffectationEnseignant(int affEnsId, User enseignant, Classe classe, Matiere matiere) {
        this.affEnsId = affEnsId;
        this.enseignant = enseignant;
        this.classe = classe;
        this.matiere = matiere;
    }

    public int getAffEnsId() {
        return affEnsId;
    }

    public void setAffEnsId(int affEnsId) {
        this.affEnsId = affEnsId;
    }

    public User getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(User enseignant) {
        this.enseignant = enseignant;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }
}

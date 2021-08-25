package com.school.myschool.entity;

import javax.persistence.*;

@Entity
@Table(name="AffectationEleve")
public class AffectationEleve {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int affectationEleveId;
    @ManyToOne
    @JoinColumn(name="eleve_id")
    private Eleve eleve;
    @ManyToOne
    @JoinColumn(name="classe_id")
    private Classe classe;


    public int getAffectationEleveId() {
        return affectationEleveId;
    }

    public void setAffectationEleveId(int affectationEleveId) {
        this.affectationEleveId = affectationEleveId;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
}

package com.school.myschool.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Matiere")
public class Matiere {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int matiereId;
    @Column(name="matiere_Niveau")
    private int matiereNiveau;
    @Column(name="matiere_Name")
    private String matiereName;
    @OneToMany(mappedBy="matiere")
    private List<AffectationEnseignant> affectationEnseignant;
    @ManyToMany(mappedBy = "Matiere")
    private List<AnneeScolaire> AnneeScolaire;
    public Matiere() {
    }

    public int getMatiereId() {
        return matiereId;
    }

    public void setMatiereId(int matiereId) {
        this.matiereId = matiereId;
    }

    public int getMatiereNiveau() {
        return matiereNiveau;
    }

    public void setMatiereNiveau(int matiereNiveau) {
        this.matiereNiveau = matiereNiveau;
    }

    public String getMatiereName() {
        return matiereName;
    }

    public void setMatiereName(String matiereName) {
        this.matiereName = matiereName;
    }
}

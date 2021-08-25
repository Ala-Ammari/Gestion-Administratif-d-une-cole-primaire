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
    private char matiereName;
    @OneToMany(mappedBy="matiere")
    private List<AffectationEnseignant> affectationEnseignant;

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

    public char getMatiereName() {
        return matiereName;
    }

    public void setMatiereName(char matiereName) {
        this.matiereName = matiereName;
    }
}

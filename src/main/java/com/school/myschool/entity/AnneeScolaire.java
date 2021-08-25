package com.school.myschool.entity;

import javax.persistence.*;

@Entity
@Table(name="AnneeScolaire")
public class AnneeScolaire {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int anneeId;
    @Column(name="anneeName")
    private char anneeName;

    public int getAnneeId() {
        return anneeId;
    }

    public void setAnneeId(int anneeId) {
        this.anneeId = anneeId;
    }

    public char getAnneeName() {
        return anneeName;
    }

    public void setAnneeName(char anneeName) {
        this.anneeName = anneeName;
    }
}

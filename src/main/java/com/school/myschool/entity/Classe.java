package com.school.myschool.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Classe")
public class Classe {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int classeId;
    @Column(name="classeNiveau")
    private int classeNiveau;
    @Column(name="classeName")
    private char classeName;
    @Column(name="nombre")
    private int nombre;
    @OneToMany(mappedBy="classe")
    private List<AffectationEnseignant> affectationEnseignant;
    @OneToMany(mappedBy="classe")
    private List<AffectationEleve> AffectationEleve;
    public Classe() {
    }

    public int getClasseId() {
        return classeId;
    }

    public void setClasseId(int classeId) {
        this.classeId = classeId;
    }

    public int getClasseNiveau() {
        return classeNiveau;
    }

    public void setClasseNiveau(int classeNiveau) {
        this.classeNiveau = classeNiveau;
    }

    public char getClasseName() {
        return classeName;
    }

    public void setClasseName(char classeName) {
        this.classeName = classeName;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
}

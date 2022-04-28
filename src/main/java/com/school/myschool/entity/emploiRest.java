package com.school.myschool.entity;

import java.util.List;

public class emploiRest {
    private String matiere;
    private String classe;
    private  String enseignant;
    private String days;
    private String hours;

    public emploiRest(String matiere, String classe, String enseignant, String days, String hours) {
        this.matiere = matiere;
        this.classe = classe;
        this.enseignant = enseignant;
        this.days = days;
        this.hours = hours;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(String enseignant) {
        this.enseignant = enseignant;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }
}

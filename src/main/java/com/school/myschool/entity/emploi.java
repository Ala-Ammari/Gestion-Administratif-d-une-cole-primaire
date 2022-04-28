package com.school.myschool.entity;

import java.util.List;

public class emploi {
    private String matiere;
    private String classe;
    private  String enseignant;
 private List<String> days;
  private List<String> hours;

    public emploi() {
    }

    public emploi(String matiere, String classe, String enseignant, List<String> days, List<String> hours) {
        this.matiere = matiere;
        this.classe = classe;
        this.enseignant = enseignant;
        this.days = days;
        this.hours = hours;
    }

    public emploi(String matiere, String classe, String enseignant) {
        this.matiere = matiere;
        this.classe = classe;
        this.enseignant = enseignant;
    }

    public emploi(String matiere, String classe, String enseignant, List<String> hours) {
        this.matiere = matiere;
        this.classe = classe;
        this.enseignant = enseignant;
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

    @Override
    public String toString() {
        return "emploi{" +
                "matiere='" + matiere + '\'' +
                ", classe='" + classe + '\'' +
                ", enseignant='" + enseignant + '\'' +
                ", days=" + days +
                ", hours=" + hours +
                '}';
    }

    public List<String> getDays() {
        return days;
    }

    public void setDays(List<String> days) {
        this.days = days;
    }

    public List<String> getHours() {
        return hours;
    }

    public void setHours(List<String> hours) {
        this.hours = hours;
    }
}

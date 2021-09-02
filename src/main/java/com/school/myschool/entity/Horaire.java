package com.school.myschool.entity;

import javax.persistence.*;

@Entity
@Table(name="Horaire")
public class Horaire {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
     private int id;
    @Column(name="horaire")
     private String heure;

    public Horaire() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }
}

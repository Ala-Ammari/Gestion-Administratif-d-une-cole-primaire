package com.school.myschool.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Horaire")
public class Horaire {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
     private int id;
    @Column(name="horaire")
     private String heure;
    @OneToMany(mappedBy="horaire")
    private List<emploiEntity> emploiEntity;
    public Horaire() {
    }

    public List<com.school.myschool.entity.emploiEntity> getEmploiEntity() {
        return emploiEntity;
    }

    public void setEmploiEntity(List<com.school.myschool.entity.emploiEntity> emploiEntity) {
        this.emploiEntity = emploiEntity;
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

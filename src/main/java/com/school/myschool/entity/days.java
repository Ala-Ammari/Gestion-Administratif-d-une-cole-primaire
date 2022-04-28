package com.school.myschool.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="days")
public class days {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int dayId;

    @Column(name="day")
    private String dayname;
    @OneToMany(mappedBy="days")
    private List<emploiEntity> emploiEntity;
    public days() {
    }

    public List<com.school.myschool.entity.emploiEntity> getEmploiEntity() {
        return emploiEntity;
    }

    public void setEmploiEntity(List<com.school.myschool.entity.emploiEntity> emploiEntity) {
        this.emploiEntity = emploiEntity;
    }

    public days(int dayId, String dayname) {
        this.dayId = dayId;
        this.dayname = dayname;
    }

    public int getDayId() {
        return dayId;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }

    public String getDayname() {
        return dayname;
    }

    public void setDayname(String dayname) {
        this.dayname = dayname;
    }
}

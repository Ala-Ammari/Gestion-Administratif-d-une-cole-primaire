package com.school.myschool.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Ecole")
public class Ecole {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int ecoleId;
    @Column(name="ecoleName")
    private char ecoleName;
    @OneToMany
    @JoinColumn(name="Ecole_id")
    private List<User> user;

    public Ecole setEcoleId(int Id){
        ecoleId=Id;
        return this;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public int getEcoleId (){
        return ecoleId;
    }


    public Ecole setEcoleName (char name){
        ecoleName = name;
        return this;
    }

    public char getEcoleName (){
        return ecoleName;
    }
}

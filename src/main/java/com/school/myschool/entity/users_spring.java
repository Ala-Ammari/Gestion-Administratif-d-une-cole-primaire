package com.school.myschool.entity;

import javax.persistence.*;

@Entity
@Table(name="users")
public class users_spring {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="user_id")
    private int userId;

    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="role")
    private String role;
    @Column(name="enabled")
    private int enabled;

    public users_spring() {
    }

    public users_spring(String username, String password, String role, int enabled) {

        this.username = username;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

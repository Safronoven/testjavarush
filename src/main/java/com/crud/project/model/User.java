package com.crud.project.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table (name = "CrudTest")
public class User {

    @Id
    @Column (name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column (name = "NAME")
    private String name;

    @Column (name = "AGE")
    private int age;

    @Column (name = "IS_ADMIN")
    private boolean isAdmin;

    @Column (name = "CREATE_DATE")
    private Timestamp createDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
}

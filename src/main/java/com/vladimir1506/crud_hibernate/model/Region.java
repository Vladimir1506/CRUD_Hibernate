package com.vladimir1506.crud_hibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "regions")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

    public Region() {
    }


    public Region(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return id + ". " + name;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}

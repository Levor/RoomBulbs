package com.roomsWithBulb.domain;

import javax.persistence.*;

@Entity
@Table(name = "room2")
public class Rooms {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;
    private String country;
    private boolean turnBulb=false;

    public Rooms() {
    }

    public Rooms(String name, String country, boolean turnBulb) {
        this.name = name;
        this.country = country;
        this.turnBulb = turnBulb;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isTurnBulb() {
        return turnBulb;
    }

    public void setTurnBulb(boolean turnBulb) {
        this.turnBulb = turnBulb;
    }
}

package com.bsuir.vmsis.model.impl;


import com.bsuir.vmsis.model.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "referee")
@Table(name = "referee")
public class Referee extends BaseEntity implements Serializable {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "character")
    private String character;

    @Column(name = "loyality")
    private Long loyality;

    @OneToMany(mappedBy = "referee",cascade = CascadeType.ALL)
    private List<Match> matches;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public Long getLoyality() {
        return loyality;
    }

    public void setLoyality(Long loyality) {
        this.loyality = loyality;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
}


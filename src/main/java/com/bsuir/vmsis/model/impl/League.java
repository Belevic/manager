package com.bsuir.vmsis.model.impl;

import com.bsuir.vmsis.model.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "league")
@Table(name = "league")
public class League extends BaseEntity implements Serializable {

    @Column(name = "name")
    private String name;

    @Column(name = "flag_image")
    private String flagImage;

    @Column(name = "current_fixture")
    private Long currentFixture;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @Cascade(org.hibernate.annotations.CascadeType.REPLICATE)
    @JoinColumn (name="country_id",referencedColumnName = "id")
    private Country country;

    @OneToMany(mappedBy = "league", cascade = CascadeType.ALL)
    private List<Team> teams;

    @OneToMany(mappedBy = "leagueFixture",cascade = CascadeType.ALL)
    private List<Fixture> fixtures;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlagImage() {
        return flagImage;
    }

    public void setFlagImage(String flagImage) {
        this.flagImage = flagImage;
    }

    public Long getCurrentFixture() {
        return currentFixture;
    }

    public void setCurrentFixture(Long currentFixture) {
        this.currentFixture = currentFixture;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<Fixture> getFixtures() {
        return fixtures;
    }

    public void setFixtures(List<Fixture> fixtures) {
        this.fixtures = fixtures;
    }
}

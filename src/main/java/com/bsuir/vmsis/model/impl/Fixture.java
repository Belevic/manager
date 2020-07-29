package com.bsuir.vmsis.model.impl;


import com.bsuir.vmsis.model.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "fixture")
@Table(name = "fixture")
public class Fixture extends BaseEntity implements Serializable {

    @Column(name = "number")
    private Long number;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @Cascade(org.hibernate.annotations.CascadeType.REPLICATE)
    @JoinColumn(name = "league_id", referencedColumnName = "id")
    private League leagueFixture;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @Cascade(org.hibernate.annotations.CascadeType.REPLICATE)
    @JoinColumn(name = "season_id", referencedColumnName = "id")
    private Season seasonFixture;

    @OneToMany(mappedBy = "fixture",cascade = CascadeType.ALL)
    private List<Match> matches;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public League getLeagueFixture() {
        return leagueFixture;
    }

    public void setLeagueFixture(League leagueFixture) {
        this.leagueFixture = leagueFixture;
    }

    public Season getSeasonFixture() {
        return seasonFixture;
    }

    public void setSeasonFixture(Season seasonFixture) {
        this.seasonFixture = seasonFixture;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
}


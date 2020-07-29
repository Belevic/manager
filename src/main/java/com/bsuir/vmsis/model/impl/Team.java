package com.bsuir.vmsis.model.impl;

import com.bsuir.vmsis.model.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity(name = "team")
@Table(name = "team")
public class Team extends BaseEntity implements Serializable {

    @Column(name = "name")
    private String name;

    @Column(name = "aim")
    private Long aim;

    @Column(name = "logo_image")
    private String logoImage;

    @Column(name="points")
    private Long points;

    @Column(name="wins")
    private Long wins;

    @Column(name = "draws")
    private Long draws;

    @Column(name = "loses")
    private Long loses;

    @Column(name="scored")
    private Long scored;

    @Column(name = "against")
    private Long against;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @Cascade(org.hibernate.annotations.CascadeType.REPLICATE)
    @JoinColumn (name="league_id",referencedColumnName = "id")
    private League league;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn (name="manager_id",referencedColumnName = "id")
    private User manager;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn (name="stadium_id",referencedColumnName = "id")
    private Stadium stadium;

    @OneToOne(mappedBy = "team", cascade = CascadeType.ALL)
    private Squad squad;

    @OneToOne(mappedBy = "teamLineUp", cascade = CascadeType.ALL)
    private LineUp lineUp;

    @OneToOne(mappedBy = "teamTactics", cascade = CascadeType.ALL)
    private Tactics tactics;

    @OneToOne(mappedBy = "teamTraining", cascade = CascadeType.ALL)
    private Training training;

    @OneToOne(mappedBy = "teamFinances", cascade = CascadeType.ALL)
    private Finances finances;

    @OneToMany(mappedBy = "homeTeam",cascade = CascadeType.ALL)
    private List<Match> homeMatch;

    @OneToMany(mappedBy = "guestTeam",cascade = CascadeType.ALL)
    private List<Match> guestMatch;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAim() {
        return aim;
    }

    public void setAim(Long aim) {
        this.aim = aim;
    }

    public String getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(String logoImage) {
        this.logoImage = logoImage;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public Squad getSquad() {
        return squad;
    }

    public void setSquad(Squad squad) {
        this.squad = squad;
    }

    public LineUp getLineUp() {
        return lineUp;
    }

    public void setLineUp(LineUp lineUp) {
        this.lineUp = lineUp;
    }

    public Tactics getTactics() {
        return tactics;
    }

    public void setTactics(Tactics tactics) {
        this.tactics = tactics;
    }

    public List<Match> getHomeMatch() {
        return homeMatch;
    }

    public void setHomeMatch(List<Match> homeMatch) {
        this.homeMatch = homeMatch;
    }

    public List<Match> getGuestMatch() {
        return guestMatch;
    }

    public void setGuestMatch(List<Match> guestMatch) {
        this.guestMatch = guestMatch;
    }

    public Long getWins() {
        return wins;
    }

    public void setWins(Long wins) {
        this.wins = wins;
    }

    public Long getDraws() {
        return draws;
    }

    public void setDraws(Long draws) {
        this.draws = draws;
    }

    public Long getLoses() {
        return loses;
    }

    public void setLoses(Long loses) {
        this.loses = loses;
    }

    public Long getScored() {
        return scored;
    }

    public void setScored(Long scored) {
        this.scored = scored;
    }

    public Long getAgainst() {
        return against;
    }

    public void setAgainst(Long against) {
        this.against = against;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }
}

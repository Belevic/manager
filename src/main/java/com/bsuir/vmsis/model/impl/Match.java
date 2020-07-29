package com.bsuir.vmsis.model.impl;

import com.bsuir.vmsis.model.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "match")
@Table(name = "match")
public class Match extends BaseEntity implements Serializable {

    @Column(name = "home_scored")
    private Long homeScored;

    @Column(name = "guest_scored")
    private Long guestScored;

    @Column(name = "yellow_cards")
    private Long yellow_cards;

    @Column(name = "red_cards")
    private Long red_cards;

    @Column(name = "home_posession")
    private Long home_posession;

    @Column(name = "guest_posession")
    private Long guest_posession;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @Cascade(org.hibernate.annotations.CascadeType.REPLICATE)
    @JoinColumn(name="fixture_id",referencedColumnName = "id")
    private Fixture fixture;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
    @JoinColumn(name="home_id",referencedColumnName = "id")
    private Team homeTeam;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
    @JoinColumn(name="guest_id",referencedColumnName = "id")
    private Team guestTeam;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @Cascade(org.hibernate.annotations.CascadeType.REPLICATE)
    @JoinColumn(name="referee_id",referencedColumnName = "id")
    private Referee referee;

    public Long getHomeScored() {
        return homeScored;
    }

    public void setHomeScored(Long homeScored) {
        this.homeScored = homeScored;
    }

    public Long getGuestScored() {
        return guestScored;
    }

    public void setGuestScored(Long guestScored) {
        this.guestScored = guestScored;
    }

    public Long getYellow_cards() {
        return yellow_cards;
    }

    public void setYellow_cards(Long yellow_cards) {
        this.yellow_cards = yellow_cards;
    }

    public Long getRed_cards() {
        return red_cards;
    }

    public void setRed_cards(Long red_cards) {
        this.red_cards = red_cards;
    }

    public Fixture getFixture() {
        return fixture;
    }

    public void setFixture(Fixture fixture) {
        this.fixture = fixture;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getGuestTeam() {
        return guestTeam;
    }

    public void setGuestTeam(Team guestTeam) {
        this.guestTeam = guestTeam;
    }

    public Referee getReferee() {
        return referee;
    }

    public void setReferee(Referee referee) {
        this.referee = referee;
    }
}

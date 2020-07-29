package com.bsuir.vmsis.model.impl;

import com.bsuir.vmsis.model.BaseEntity;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "player_statistics")
@Table(name = "player_statistics")
public class PlayerStatistics extends BaseEntity implements Serializable {

    @Column(name = "goals")
    private Long goals;

    @Column(name = "assists")
    private Long assists;

    @Column(name = "tackles")
    private Long tackles;

    @Column(name = "free_kicks")
    private Long freeKicks;

    @Column(name = "penalties")
    private Long penalties;

    @Column(name = "interceptions")
    private Long interceptions;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @Cascade(org.hibernate.annotations.CascadeType.REPLICATE)
    @JoinColumn (name="player_id",referencedColumnName = "id")
    private Player playerStatistics;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @Cascade(org.hibernate.annotations.CascadeType.REPLICATE)
    @JoinColumn (name="season_id",referencedColumnName = "id")
    private Season season;

    public Long getGoals() {
        return goals;
    }

    public void setGoals(Long goals) {
        this.goals = goals;
    }

    public Long getAssists() {
        return assists;
    }

    public void setAssists(Long assists) {
        this.assists = assists;
    }

    public Long getTackles() {
        return tackles;
    }

    public void setTackles(Long tackles) {
        this.tackles = tackles;
    }

    public Long getFreeKicks() {
        return freeKicks;
    }

    public void setFreeKicks(Long freeKicks) {
        this.freeKicks = freeKicks;
    }

    public Long getPenalties() {
        return penalties;
    }

    public void setPenalties(Long penalties) {
        this.penalties = penalties;
    }

    public Long getInterceptions() {
        return interceptions;
    }

    public void setInterceptions(Long interceptions) {
        this.interceptions = interceptions;
    }

    public Player getPlayerStatistics() {
        return playerStatistics;
    }

    public void setPlayerStatistics(Player playerStatistics) {
        this.playerStatistics = playerStatistics;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }
}

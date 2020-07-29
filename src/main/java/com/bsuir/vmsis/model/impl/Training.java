package com.bsuir.vmsis.model.impl;


import com.bsuir.vmsis.model.BaseEntity;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "training")
@Table(name = "training")
public class Training extends BaseEntity implements Serializable {

    @Column(name = "boost_forward")
    private Long boostForward;

    @Column(name = "boost_midlefielder")
    private Long boostMidlefielder;

    @Column(name = "boost_defender")
    private Long boostDefender;

    @Column(name = "boost_goalkeaper")
    private Long boostGoalkeaper;

    @Column(name = "forward_training")
    private Boolean forwardTraining;

    @Column(name = "midfielder_training")
    private Boolean midfielderTraining;

    @Column(name = "defender_training")
    private Boolean defenderTraining;

    @Column(name = "goalkeaper_training")
    private Boolean goalkeaperTraining;

    @Column(name = "forward_boosted")
    private Boolean forwardBoosted;

    @Column(name = "midlefielder_boosted")
    private Boolean midlefielderBoosted;

    @Column(name = "defender_boosted")
    private Boolean defenderBoosted;

    @Column(name = "goalkeaper_boosted")
    private Boolean goalkeaperBoosted;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @Cascade(org.hibernate.annotations.CascadeType.REPLICATE)
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team teamTraining;

    public Long getBoostForward() {
        return boostForward;
    }

    public void setBoostForward(Long boostForward) {
        this.boostForward = boostForward;
    }

    public Long getBoostMidlefielder() {
        return boostMidlefielder;
    }

    public void setBoostMidlefielder(Long boostMidlefielder) {
        this.boostMidlefielder = boostMidlefielder;
    }

    public Long getBoostDefender() {
        return boostDefender;
    }

    public void setBoostDefender(Long boostDefender) {
        this.boostDefender = boostDefender;
    }

    public Boolean getForwardTraining() {
        return forwardTraining;
    }

    public void setForwardTraining(Boolean forwardTraining) {
        this.forwardTraining = forwardTraining;
    }

    public Boolean getMidfielderTraining() {
        return midfielderTraining;
    }

    public void setMidfielderTraining(Boolean midfielderTraining) {
        this.midfielderTraining = midfielderTraining;
    }

    public Boolean getDefenderTraining() {
        return defenderTraining;
    }

    public void setDefenderTraining(Boolean defenderTraining) {
        this.defenderTraining = defenderTraining;
    }

    public Team getTeamTraining() {
        return teamTraining;
    }

    public void setTeamTraining(Team teamTraining) {
        this.teamTraining = teamTraining;
    }

    public Long getBoostGoalkeaper() {
        return boostGoalkeaper;
    }

    public void setBoostGoalkeaper(Long boostGoalkeaper) {
        this.boostGoalkeaper = boostGoalkeaper;
    }

    public Boolean getGoalkeaperTraining() {
        return goalkeaperTraining;
    }

    public void setGoalkeaperTraining(Boolean goalkeaperTraining) {
        this.goalkeaperTraining = goalkeaperTraining;
    }

    public Boolean getForwardBoosted() {
        return forwardBoosted;
    }

    public void setForwardBoosted(Boolean forwardBoosted) {
        this.forwardBoosted = forwardBoosted;
    }

    public Boolean getMidlefielderBoosted() {
        return midlefielderBoosted;
    }

    public void setMidlefielderBoosted(Boolean midlefielderBoosted) {
        this.midlefielderBoosted = midlefielderBoosted;
    }

    public Boolean getDefenderBoosted() {
        return defenderBoosted;
    }

    public void setDefenderBoosted(Boolean defenderBoosted) {
        this.defenderBoosted = defenderBoosted;
    }

    public Boolean getGoalkeaperBoosted() {
        return goalkeaperBoosted;
    }

    public void setGoalkeaperBoosted(Boolean goalkeaperBoosted) {
        this.goalkeaperBoosted = goalkeaperBoosted;
    }
}

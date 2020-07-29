package com.bsuir.vmsis.dto.impl;

import com.bsuir.vmsis.dto.BaseDto;

import javax.persistence.Column;

public class TrainingDto extends BaseDto {

    private Long boostForward;
    private Long boostMidlefielder;
    private Long boostDefender;
    private Long boostGoalkeaper;
    private Boolean forwardTraining;
    private Boolean midfielderTraining;
    private Boolean defenderTraining;
    private TeamDto team;
    private Boolean goalkeaperTraining;
    private Boolean forwardBoosted;
    private Boolean midlefielderBoosted;
    private Boolean defenderBoosted;
    private Boolean goalkeaperBoosted;

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

    public TeamDto getTeam() {
        return team;
    }

    public void setTeam(TeamDto team) {
        this.team = team;
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

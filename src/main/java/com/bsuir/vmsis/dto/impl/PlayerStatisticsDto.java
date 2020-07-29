package com.bsuir.vmsis.dto.impl;

import com.bsuir.vmsis.dto.BaseDto;
import com.bsuir.vmsis.model.impl.Player;
import com.bsuir.vmsis.model.impl.Season;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerStatisticsDto extends BaseDto {

    private Long goals;
    private Long assists;
    private Long tackles;
    private Long freeKicks;
    private Long penalties;
    private Long interceptions;
    private PlayerDto player;
    private SeasonDto season;

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

    public PlayerDto getPlayer() {
        return player;
    }

    public void setPlayer(PlayerDto player) {
        this.player = player;
    }

    public SeasonDto getSeason() {
        return season;
    }

    public void setSeason(SeasonDto season) {
        this.season = season;
    }
}

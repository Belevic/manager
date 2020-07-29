package com.bsuir.vmsis.dto.impl;

import com.bsuir.vmsis.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
public class TeamDto extends BaseDto {
    private String name;
    private Long aim;
    private String logoImage;
    private Long points;
    private LeagueDto league;
    private Long wins;
    private Long draws;
    private Long loses;
    private Long scored;
    private Long against;
    private StadiumDto stadium;
    private UserDto manager;

    public UserDto getManager() {
        return manager;
    }

    public void setManager(UserDto manager) {
        this.manager = manager;
    }

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

    public LeagueDto getLeague() {
        return league;
    }

    public void setLeague(LeagueDto league) {
        this.league = league;
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

    public StadiumDto getStadium() {
        return stadium;
    }

    public void setStadium(StadiumDto stadium) {
        this.stadium = stadium;
    }
}

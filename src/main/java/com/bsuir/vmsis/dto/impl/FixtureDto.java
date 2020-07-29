package com.bsuir.vmsis.dto.impl;

import com.bsuir.vmsis.dto.BaseDto;

public class FixtureDto extends BaseDto {

    private Long number;
    private LeagueDto league;
    private SeasonDto season;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public LeagueDto getLeague() {
        return league;
    }

    public void setLeague(LeagueDto league) {
        this.league = league;
    }

    public SeasonDto getSeason() {
        return season;
    }

    public void setSeason(SeasonDto season) {
        this.season = season;
    }
}

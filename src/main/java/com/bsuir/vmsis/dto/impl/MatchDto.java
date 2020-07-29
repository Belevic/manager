package com.bsuir.vmsis.dto.impl;

import com.bsuir.vmsis.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchDto extends BaseDto {
    private Long homeScored;
    private Long guestScored;
    private Long yellow_cards;
    private Long red_cards;
    private FixtureDto fixture;
    private TeamDto homeTeam;
    private TeamDto guestTeam;
    private RefereeDto referee;
    private Long home_posession;
    private Long guest_posession;

    public Long getHome_posession() {
        return home_posession;
    }

    public void setHome_posession(Long home_posession) {
        this.home_posession = home_posession;
    }

    public Long getGuest_posession() {
        return guest_posession;
    }

    public void setGuest_posession(Long guest_posession) {
        this.guest_posession = guest_posession;
    }

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

    public FixtureDto getFixture() {
        return fixture;
    }

    public void setFixture(FixtureDto fixture) {
        this.fixture = fixture;
    }

    public TeamDto getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(TeamDto homeTeam) {
        this.homeTeam = homeTeam;
    }

    public TeamDto getGuestTeam() {
        return guestTeam;
    }

    public void setGuestTeam(TeamDto guestTeam) {
        this.guestTeam = guestTeam;
    }

    public RefereeDto getReferee() {
        return referee;
    }

    public void setReferee(RefereeDto referee) {
        this.referee = referee;
    }
}

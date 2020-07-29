package com.bsuir.vmsis.dto.impl;

import com.bsuir.vmsis.dto.BaseDto;

import javax.persistence.Column;

public class FinancesDto extends BaseDto {

    private Long amount;
    private Long winPrice;
    private Long drawPrice;
    private Long loosePrice;
    private Long fixturePrice;
    private TeamDto team;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getWinPrice() {
        return winPrice;
    }

    public void setWinPrice(Long winPrice) {
        this.winPrice = winPrice;
    }

    public Long getDrawPrice() {
        return drawPrice;
    }

    public void setDrawPrice(Long drawPrice) {
        this.drawPrice = drawPrice;
    }

    public Long getLoosePrice() {
        return loosePrice;
    }

    public void setLoosePrice(Long loosePrice) {
        this.loosePrice = loosePrice;
    }

    public Long getFixturePrice() {
        return fixturePrice;
    }

    public void setFixturePrice(Long fixturePrice) {
        this.fixturePrice = fixturePrice;
    }

    public TeamDto getTeam() {
        return team;
    }

    public void setTeam(TeamDto team) {
        this.team = team;
    }
}

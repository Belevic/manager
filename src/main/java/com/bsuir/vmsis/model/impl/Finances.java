package com.bsuir.vmsis.model.impl;


import com.bsuir.vmsis.model.BaseEntity;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "finances")
@Table(name = "finances")
public class Finances extends BaseEntity implements Serializable {

    @Column(name = "amount")
    private Long amount;

    @Column(name = "win_price")
    private Long winPrice;

    @Column(name = "draw_price")
    private Long drawPrice;

    @Column(name = "loose_price")
    private Long loosePrice;

    @Column(name = "fixture_price")
    private Long fixturePrice;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team teamFinances;

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

    public Team getTeamFinances() {
        return teamFinances;
    }

    public void setTeamFinances(Team teamFinances) {
        this.teamFinances = teamFinances;
    }
}
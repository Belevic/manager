package com.bsuir.vmsis.model.impl;

import com.bsuir.vmsis.model.BaseEntity;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "shooting")
@Table(name = "shooting")
public class Shooting extends BaseEntity implements Serializable {

    @Column(name = "positioning")
    private Long positioning;

    @Column(name = "finishing")
    private Long finishing;

    @Column(name = "shot_power")
    private Long shotPower;

    @Column(name = "long_shots")
    private Long longShots;

    @Column(name = "volleys")
    private Long volleys;

    @Column(name = "penalties")
    private Long penalties;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @Cascade(org.hibernate.annotations.CascadeType.REPLICATE)
    @JoinColumn (name="player_id",referencedColumnName = "id")
    private Player playerShooting;

    public Long getPositioning() {
        return positioning;
    }

    public void setPositioning(Long positioning) {
        this.positioning = positioning;
    }

    public Long getFinishing() {
        return finishing;
    }

    public void setFinishing(Long finishing) {
        this.finishing = finishing;
    }

    public Long getShotPower() {
        return shotPower;
    }

    public void setShotPower(Long shotPower) {
        this.shotPower = shotPower;
    }

    public Long getLongShots() {
        return longShots;
    }

    public void setLongShots(Long longShots) {
        this.longShots = longShots;
    }

    public Long getVolleys() {
        return volleys;
    }

    public void setVolleys(Long volleys) {
        this.volleys = volleys;
    }

    public Long getPenalties() {
        return penalties;
    }

    public void setPenalties(Long penalties) {
        this.penalties = penalties;
    }

    public Player getPlayerShooting() {
        return playerShooting;
    }

    public void setPlayerShooting(Player playerShooting) {
        this.playerShooting = playerShooting;
    }
}

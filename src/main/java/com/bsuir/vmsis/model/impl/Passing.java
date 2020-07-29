package com.bsuir.vmsis.model.impl;

import com.bsuir.vmsis.model.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "passing")
@Table(name = "passing")
public class Passing extends BaseEntity implements Serializable {

    @Column(name = "vision")
    private Long vision;

    @Column(name = "croosing")
    private Long croosing;

    @Column(name = "free_kick")
    private Long freeKick;

    @Column(name = "short_passing")
    private Long shortPassing;

    @Column(name = "long_passing")
    private Long longPassing;

    @Column(name = "curve")
    private Long curve;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @Cascade(org.hibernate.annotations.CascadeType.REPLICATE)
    @JoinColumn (name="player_id",referencedColumnName = "id")
    private Player playerPassing;

    public Long getVision() {
        return vision;
    }

    public void setVision(Long vision) {
        this.vision = vision;
    }

    public Long getCroosing() {
        return croosing;
    }

    public void setCroosing(Long croosing) {
        this.croosing = croosing;
    }

    public Long getFreeKick() {
        return freeKick;
    }

    public void setFreeKick(Long freeKick) {
        this.freeKick = freeKick;
    }

    public Long getShortPassing() {
        return shortPassing;
    }

    public void setShortPassing(Long shortPassing) {
        this.shortPassing = shortPassing;
    }

    public Long getLongPassing() {
        return longPassing;
    }

    public void setLongPassing(Long longPassing) {
        this.longPassing = longPassing;
    }

    public Long getCurve() {
        return curve;
    }

    public void setCurve(Long curve) {
        this.curve = curve;
    }

    public Player getPlayerPassing() {
        return playerPassing;
    }

    public void setPlayerPassing(Player playerPassing) {
        this.playerPassing = playerPassing;
    }
}

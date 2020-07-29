package com.bsuir.vmsis.model.impl;


import com.bsuir.vmsis.model.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "dribbling")
@Table(name = "dribbling")
public class Dribbling extends BaseEntity implements Serializable {

    @Column(name = "agility")
    private Long agility;

    @Column(name = "balance")
    private Long balance;

    @Column(name = "reactions")
    private Long reactions;

    @Column(name = "ball_controlling")
    private Long ballControlling;

    @Column(name = "dribbling")
    private Long dribbling;

    @Column(name = "composure")
    private Long composure;

    @Column(name = "pace_dribbling")
    private Long paceDribbling;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @Cascade(org.hibernate.annotations.CascadeType.REPLICATE)
    @JoinColumn (name="player_id",referencedColumnName = "id")
    private Player playerDribbling;

    public Long getAgility() {
        return agility;
    }

    public void setAgility(Long agility) {
        this.agility = agility;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long getReactions() {
        return reactions;
    }

    public void setReactions(Long reactions) {
        this.reactions = reactions;
    }

    public Long getBallControlling() {
        return ballControlling;
    }

    public void setBallControlling(Long ballControlling) {
        this.ballControlling = ballControlling;
    }

    public Long getDribbling() {
        return dribbling;
    }

    public void setDribbling(Long dribbling) {
        this.dribbling = dribbling;
    }

    public Long getComposure() {
        return composure;
    }

    public void setComposure(Long composure) {
        this.composure = composure;
    }

    public Long getPaceDribbling() {
        return paceDribbling;
    }

    public void setPaceDribbling(Long paceDribbling) {
        this.paceDribbling = paceDribbling;
    }

    public Player getPlayerDribbling() {
        return playerDribbling;
    }

    public void setPlayerDribbling(Player playerDribbling) {
        this.playerDribbling = playerDribbling;
    }
}

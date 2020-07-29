package com.bsuir.vmsis.dto.impl;

import com.bsuir.vmsis.dto.BaseDto;
import com.bsuir.vmsis.model.impl.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DribblingDto extends BaseDto {

    private Long agility;
    private Long balance;
    private Long reactions;
    private Long ballControlling;
    private Long dribbling;
    private Long composure;
    private Long paceDribbling;
    private PlayerDto player;

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

    public PlayerDto getPlayer() {
        return player;
    }

    public void setPlayer(PlayerDto player) {
        this.player = player;
    }
}

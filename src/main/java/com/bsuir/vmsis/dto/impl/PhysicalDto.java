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
public class PhysicalDto extends BaseDto {

    private Long jumping;
    private Long stamina;
    private Long strength;
    private Long aggression;
    private PlayerDto player;

    public Long getJumping() {
        return jumping;
    }

    public void setJumping(Long jumping) {
        this.jumping = jumping;
    }

    public Long getStamina() {
        return stamina;
    }

    public void setStamina(Long stamina) {
        this.stamina = stamina;
    }

    public Long getStrength() {
        return strength;
    }

    public void setStrength(Long strength) {
        this.strength = strength;
    }

    public Long getAggression() {
        return aggression;
    }

    public void setAggression(Long aggression) {
        this.aggression = aggression;
    }

    public PlayerDto getPlayer() {
        return player;
    }

    public void setPlayer(PlayerDto player) {
        this.player = player;
    }
}

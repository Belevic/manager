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
public class HealthDto extends BaseDto {

    private Long staminaLessing;
    private Long injuryResistance;
    private Long recovery;
    private Long overall;
    private PlayerDto player;

    public Long getStaminaLessing() {
        return staminaLessing;
    }

    public void setStaminaLessing(Long staminaLessing) {
        this.staminaLessing = staminaLessing;
    }

    public Long getInjuryResistance() {
        return injuryResistance;
    }

    public void setInjuryResistance(Long injuryResistance) {
        this.injuryResistance = injuryResistance;
    }

    public Long getRecovery() {
        return recovery;
    }

    public void setRecovery(Long recovery) {
        this.recovery = recovery;
    }

    public Long getOverall() {
        return overall;
    }

    public void setOverall(Long overall) {
        this.overall = overall;
    }

    public PlayerDto getPlayer() {
        return player;
    }

    public void setPlayer(PlayerDto player) {
        this.player = player;
    }
}

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
public class PassingDto extends BaseDto {

    private Long vision;
    private Long croosing;
    private Long freeKick;
    private Long shortPassing;
    private Long longPassing;
    private Long curve;
    private PlayerDto player;

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

    public PlayerDto getPlayer() {
        return player;
    }

    public void setPlayer(PlayerDto player) {
        this.player = player;
    }
}

package com.bsuir.vmsis.dto.impl;

import com.bsuir.vmsis.dto.BaseDto;
import com.bsuir.vmsis.model.impl.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShootingDto extends BaseDto {

    private Long positioning;
    private Long finishing;
    private Long shotPower;
    private Long longShots;
    private Long volleys;
    private Long penalties;
    private PlayerDto player;

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

    public PlayerDto getPlayer() {
        return player;
    }

    public void setPlayer(PlayerDto player) {
        this.player = player;
    }
}

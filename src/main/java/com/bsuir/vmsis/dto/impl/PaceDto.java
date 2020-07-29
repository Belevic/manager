package com.bsuir.vmsis.dto.impl;

import com.bsuir.vmsis.dto.BaseDto;
import com.bsuir.vmsis.model.impl.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaceDto extends BaseDto {

    private Long acceleration;
    private Long sprintSpeed;
    private PlayerDto player;

    public Long getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Long acceleration) {
        this.acceleration = acceleration;
    }

    public Long getSprintSpeed() {
        return sprintSpeed;
    }

    public void setSprintSpeed(Long sprintSpeed) {
        this.sprintSpeed = sprintSpeed;
    }

    public PlayerDto getPlayer() {
        return player;
    }

    public void setPlayer(PlayerDto player) {
        this.player = player;
    }
}

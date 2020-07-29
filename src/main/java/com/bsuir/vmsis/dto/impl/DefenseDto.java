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
public class DefenseDto extends BaseDto {

    private Long interceptions;
    private Long heading;
    private Long standingTackle;
    private Long slideTackle;
    private PlayerDto player;

    public Long getInterceptions() {
        return interceptions;
    }

    public void setInterceptions(Long interceptions) {
        this.interceptions = interceptions;
    }

    public Long getHeading() {
        return heading;
    }

    public void setHeading(Long heading) {
        this.heading = heading;
    }

    public Long getStandingTackle() {
        return standingTackle;
    }

    public void setStandingTackle(Long standingTackle) {
        this.standingTackle = standingTackle;
    }

    public Long getSlideTackle() {
        return slideTackle;
    }

    public void setSlideTackle(Long slideTackle) {
        this.slideTackle = slideTackle;
    }

    public PlayerDto getPlayer() {
        return player;
    }

    public void setPlayer(PlayerDto player) {
        this.player = player;
    }
}

package com.bsuir.vmsis.dto.impl;

import com.bsuir.vmsis.dto.BaseDto;
import com.bsuir.vmsis.model.impl.Player;
import com.bsuir.vmsis.model.impl.Team;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;

@Data
public class TransferDto extends BaseDto {

    private Long price;
    private LocalDate date;
    private TeamDto fromTeam;
    private TeamDto toTeam;
    private PlayerDto player;

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public TeamDto getFromTeam() {
        return fromTeam;
    }

    public void setFromTeam(TeamDto fromTeam) {
        this.fromTeam = fromTeam;
    }

    public TeamDto getToTeam() {
        return toTeam;
    }

    public void setToTeam(TeamDto toTeam) {
        this.toTeam = toTeam;
    }

    public PlayerDto getPlayer() {
        return player;
    }

    public void setPlayer(PlayerDto player) {
        this.player = player;
    }
}

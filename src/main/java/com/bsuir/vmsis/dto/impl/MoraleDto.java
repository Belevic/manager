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
public class MoraleDto extends BaseDto {

    private Long leadership;
    private Long stressfull;
    private Long overall;
    private Long rampage;
    private String character;
    private PlayerDto player;

    public Long getLeadership() {
        return leadership;
    }

    public void setLeadership(Long leadership) {
        this.leadership = leadership;
    }

    public Long getStressfull() {
        return stressfull;
    }

    public void setStressfull(Long stressfull) {
        this.stressfull = stressfull;
    }

    public Long getOverall() {
        return overall;
    }

    public void setOverall(Long overall) {
        this.overall = overall;
    }

    public Long getRampage() {
        return rampage;
    }

    public void setRampage(Long rampage) {
        this.rampage = rampage;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public PlayerDto getPlayer() {
        return player;
    }

    public void setPlayer(PlayerDto player) {
        this.player = player;
    }
}

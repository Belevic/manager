package com.bsuir.vmsis.model.impl;

import com.bsuir.vmsis.model.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "pace")
@Table(name = "pace")
public class Pace extends BaseEntity implements Serializable {

    @Column(name = "acceleration")
    private Long acceleration;

    @Column(name = "sprint_speed")
    private Long sprintSpeed;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @Cascade(org.hibernate.annotations.CascadeType.REPLICATE)
    @JoinColumn (name="player_id",referencedColumnName = "id")
    private Player playerPace;

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

    public Player getPlayerPace() {
        return playerPace;
    }

    public void setPlayerPace(Player playerPace) {
        this.playerPace = playerPace;
    }
}

package com.bsuir.vmsis.model.impl;

import com.bsuir.vmsis.model.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "physical")
@Table(name = "physical")
public class Physical extends BaseEntity implements Serializable {

    @Column(name = "jumping")
    private Long jumping;

    @Column(name = "stamina")
    private Long stamina;

    @Column(name = "strength")
    private Long strength;

    @Column(name = "aggression")
    private Long aggression;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @Cascade(org.hibernate.annotations.CascadeType.REPLICATE)
    @JoinColumn(name="player_id",referencedColumnName = "id")
    private Player playerPhysical;

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

    public Player getPlayerPhysical() {
        return playerPhysical;
    }

    public void setPlayerPhysical(Player playerPhysical) {
        this.playerPhysical = playerPhysical;
    }
}

package com.bsuir.vmsis.model.impl;

import com.bsuir.vmsis.model.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "defense")
@Table(name = "defense")
public class Defense extends BaseEntity implements Serializable {

    @Column(name = "interceptions")
    private Long interceptions;

    @Column(name = "heading")
    private Long heading;

    @Column(name = "standing_tackle")
    private Long standingTackle;

    @Column(name = "slide_tackle")
    private Long slideTackle;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @Cascade(org.hibernate.annotations.CascadeType.REPLICATE)
    @JoinColumn (name="player_id",referencedColumnName = "id")
    private Player playerDefense;

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

    public Player getPlayerDefense() {
        return playerDefense;
    }

    public void setPlayerDefense(Player playerDefense) {
        this.playerDefense = playerDefense;
    }
}

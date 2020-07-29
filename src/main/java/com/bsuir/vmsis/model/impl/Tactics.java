package com.bsuir.vmsis.model.impl;

import com.bsuir.vmsis.model.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "tactics")
@Table(name = "tactics")
public class Tactics extends BaseEntity implements Serializable {

    @Column(name = "game_style")
    private String gameStyle;

    @Column(name = "attacking_style")
    private String attackingStyle;

    @Column(name = "midlefielding_style")
    private String midlefieldingStyle;

    @Column(name = "defense_style")
    private String defenseStyle;

    @Column(name = "custody")
    private String custody;

    @Column(name = "offside_trap")
    private Boolean offsideTrap;

    @Column(name = "tackling")
    private String tackling;

    @Column(name = "pressing")
    private Long pressing;

    @Column(name = "style")
    private String style;

    @Column(name = "game_pace")
    private Long gamePace;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn (name="team_id",referencedColumnName = "id")
    private Team teamTactics;

    public String getGameStyle() {
        return gameStyle;
    }

    public void setGameStyle(String gameStyle) {
        this.gameStyle = gameStyle;
    }

    public String getAttackingStyle() {
        return attackingStyle;
    }

    public void setAttackingStyle(String attackingStyle) {
        this.attackingStyle = attackingStyle;
    }

    public String getMidlefieldingStyle() {
        return midlefieldingStyle;
    }

    public void setMidlefieldingStyle(String midlefieldingStyle) {
        this.midlefieldingStyle = midlefieldingStyle;
    }

    public String getDefenseStyle() {
        return defenseStyle;
    }

    public void setDefenseStyle(String defenseStyle) {
        this.defenseStyle = defenseStyle;
    }

    public String getCustody() {
        return custody;
    }

    public void setCustody(String custody) {
        this.custody = custody;
    }

    public Boolean getOffsideTrap() {
        return offsideTrap;
    }

    public void setOffsideTrap(Boolean offsideTrap) {
        this.offsideTrap = offsideTrap;
    }

    public String getTackling() {
        return tackling;
    }

    public void setTackling(String tackling) {
        this.tackling = tackling;
    }

    public Long getPressing() {
        return pressing;
    }

    public void setPressing(Long pressing) {
        this.pressing = pressing;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Long getGamePace() {
        return gamePace;
    }

    public void setGamePace(Long gamePace) {
        this.gamePace = gamePace;
    }

    public Team getTeamTactics() {
        return teamTactics;
    }

    public void setTeamTactics(Team teamTactics) {
        this.teamTactics = teamTactics;
    }
}

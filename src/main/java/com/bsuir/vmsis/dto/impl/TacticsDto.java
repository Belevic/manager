package com.bsuir.vmsis.dto.impl;

import com.bsuir.vmsis.dto.BaseDto;

import javax.persistence.Column;

public class TacticsDto extends BaseDto {

    private String gameStyle;
    private String attackingStyle;
    private String midlefieldingStyle;
    private String defenseStyle;
    private String custody;
    private Boolean offsideTrap;
    private String tackling;
    private Long pressing;
    private String style;
    private Long gamePace;
    private TeamDto team;

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

    public TeamDto getTeam() {
        return team;
    }

    public void setTeam(TeamDto team) {
        this.team = team;
    }
}

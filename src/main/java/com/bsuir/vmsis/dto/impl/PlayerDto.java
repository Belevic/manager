package com.bsuir.vmsis.dto.impl;

import com.bsuir.vmsis.dto.BaseDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDto extends BaseDto {
    private String name;
    private String surname;
    private LocalDate birthday;
    private String position;
    private Long number;
    private Long progress;
    private Long morale;
    private Long health;
    private String playerImage;
    private Long overall;
    private Long internationalRanting;
    private Boolean inLineUp;
    private Boolean onTransfer;
    private Boolean onTraining;
    private String type;
    private SquadDto squad;
    private LineUpDto lineUp;
    private CountryDto country;
    private PlayerPriceDto price;

    public Boolean getInLineUp() {
        return inLineUp;
    }

    public void setInLineUp(Boolean inLineUp) {
        this.inLineUp = inLineUp;
    }

    public Boolean getOnTransfer() {
        return onTransfer;
    }

    public void setOnTransfer(Boolean onTransfer) {
        this.onTransfer = onTransfer;
    }

    public Boolean getOnTraining() {
        return onTraining;
    }

    public void setOnTraining(Boolean onTraining) {
        this.onTraining = onTraining;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getPlayerImage() {
        return playerImage;
    }

    public void setPlayerImage(String playerImage) {
        this.playerImage = playerImage;
    }

    public Long getOverall() {
        return overall;
    }

    public void setOverall(Long overall) {
        this.overall = overall;
    }

    public Long getInternationalRanting() {
        return internationalRanting;
    }

    public void setInternationalRanting(Long internationalRanting) {
        this.internationalRanting = internationalRanting;
    }

    public boolean isInLineUp() {
        return inLineUp;
    }

    public void setInLineUp(boolean inLineUp) {
        this.inLineUp = inLineUp;
    }

    public SquadDto getSquad() {
        return squad;
    }

    public void setSquad(SquadDto squad) {
        this.squad = squad;
    }

    public LineUpDto getLineUp() {
        return lineUp;
    }

    public void setLineUp(LineUpDto lineUp) {
        this.lineUp = lineUp;
    }

    public CountryDto getCountry() {
        return country;
    }

    public void setCountry(CountryDto country) {
        this.country = country;
    }

    public Long getProgress() {
        return progress;
    }

    public void setProgress(Long progress) {
        this.progress = progress;
    }

    public PlayerPriceDto getPrice() {
        return price;
    }

    public void setPrice(PlayerPriceDto price) {
        this.price = price;
    }

    public Long getMorale() {
        return morale;
    }

    public void setMorale(Long morale) {
        this.morale = morale;
    }

    public Long getHealth() {
        return health;
    }

    public void setHealth(Long health) {
        this.health = health;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

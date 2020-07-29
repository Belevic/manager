package com.bsuir.vmsis.dto.impl;

import com.bsuir.vmsis.dto.BaseDto;

import javax.persistence.Column;

public class RefereeDto extends BaseDto {

    private String name;
    private String surname;
    private String character;
    private Long loyality;

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

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public Long getLoyality() {
        return loyality;
    }

    public void setLoyality(Long loyality) {
        this.loyality = loyality;
    }
}

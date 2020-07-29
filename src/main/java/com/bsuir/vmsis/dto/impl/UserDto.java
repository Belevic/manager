package com.bsuir.vmsis.dto.impl;

import com.bsuir.vmsis.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserDto extends BaseDto {

    /*@NotBlank(message = "Please, provide user name, it can't be null or consists of spaces only!")
    @Pattern(regexp = "^[a-zA-Z]{1,40}$", message = "User name must consist of letters only!")
   @Size(min = 1,max = 40,message = "User name length should be more than 1 and less than 40 symbols length!")
    */private String name;

  /*  @NotBlank(message = "Please, provide user surname, it can't be null or consists of spaces only!")
    @Pattern(regexp = "^[a-zA-Z]{1,40}$", message = "User surname must consist of letters only!")
    @Size(min = 1,max = 40,message = "User surname length should be more than 1 and less than 40 symbols length!")
    */private String surname;
/*
    @NotBlank(message = "Please, provide user login(email), it can't be null or consists of spaces only!")
    @Size(min = 1,max = 88,message = "User login(email) length should be more than 1 and less than 88 symbols length!")
  */  private String login;
/*
    @NotBlank(message = "Please, provide user password, it can't be null or consists of spaces only!")
    @Pattern(regexp = "^[a-zA-Z0-9]{1,40}$", message = "User password must consist of letters and numbers only!")
    @Size(min = 1,max = 40,message = "User password length should be more than 1 and less than 40 symbols and" +
            " numbers length!")*/
    private String password;

    private String role;

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

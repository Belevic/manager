package com.bsuir.vmsis.mapper.impl;

import com.bsuir.vmsis.dto.impl.UserDto;
import com.bsuir.vmsis.mapper.CustomMapper;
import com.bsuir.vmsis.model.impl.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper implements CustomMapper<UserDto, User> {

    @Autowired
    private ModelMapper mapper;

    public UserMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public UserDto toDto(User user) {
        return mapper.map(user,UserDto.class);
    }

    @Override
    public User fromDto(UserDto userDto) {
        return mapper.map(userDto,User.class);
    }

    @Override
    public List<UserDto> listToDto(List<User> entities) {
        return entities.stream().map(user -> toDto(user)).collect(Collectors.toList());
    }

    @Override
    public List<User> listFromDto(List<UserDto> dtos) {
        return dtos.stream().map(user -> fromDto(user)).collect(Collectors.toList());
    }
}


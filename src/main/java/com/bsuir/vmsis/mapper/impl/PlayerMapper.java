package com.bsuir.vmsis.mapper.impl;

import com.bsuir.vmsis.dto.impl.PlayerDto;
import com.bsuir.vmsis.dto.impl.SeasonDto;
import com.bsuir.vmsis.mapper.CustomMapper;
import com.bsuir.vmsis.model.impl.Player;
import com.bsuir.vmsis.model.impl.Season;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlayerMapper implements CustomMapper<PlayerDto, Player> {

    @Autowired
    private ModelMapper mapper;

    public PlayerMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public PlayerDto toDto(Player player) {
        return mapper.map(player, PlayerDto.class);
    }

    @Override
    public Player fromDto(PlayerDto playerDto) {
        return mapper.map(playerDto, Player.class);
    }

    @Override
    public List<PlayerDto> listToDto(List<Player> entities) {
        return entities.stream().map(season -> toDto(season)).collect(Collectors.toList());
    }

    @Override
    public List<Player> listFromDto(List<PlayerDto> dtos) {
        return dtos.stream().map(season -> fromDto(season)).collect(Collectors.toList());
    }
}


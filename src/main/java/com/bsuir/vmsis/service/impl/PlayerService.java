package com.bsuir.vmsis.service.impl;

import com.bsuir.vmsis.dto.impl.*;
import com.bsuir.vmsis.mapper.impl.*;
import com.bsuir.vmsis.model.impl.*;
import com.bsuir.vmsis.repository.*;
import com.bsuir.vmsis.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService implements EntityService<PlayerDto> {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    PlayerPriceRepository playerPriceRepository;

    @Autowired
    PaceRepository paceRepository;

    @Autowired
    DribblingRepository dribblingRepository;

    @Autowired
    DefenseRepository defenseRepository;

    @Autowired
    ShootingRepository shootingRepository;

    @Autowired
    PassingRepository passingRepository;

    @Autowired
    PhysicalRepository physicalRepository;

    @Autowired
    PlayerPriceMapper playerPriceMapper;

    @Autowired
    PaceMapper paceMapper;

    @Autowired
    PassingMapper passingMapper;

    @Autowired
    ShootingMapper shootingMapper;

    @Autowired
    DefenseMapper defenseMapper;

    @Autowired
    PhysicalMapper physicalMapper;

    @Autowired
    DribblingMapper dribblingMapper;

    @Autowired
    PlayerMapper playerMapper;

    @Autowired
    SquadMapper squadMapper;

    @Autowired
    LineUpMapper lineUpMapper;

    public PlayerService(PlayerRepository playerRepository, PlayerMapper playerMapper, DribblingRepository dribblingRepository,
                         DefenseRepository defenseRepository, PassingRepository passingRepository,
                         ShootingRepository shootingRepository, PhysicalRepository physicalRepository,
                         PaceRepository paceRepository, DribblingMapper dribblingMapper,PassingMapper passingMapper,
                         DefenseMapper defenseMapper, PaceMapper paceMapper, ShootingMapper shootingMapper,
                         PhysicalMapper physicalMapper,PlayerPriceRepository playerPriceRepository,
                         PlayerPriceMapper playerPriceMapper,SquadMapper squadMapper, LineUpMapper lineUpMapper) {
        this.playerRepository = playerRepository;
        this.paceRepository = paceRepository;
        this.passingRepository = passingRepository;
        this.defenseRepository = defenseRepository;
        this.dribblingRepository = dribblingRepository;
        this.shootingRepository = shootingRepository;
        this.physicalRepository = physicalRepository;
        this.playerMapper = playerMapper;
        this.dribblingMapper = dribblingMapper;
        this.passingMapper = passingMapper;
        this.paceMapper = paceMapper;
        this.shootingMapper = shootingMapper;
        this.defenseMapper = defenseMapper;
        this.physicalMapper = physicalMapper;
        this.playerPriceRepository = playerPriceRepository;
        this.playerPriceMapper = playerPriceMapper;
        this.squadMapper = squadMapper;
        this.lineUpMapper = lineUpMapper;
    }

    @Override
    public PlayerDto create(PlayerDto entity) {
        return playerMapper.toDto(playerRepository.save(playerMapper.fromDto(entity)));
    }

    @Override
    public PlayerDto update(PlayerDto entity) {
        Player player = playerRepository.findById(entity.getId()).get();
        player.setOnTraining(entity.getOnTraining());
        player.setInLineUp(entity.getInLineUp());
        player.setOnTransfer(entity.getOnTransfer());
        player.setHealth(entity.getHealth());
        player.setMorale(entity.getMorale());
        player.setOverall(entity.getOverall());
        player.setSquad(squadMapper.fromDto(entity.getSquad()));
        player.setLineUp(lineUpMapper.fromDto(entity.getLineUp()));
        return playerMapper.toDto(playerRepository.save(player));
    }

    @Override
    public void delete(Long id) {
        playerRepository.deleteById(id);
    }

    @Override
    public PlayerDto getById(Long id) {
        return playerMapper.toDto(playerRepository.findById(id).get());
    }

    @Override
    public List<PlayerDto> getEntities() {
        List<Player> result = new ArrayList<Player>();
        playerRepository.findAll().forEach(result::add);
        return (playerMapper.listToDto(result));
    }

    public PaceDto getPlayerPace(Long id){
        return paceMapper.toDto(paceRepository.findByPlayerPaceId(id));
    }

    public DefenseDto getPlayerDefense(Long id){
        return defenseMapper.toDto(defenseRepository.findByPlayerDefenseId(id));
    }

    public PassingDto getPlayerPassing(Long id){
        return passingMapper.toDto(passingRepository.findByPlayerPassingId(id));
    }

    public ShootingDto getPlayerShooting(Long id){
        return shootingMapper.toDto(shootingRepository.findByPlayerShootingId(id));
    }

    public PhysicalDto getPlayerPhysical(Long id){
        return physicalMapper.toDto(physicalRepository.findByPlayerPhysicalId(id));
    }

    public DribblingDto getOverallDribbling(Long id){
        return dribblingMapper.toDto(dribblingRepository.findByPlayerDribblingId(id));
    }

    public List<PlayerDto> getBySquadId(Long id){
        List<Player> result = new ArrayList<Player>();
        playerRepository.findAllBySquadId(id).forEach(result::add);
        return (playerMapper.listToDto(result));
    }

    public List<PlayerDto> getOnTransfer(Boolean onTransfer){
        List<Player> result = new ArrayList<Player>();
        playerRepository.findByOnTransfer(onTransfer).forEach(result::add);
        return (playerMapper.listToDto(result));
    }
}

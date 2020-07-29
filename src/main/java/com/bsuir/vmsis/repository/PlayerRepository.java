package com.bsuir.vmsis.repository;

import com.bsuir.vmsis.model.impl.League;
import com.bsuir.vmsis.model.impl.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
    List<Player> findAllBySquadId(Long id);
    List<Player> findByPlayerCountryId(Long id);
    List<Player> findByLineUpIdAndInLineUp(Long id,Boolean inLineUp);
    List<Player> findByOnTransfer(Boolean onTraining);
}

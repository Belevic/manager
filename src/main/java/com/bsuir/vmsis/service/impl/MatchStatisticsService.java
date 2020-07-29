package com.bsuir.vmsis.service.impl;

import com.bsuir.vmsis.dto.impl.MatchDto;
import com.bsuir.vmsis.dto.impl.MatchStatisticsDto;
import com.bsuir.vmsis.dto.impl.TeamDto;
import com.bsuir.vmsis.mapper.impl.MatchStatisticsMapper;
import com.bsuir.vmsis.model.impl.Match;
import com.bsuir.vmsis.model.impl.MatchStatistics;
import com.bsuir.vmsis.repository.MatchRepository;
import com.bsuir.vmsis.repository.MatchStatisticsRepository;
import com.bsuir.vmsis.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class MatchStatisticsService implements EntityService<MatchStatisticsDto> {

    @Autowired
    private MatchStatisticsRepository repository;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private MatchStatisticsMapper mapper;

    public MatchStatisticsService(MatchStatisticsRepository repository,
                                  MatchRepository matchRepository, MatchStatisticsMapper mapper) {
        this.repository = repository;
        this.matchRepository = matchRepository;
        this.mapper = mapper;
    }

    @Override
    public MatchStatisticsDto create(MatchStatisticsDto entity) {
        return mapper.toDto(repository.save(mapper.fromDto(entity)));
    }

    @Override
    public MatchStatisticsDto update(MatchStatisticsDto entity) {
        return mapper.toDto(repository.save(mapper.fromDto(entity)));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public MatchStatisticsDto getById(Long id) {
        return mapper.toDto(repository.findById(id).get());
    }

    @Override
    public List<MatchStatisticsDto> getEntities() {
        List<MatchStatistics> result = new ArrayList<MatchStatistics>();
        repository.findAll().forEach(result::add);
        return (mapper.listToDto(result));
    }

    public List<MatchStatisticsDto> getByMatchId(Long id){
        Comparator<MatchStatisticsDto> comparator =
                Comparator.comparingLong(MatchStatisticsDto::getTime).reversed();
        List<MatchStatisticsDto> result = mapper.listToDto(repository.findByMatchStatisticsId(id));
        Collections.sort(result,comparator);
        return result;
    }

    public List<List<MatchStatisticsDto>> getMatchesStatsByFixtureId(Long id){
        List<Match> matches = matchRepository.findByFixtureId(id);
        List<List<MatchStatisticsDto>> stats = new ArrayList<>();
        for(Match match : matches){
            List<MatchStatistics> statistics = repository.findByMatchStatisticsId(match.getId());
            stats.add(mapper.listToDto(statistics));
        }
        return stats;
    }
}
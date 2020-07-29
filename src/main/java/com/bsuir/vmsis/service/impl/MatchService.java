package com.bsuir.vmsis.service.impl;

import com.bsuir.vmsis.dto.impl.MatchDto;
import com.bsuir.vmsis.mapper.impl.FixtureMapper;
import com.bsuir.vmsis.mapper.impl.MatchMapper;
import com.bsuir.vmsis.mapper.impl.RefereeMapper;
import com.bsuir.vmsis.mapper.impl.TeamMapper;
import com.bsuir.vmsis.model.impl.Match;
import com.bsuir.vmsis.repository.FixtureRepository;
import com.bsuir.vmsis.repository.MatchRepository;
import com.bsuir.vmsis.repository.RefereeRepository;
import com.bsuir.vmsis.repository.TeamRepository;
import com.bsuir.vmsis.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchService implements EntityService<MatchDto> {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private FixtureRepository fixtureRepository;

    @Autowired
    private RefereeRepository refereeRepository;

    @Autowired
    private MatchMapper matchMapper;

    @Autowired
    private FixtureMapper fixtureMapper;

    @Autowired
    private TeamMapper teamMapper;

    @Autowired
    private RefereeMapper refereeMapper;

    public MatchService(MatchRepository matchRepository, FixtureRepository fixtureRepository,
                        TeamRepository teamRepository, RefereeRepository refereeRepository,
                        FixtureMapper fixtureMapper, TeamMapper teamMapper, RefereeMapper refereeMapper,
                        MatchMapper matchMapper) {
        this.matchRepository = matchRepository;
        this.fixtureRepository = fixtureRepository;
        this.teamRepository = teamRepository;
        this.refereeRepository = refereeRepository;
        this.matchMapper = matchMapper;
        this.fixtureMapper = fixtureMapper;
        this.refereeMapper = refereeMapper;
        this.teamMapper = teamMapper;
    }

    @Override
    public MatchDto create(MatchDto entity) {
        return matchMapper.toDto(matchRepository.save(matchMapper.fromDto(entity)));
    }

    @Override
    public MatchDto update(MatchDto entity) {
        return matchMapper.toDto(matchRepository.save(matchMapper.fromDto(entity)));
    }

    @Override
    public void delete(Long id) {
        matchRepository.deleteById(id);
    }

    @Override
    public MatchDto getById(Long id) {
        return matchMapper.toDto(matchRepository.findById(id).get());
    }

    @Override
    public List<MatchDto> getEntities() {
        List<Match> result = new ArrayList<Match>();
        matchRepository.findAll().forEach(result::add);
        return (matchMapper.listToDto(result));
    }

    public MatchDto getByHomeOrGuestTeamId(Long id,Long fixtureId){
        return matchMapper.toDto(matchRepository.findByHomeTeamIdAndFixtureId(id,fixtureId));
    }

    public List<List<MatchDto>> getMatchesGroupByFixture(){
        List<List<MatchDto>> result = new ArrayList<>();
        List<MatchDto> all = getEntities();
        for(int i = 19; i <= 56; i++){
            List<MatchDto> current = new ArrayList<>();
            for(int j = 0; j < all.size(); j++){
                if(all.get(j).getFixture().getId() == i) {
                    current.add(all.get(j));
                }
            }
            result.add(current);
        }
        return result;
    }
/*
    public void generateMatchShedule(Long id, Long teamId) {
        int[] cycle = new int[20];
        int n = 10;
        for (int i = 0; i < n; i++) {
            cycle[i] = i + 1;
            cycle[20 - i - 1] = cycle[i] + n;
        }
        for (int d = 1; d <= 19; d++) {
            for (int i = 0; i < n; i++,id++) {
                TeamDto homeTeam = teamMapper.toDto(teamRepository.findById((long) cycle[i + (teamId]).get());
                TeamDto guestTeam = teamMapper.toDto(teamRepository.findById((long) cycle[20 - i - 1 + teamId]).get());
                FixtureDto fixture = fixtureMapper.toDto(fixtureRepository.findById(id).get());
                RefereeDto referee = refereeMapper.toDto(refereeRepository.findById((long)i+1).get());
                MatchDto match = new MatchDto();
                match.setHomeTeam(homeTeam);
                match.setGuestTeam(guestTeam);
                match.setFixture(fixture);
                match.setReferee(referee);
                match.setGuestScored((long)0);
                match.setHomeScored((long)0);
                match.setRed_cards((long)0);
                match.setYellow_cards((long)0);
                matchRepository.save(matchMapper.fromDto(match));
            }
            int temp = cycle[1];
            for (int i = 1; i < 20 - 1; i++) {
                int pr = cycle[i + 1];
                cycle[i + 1] = temp;
                temp = pr;
            }
            cycle[1] = temp;
        }
        for (int d = 1; d <= 19; d++) {
            for (int i = 0; i < n; i++,id++) {
                TeamDto homeTeam = teamMapper.toDto(teamRepository.findById((long) cycle[20 - i- 1 + teamId]).get());
                TeamDto guestTeam = teamMapper.toDto(teamRepository.findById((long) cycle[i + teamId]).get());
                FixtureDto fixture = fixtureMapper.toDto(fixtureRepository.findById(id).get());
                RefereeDto referee = refereeMapper.toDto(refereeRepository.findById((long)i+1).get());
                MatchDto match = new MatchDto();
                match.setHomeTeam(homeTeam);
                match.setGuestTeam(guestTeam);
                match.setFixture(fixture);
                match.setReferee(referee);
                match.setGuestScored((long)0);
                match.setHomeScored((long)0);
                match.setRed_cards((long)0);
                match.setYellow_cards((long)0);
                matchRepository.save(matchMapper.fromDto(match));
            }
            int temp = cycle[1];
            for (int i = 1; i < 20 - 1; i++) {
                int pr = cycle[i + 1];
                cycle[i + 1] = temp;
                temp = pr;
            }
            cycle[1] = temp;
        }

    }*/
}



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
import java.util.Random;

@Service
public class FixtureService implements EntityService<FixtureDto> {

    @Autowired
    private FixtureRepository fixtureRepository;

    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private MatchStatisticsRepository matchStatisticsRepository;

    @Autowired
    private LeagueRepository leagueRepository;

    @Autowired
    private SquadRepository squadRepository;

    @Autowired
    private TrainingRepository trainingRepository;

    @Autowired
    private HealthRepository healthRepository;

    @Autowired
    private MoraleRepository moraleRepository;

    @Autowired
    private FinancesRepository financesRepository;

    @Autowired
    private TacticsRepository tacticsRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private LineUpRepository lineUpRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private FixtureMapper fixtureMapper;

    @Autowired
    private SeasonMapper seasonMapper;

    @Autowired
    private LeagueMapper leagueMapper;

    @Autowired
    private HealthMapper healthMapper;

    @Autowired
    private MoraleMapper moraleMapper;

    @Autowired
    private FinancesMapper financesMapper;

    @Autowired
    private TacticsMapper tacticsMapper;

    @Autowired
    private PlayerMapper playerMapper;

    @Autowired
    private MatchStatisticsMapper matchStatisticsMapper;

    @Autowired
    private LineUpMapper lineUpMapper;

    @Autowired
    private TeamMapper teamMapper;

    @Autowired
    private MatchMapper matchMapper;

    @Autowired
    private TrainingMapper trainingMapper;

    @Autowired
    private SquadMapper squadMapper;

    @Autowired
    private PlayerService playerService;

    public FixtureService(FixtureRepository fixtureRepository, MatchRepository matchRepository,
                          TacticsRepository tacticsRepository, LineUpRepository lineUpRepository,
                          PlayerRepository playerRepository, FinancesRepository financesRepository,
                          MoraleRepository moraleRepository, HealthRepository healthRepository,
                          LeagueRepository leagueRepository, SeasonRepository seasonRepository,
                          SquadRepository squadRepository, TrainingRepository trainingRepository,
                          MatchStatisticsRepository matchStatisticsRepository,
                          LeagueMapper leagueMapper,SeasonMapper seasonMapper,PlayerMapper playerMapper,
                          FixtureMapper fixtureMapper, LineUpMapper lineUpMapper,
                          TacticsMapper tacticsMapper, MatchMapper matchMapper, HealthMapper healthMapper,
                          MoraleMapper moraleMapper, TeamMapper teamMapper,MatchStatisticsMapper matchStatisticsMapper,
                          SquadMapper squadMapper, TrainingMapper trainingMapper, PlayerService playerService,
                          FinancesMapper financesMapper,TeamRepository teamRepository) {
        this.fixtureRepository = fixtureRepository;
        this.teamRepository = teamRepository;
        this.squadRepository = squadRepository;
        this.trainingRepository = trainingRepository;
        this.matchStatisticsRepository = matchStatisticsRepository;
        this.leagueRepository = leagueRepository;
        this.seasonRepository = seasonRepository;
        this.financesRepository = financesRepository;
        this.moraleRepository = moraleRepository;
        this.healthRepository = healthRepository;
        this.tacticsRepository = tacticsRepository;
        this.lineUpRepository = lineUpRepository;
        this.playerRepository = playerRepository;
        this.matchRepository = matchRepository;
        this.fixtureMapper = fixtureMapper;
        this.matchStatisticsMapper = matchStatisticsMapper;
        this.seasonMapper = seasonMapper;
        this.squadMapper = squadMapper;
        this.trainingMapper = trainingMapper;
        this.leagueMapper = leagueMapper;
        this.teamMapper = teamMapper;
        this.financesMapper = financesMapper;
        this.moraleMapper = moraleMapper;
        this.healthMapper = healthMapper;
        this.playerService = playerService;
        this.tacticsMapper = tacticsMapper;
        this.playerMapper = playerMapper;
        this.lineUpMapper = lineUpMapper;
        this.matchMapper = matchMapper;
    }

    @Override
    public FixtureDto create(FixtureDto entity) {
        return fixtureMapper.toDto(fixtureRepository.save(fixtureMapper.fromDto(entity)));
    }

    @Override
    public FixtureDto update(FixtureDto entity) {
        return fixtureMapper.toDto(fixtureRepository.save(fixtureMapper.fromDto(entity)));
    }

    @Override
    public void delete(Long id) {
        fixtureRepository.deleteById(id);
    }

    @Override
    public FixtureDto getById(Long id) {
        return fixtureMapper.toDto(fixtureRepository.findById(id).get());
    }

    public List<MatchDto> getByFixtureId(Long id){
        return matchMapper.listToDto(matchRepository.findByFixtureId(id));
    }

    @Override
    public List<FixtureDto> getEntities() {
        List<Fixture> result = new ArrayList<Fixture>();
        fixtureRepository.findAll().forEach(result::add);
        return (fixtureMapper.listToDto(result));
    }

    public void generateFixtureShedule(Long id){
        for(int i = 1; i < 39; i++){
            FixtureDto fixture = new FixtureDto();
            LeagueDto league = leagueMapper.toDto(leagueRepository.findById(id).get());
            SeasonDto season = seasonMapper.toDto(seasonRepository.findById(id).get());
            fixture.setLeague(league);
            fixture.setNumber(fixtureRepository.count() + 1);
            fixture.setSeason(season);
            fixtureRepository.save(fixtureMapper.fromDto(fixture));
        }
    }

    private Long countDefenseTackling(Long defenseHomeValue, RefereeDto referee, TacticsDto homeTactics){
        if(homeTactics.getTackling() == "careful" && referee.getCharacter() == "careful"){
            defenseHomeValue -= defenseHomeValue % (referee.getLoyality());
        }
        if(homeTactics.getTackling() == "normal" && referee.getCharacter() == "careful"){
            defenseHomeValue -= defenseHomeValue % (referee.getLoyality() + 1);
        }
        if(homeTactics.getTackling() == "aggresive" && referee.getCharacter() == "careful"){
            defenseHomeValue -= defenseHomeValue % (referee.getLoyality() + 2);
        }
        if(homeTactics.getTackling() == "reckless" && referee.getCharacter() == "aggresive"){
            defenseHomeValue -= defenseHomeValue % (referee.getLoyality() + 3);
        }
        if(homeTactics.getTackling() == "careful" && referee.getCharacter() == "normal"){
            defenseHomeValue -= defenseHomeValue % (referee.getLoyality());
        }
        if(homeTactics.getTackling() == "normal" && referee.getCharacter() == "normal"){
            defenseHomeValue -= defenseHomeValue % (referee.getLoyality() + 2);
        }
        if(homeTactics.getTackling() == "aggresive" && referee.getCharacter() == "normal"){
            defenseHomeValue -= defenseHomeValue % (referee.getLoyality() + 3);
        }
        if(homeTactics.getTackling() == "reckless" && referee.getCharacter() == "aggresive"){
            defenseHomeValue -= defenseHomeValue % (referee.getLoyality() + 4);
        }
        if(homeTactics.getTackling() == "careful" && referee.getCharacter() == "aggresive"){
            defenseHomeValue -= defenseHomeValue % (referee.getLoyality());
        }
        if(homeTactics.getTackling() == "normal" && referee.getCharacter() == "aggresive"){
            defenseHomeValue -= defenseHomeValue % (referee.getLoyality() + 3);
        }
        if(homeTactics.getTackling() == "aggresive" && referee.getCharacter() == "aggresive"){
            defenseHomeValue -= defenseHomeValue % (referee.getLoyality() + 4);
        }
        if(homeTactics.getTackling() == "reckless" && referee.getCharacter() == "aggresive"){
            defenseHomeValue -= defenseHomeValue % (referee.getLoyality() + 5);
        }
        return defenseHomeValue;
    }

    private Long countDefense(Long defenseHomeValue, RefereeDto referee, TacticsDto homeTactics, TacticsDto guestTactics){
        if(guestTactics.getGameStyle() == "Counter attack" && homeTactics.getCustody() == "Person check"){
            defenseHomeValue -= 2;
        }
        if(guestTactics.getGameStyle() == "Counter attack" && homeTactics.getCustody() == "Zone check"){
            defenseHomeValue += 1;
        }
        if(guestTactics.getGameStyle() == "Long balls" && homeTactics.getCustody() == "Person check"){
            defenseHomeValue -= 2;
        }
        if(guestTactics.getGameStyle() == "Long balls" && homeTactics.getCustody() == "Zone check"){
            defenseHomeValue += 2;
        }
        if(guestTactics.getGameStyle() == "Passing game" && homeTactics.getCustody() == "Person check"){
            defenseHomeValue += 2;
        }
        if(guestTactics.getGameStyle() == "Passing game" && homeTactics.getCustody() == "Zone check"){
            defenseHomeValue -= 2;
        }
        if(guestTactics.getGameStyle() == "Wind play" && homeTactics.getCustody() == "Person check"){
            defenseHomeValue += 1;
        }
        if(guestTactics.getGameStyle() == "Wind play" && homeTactics.getCustody() == "Zone check"){
            defenseHomeValue -= 1;
        }
        if(guestTactics.getGameStyle() == "Shots on sight" && homeTactics.getCustody() == "Person check"){
            defenseHomeValue += 1;
        }
        if(guestTactics.getGameStyle() == "Shots on sight" && homeTactics.getCustody() == "Zone check") {
            defenseHomeValue -= 2;
        }
        return defenseHomeValue;
    }

    public Long tacticsMDA(LineUpDto lineUp,TacticsDto homeTactics, TacticsDto guestTactics, List<PlayerDto> homePlayers,RefereeDto referee){
        Long attackHomeValue = 0L, midfieldHomeValue = 0L,
                defenseHomeValue = 0L,attackMoraleHomeValue = 0L,
                midfieldMoraleHomeValue = 0L,defenseMoraleHomeValue = 0L, attackHealthHomeValue = 0L,
                midfieldHealthHomeValue = 0L, defenseHealthHomeValue = 0L;
        for (PlayerDto player : homePlayers) {
            if (player.getPosition() == "forward") {
                attackHomeValue += player.getOverall();
                attackMoraleHomeValue += player.getMorale();
                attackHealthHomeValue += player.getHealth();
            }
            if (player.getPosition() == "midlefielder") {
                midfieldHomeValue += player.getOverall();
                midfieldMoraleHomeValue += player.getMorale();
                midfieldHealthHomeValue += player.getHealth();
            }
            if (player.getPosition() == "defender" && (player.getType() == "LB" || player.getType() == "RB")) {
                attackHomeValue += player.getOverall();
                attackMoraleHomeValue += player.getMorale();
                attackHealthHomeValue += player.getHealth();
                defenseHomeValue += player.getOverall();
                defenseMoraleHomeValue += player.getMorale();
                defenseHealthHomeValue += player.getHealth();
            }
            if (player.getPosition() == "defender" && (player.getType() == "CB")) {
                defenseHomeValue += player.getOverall();
                defenseMoraleHomeValue += player.getMorale();
                defenseHealthHomeValue += player.getHealth();
            }
            if (player.getPosition() == "goalkeaper") {
                defenseHomeValue += player.getOverall();
                defenseMoraleHomeValue += player.getMorale();
                defenseHealthHomeValue += player.getHealth();
            }
        }

        if(lineUp.getSchema() == "4-3-3") {
            attackHomeValue /= 6;
            midfieldHomeValue /= 6;
            defenseHomeValue /= 8;
            attackHealthHomeValue /= 6;
            attackMoraleHomeValue /= 6;
            midfieldMoraleHomeValue /= 6;
            midfieldHealthHomeValue /= 6;
            defenseMoraleHomeValue /= 8;
            defenseHealthHomeValue /= 8;
        }
        if(lineUp.getSchema() == "4-4-2") {
            attackHomeValue /= 4;
            midfieldHomeValue /= 6;
            defenseHomeValue /= 9;
            attackHealthHomeValue /= 4;
            attackMoraleHomeValue /= 4;
            midfieldMoraleHomeValue /= 6;
            midfieldHealthHomeValue /= 6;
            defenseMoraleHomeValue /= 9;
            defenseHealthHomeValue /= 9;
        }
        if(lineUp.getSchema() == "3-4-3") {
            attackHomeValue /= 5;
            midfieldHomeValue /= 7;
            defenseHomeValue /= 8;
            attackHealthHomeValue /= 5;
            attackMoraleHomeValue /= 5;
            midfieldMoraleHomeValue /= 7;
            midfieldHealthHomeValue /= 7;
            defenseMoraleHomeValue /= 8;
            defenseHealthHomeValue /= 8;
        }
        if(lineUp.getSchema() == "4-2-4") {
            attackHomeValue /= 6;
            midfieldHomeValue /= 6;
            defenseHomeValue /= 7;
            attackHealthHomeValue /= 6;
            attackMoraleHomeValue /= 6;
            midfieldMoraleHomeValue /= 6;
            midfieldHealthHomeValue /= 6;
            defenseMoraleHomeValue /= 7;
            defenseHealthHomeValue /= 7;
        }
        attackHomeValue = (attackHomeValue + homeTactics.getGamePace()) / 2;
        defenseHomeValue = (midfieldHomeValue + homeTactics.getGamePace()) / 2;
        midfieldHomeValue = (midfieldHomeValue + homeTactics.getPressing()) / 2;
        defenseHomeValue = countDefenseTackling(defenseHomeValue, referee, homeTactics);
        countDefense(defenseHomeValue,referee,homeTactics,guestTactics);
        return (attackHomeValue + attackHealthHomeValue + attackMoraleHomeValue + defenseHomeValue +
                defenseHealthHomeValue + defenseMoraleHomeValue + midfieldHomeValue + midfieldHealthHomeValue +
                midfieldMoraleHomeValue) / 9;
    }

    private long countYellowCards(TacticsDto homeTactics,TacticsDto guestTactics,RefereeDto referee){
        if(!homeTactics.getOffsideTrap() & homeTactics.getCustody() == "Person check" &
                (homeTactics.getGamePace() < guestTactics.getGamePace())){
            return (100 - referee.getLoyality())/10;
        }
        else if(!homeTactics.getOffsideTrap() & homeTactics.getCustody() == "Person check" &
                (homeTactics.getGamePace() > guestTactics.getGamePace())){
            return (100 - referee.getLoyality())/10 + 1 - (homeTactics.getGamePace() - guestTactics.getGamePace());
        }
        else if(homeTactics.getOffsideTrap() & homeTactics.getCustody() == "Person check" &
                (homeTactics.getGamePace() < guestTactics.getGamePace())){
            return (100 - referee.getLoyality())/10 - 1;
        }
        else if(homeTactics.getOffsideTrap() & homeTactics.getCustody() == "Person check" &
                (homeTactics.getGamePace() > guestTactics.getGamePace())){
            return (100 - referee.getLoyality())/10 - (homeTactics.getGamePace() - guestTactics.getGamePace());
        }
        else if(!homeTactics.getOffsideTrap() & homeTactics.getCustody() == "Zone check" &
                (homeTactics.getGamePace() < guestTactics.getGamePace())){
            return (100 - referee.getLoyality())/10 + 2;
        }
        else if(!homeTactics.getOffsideTrap() & homeTactics.getCustody() == "Zone check" &
                (homeTactics.getGamePace() > guestTactics.getGamePace())){
            return (100 - referee.getLoyality())/10 + 2- (homeTactics.getGamePace() - guestTactics.getGamePace());
        }
        else if(homeTactics.getOffsideTrap() & homeTactics.getCustody() == "Zone check" &
                (homeTactics.getGamePace() < guestTactics.getGamePace())){
            return (100 - referee.getLoyality())/10 - 2;
        }
        else if(homeTactics.getOffsideTrap() & homeTactics.getCustody() == "Zone check" &
                (homeTactics.getGamePace() > guestTactics.getGamePace())){
            return 0;
        }
        return 0;
    }

    private long countRedCards(TacticsDto homeTactics,RefereeDto referee, long yellowCards){
        long redCards = 0;
        if(homeTactics.getTackling() == "careful" && referee.getCharacter() == "careful"){
            redCards = 0;
        }
        if(homeTactics.getTackling() == "normal" && referee.getCharacter() == "careful"){
            redCards = 0;
        }
        if(homeTactics.getTackling() == "aggresive" && referee.getCharacter() == "careful"){
           redCards = yellowCards/10;
        }
        if(homeTactics.getTackling() == "reckless" && referee.getCharacter() == "aggresive"){
            redCards = yellowCards-2;
        }
        if(homeTactics.getTackling() == "careful" && referee.getCharacter() == "normal"){
            redCards = 0;
        }
        if(homeTactics.getTackling() == "normal" && referee.getCharacter() == "normal"){
            redCards = yellowCards/10;
        }
        if(homeTactics.getTackling() == "aggresive" && referee.getCharacter() == "normal"){
            redCards = yellowCards/3;
        }

        if(homeTactics.getTackling() == "careful" && referee.getCharacter() == "aggresive"){
            redCards = yellowCards/10;
        }
        if(homeTactics.getTackling() == "normal" && referee.getCharacter() == "aggresive"){
           redCards=yellowCards/4;
        }
        if(homeTactics.getTackling() == "aggresive" && referee.getCharacter() == "aggresive"){
            redCards=yellowCards-4;
        }
        if(redCards < 0)
            return 0;
        return redCards;
    }

    private void countGoals(List<PlayerDto> players, long goals,Random rand,MatchDto match){
        int scored = rand.nextInt((10 - 0) + 1) + 1;
        List<PlayerDto> forwards = new ArrayList<>();
        List<PlayerDto> midfielders = new ArrayList<>();
        List<PlayerDto> defenders = new ArrayList<>();
        for(PlayerDto player : players){
            if(player.getPosition().equals("forward")){
                forwards.add(player);
            }
            else if(player.getPosition().equals("middlefielder")){
                midfielders.add(player);
            }
            else if(player.getPosition().equals("defender")){
                defenders.add(player);
            }
        }
        for(int i = 0; i < goals; i++) {
            if (scored <= 2) {
                int time = rand.nextInt((90 - 0) + 1) + 1;
                int number = rand.nextInt(((defenders.size()-1) - 0) + 1) + 0;
                MatchStatisticsDto statistics = new MatchStatisticsDto();
                statistics.setEvent("Goal");
                statistics.setTime((long) time);
                statistics.setMatch(match);
                Player player = playerRepository.findById(defenders.get(number).getId()).get();
                statistics.setPlayer(playerMapper.toDto(player));
                matchStatisticsRepository.save(matchStatisticsMapper.fromDto(statistics));
                int assist = rand.nextInt((10 - 0) + 1) + 1;
                if (assist <= 2) {
                    int num = rand.nextInt(((defenders.size()-1) - 0) + 1) + 0;
                    MatchStatisticsDto stat = new MatchStatisticsDto();
                    stat.setEvent("Assist");
                    stat.setTime((long) time);
                    stat.setMatch(match);
                    if(number == num){
                        stat.setPlayer(defenders.get(0));
                    }
                    else{
                        stat.setPlayer(defenders.get(num));
                    }
                    matchStatisticsRepository.save(matchStatisticsMapper.fromDto(stat));
                } else if (2 < assist && assist <= 7) {
                    int num = rand.nextInt(((midfielders.size()-1) - 0) + 1) + 0;
                    MatchStatisticsDto stat = new MatchStatisticsDto();
                    stat.setEvent("Assist");
                    stat.setTime((long) time);
                    stat.setMatch(match);
                    stat.setPlayer(midfielders.get(num));
                    matchStatisticsRepository.save(matchStatisticsMapper.fromDto(stat));
                }
                if (assist > 7) {
                    int num = rand.nextInt(((forwards.size() - 1) - 0) + 1) + 0;
                    MatchStatisticsDto stat = new MatchStatisticsDto();
                    stat.setEvent("Assist");
                    stat.setTime((long) time);
                    stat.setMatch(match);
                    stat.setPlayer(forwards.get(num));
                    matchStatisticsRepository.save(matchStatisticsMapper.fromDto(stat));
                }
            }
            if (2 < scored & scored <= 5) {
                int time = rand.nextInt((90 - 0) + 1) + 1;
                int number = rand.nextInt(((midfielders.size()-1) - 0) + 1) + 0;
                MatchStatisticsDto statistics = new MatchStatisticsDto();
                statistics.setEvent("Goal");
                statistics.setTime((long) time);
                statistics.setMatch(match);
                PlayerDto player = midfielders.get(number);
                statistics.setPlayer(player);
                matchStatisticsRepository.save(matchStatisticsMapper.fromDto(statistics));
                int assist = rand.nextInt((10 - 0) + 1) + 1;
                if (assist <= 2) {
                    int num = rand.nextInt(((defenders.size()-1) - 0) + 1) + 0;
                    MatchStatisticsDto stat = new MatchStatisticsDto();
                    stat.setEvent("Assist");
                    stat.setTime((long) time);
                    stat.setMatch(match);
                    stat.setPlayer(defenders.get(num));
                    matchStatisticsRepository.save(matchStatisticsMapper.fromDto(stat));
                } else if (2 < assist && assist <= 7) {
                    int num = rand.nextInt(((midfielders.size()-1) - 0) + 1) + 0;
                    MatchStatisticsDto stat = new MatchStatisticsDto();
                    stat.setEvent("Assist");
                    stat.setTime((long) time);
                    stat.setMatch(match);
                    if(number == num){
                        stat.setPlayer(midfielders.get(0));
                    }
                    else{
                        stat.setPlayer(midfielders.get(num));
                    }
                    matchStatisticsRepository.save(matchStatisticsMapper.fromDto(stat));
                }
                if (assist > 7) {
                    int num = rand.nextInt(((forwards.size()-1) - 0) + 1) + 0;
                    MatchStatisticsDto stat = new MatchStatisticsDto();
                    stat.setEvent("Assist");
                    stat.setTime((long) time);
                    stat.setMatch(match);
                    stat.setPlayer(forwards.get(num));
                    matchStatisticsRepository.save(matchStatisticsMapper.fromDto(stat));
                }
            }
            if (scored > 5) {
                int time = rand.nextInt((90 - 0) + 1) + 1;
                int number = rand.nextInt(((forwards.size()-1) - 0) + 1) + 0;
                MatchStatisticsDto statistics = new MatchStatisticsDto();
                statistics.setEvent("Goal");
                statistics.setTime((long) time);
                statistics.setMatch(match);
                PlayerDto player = forwards.get(number);
                statistics.setPlayer(player);
                matchStatisticsRepository.save(matchStatisticsMapper.fromDto(statistics));
                int assist = rand.nextInt((10 - 0) + 1) + 1;
                if (assist <= 2) {
                    int num = rand.nextInt(((defenders.size()-1) - 0) + 1) + 0;
                    MatchStatisticsDto stat = new MatchStatisticsDto();
                    stat.setEvent("Assist");
                    stat.setTime((long) time);
                    stat.setMatch(match);
                    stat.setPlayer(defenders.get(num));
                    matchStatisticsRepository.save(matchStatisticsMapper.fromDto(stat));
                } else if (2 < assist && assist <= 7) {
                    int num = rand.nextInt(((midfielders.size()-1) - 0) + 1) + 0;
                    MatchStatisticsDto stat = new MatchStatisticsDto();
                    stat.setEvent("Assist");
                    stat.setTime((long) time);
                    stat.setMatch(match);
                    stat.setPlayer(midfielders.get(num));
                    matchStatisticsRepository.save(matchStatisticsMapper.fromDto(stat));
                }
                if (assist > 7) {
                    int num = rand.nextInt(((forwards.size()-1) - 0) + 1) + 0;
                    MatchStatisticsDto stat = new MatchStatisticsDto();
                    stat.setEvent("Assist");
                    stat.setTime((long) time);
                    stat.setMatch(match);
                    if(number == num){
                        stat.setPlayer(forwards.get(0));
                    }
                    else{
                        stat.setPlayer(forwards.get(num));
                    }
                    matchStatisticsRepository.save(matchStatisticsMapper.fromDto(stat));
                }
            }
        }
    }

    private void trainingPlayers(Long id){
        Random rand = new Random();
        Squad squad = squadRepository.findByTeamId(id);
        List<Player> players = playerRepository.findAllBySquadId(squad.getId());
        for(Player player : players){
            if(player.getOnTraining()){
                if(player.getProgress() == 2){
                    int value = rand.nextInt((10 - 0) + 1) + 1;
                    if(value > 9) {
                        player.setOverall(player.getOverall() + 1);
                    }
                }
                if(player.getProgress() == 3){
                    int value = rand.nextInt((10 - 0) + 1) + 1;
                    if(value > 7) {
                        player.setOverall(player.getOverall() + 1);
                    }
                }
                if(player.getProgress() == 4){
                    int value = rand.nextInt((10 - 0) + 1) + 1;
                    if(value > 4) {
                        player.setOverall(player.getOverall() + 1);
                    }
                }
                if(player.getProgress() == 5){
                    int value = rand.nextInt((10 - 0) + 1) + 1;
                    if(value > 2) {
                        player.setOverall(player.getOverall() + 1);
                    }
                }
                player.setOnTraining(false);
                playerService.update(playerMapper.toDto(player));
            }
        }
    }

    private void setSubtitutesValues(Long id){
        Squad squad = squadRepository.findByTeamId(id);
        List<Player> players = playerRepository.findAllBySquadId(squad.getId());
        for(Player player : players){
            if(!player.getInLineUp()){
                player.setHealth(100L);
                player.setMorale(player.getMorale() - 6);
                player.setInLineUp(false);
                playerService.update(playerMapper.toDto(player));
            }
        }
    }

    public void fixtureMatchesGenerateResults(Long id){
        Fixture fixture = fixtureRepository.findById(id).get();
        List<MatchDto> matches = matchMapper.listToDto(matchRepository.findByFixtureId(id));
        for(MatchDto match : matches) {
            RefereeDto referee = match.getReferee();
            TeamDto homeTeam = match.getHomeTeam();
            TeamDto guestTeam = match.getGuestTeam();
            TacticsDto homeTactics = tacticsMapper.toDto(tacticsRepository.findByTeamTacticsId(homeTeam.getId()));
            TacticsDto guestTactics = tacticsMapper.toDto(tacticsRepository.findByTeamTacticsId(guestTeam.getId()));
            LineUpDto homeLineUp = lineUpMapper.toDto(lineUpRepository.findByTeamLineUpId(homeTeam.getId()));
            LineUpDto guestLineUp = lineUpMapper.toDto(lineUpRepository.findByTeamLineUpId(guestTeam.getId()));
            List<PlayerDto> homePlayers = playerMapper.listToDto(playerRepository.findByLineUpIdAndInLineUp
                    (homeLineUp.getId(), true));
            List<PlayerDto> guestPlayers = playerMapper.listToDto(playerRepository.findByLineUpIdAndInLineUp
                    (guestLineUp.getId(), true));
            Long homeResults = 0L, guestResults = 0L;
            homeResults = tacticsMDA(homeLineUp, homeTactics, guestTactics, homePlayers, referee);
            guestResults = tacticsMDA(guestLineUp, guestTactics, homeTactics, guestPlayers, referee);
            Random rand = new Random();
            FinancesDto homeTeamFinances = financesMapper.toDto(financesRepository.findByTeamFinancesId(homeTeam.getId()));
            FinancesDto guestTeamFinances = financesMapper.toDto(financesRepository.findByTeamFinancesId(guestTeam.getId()));
            long homeYellow = countYellowCards(homeTactics, guestTactics, referee);
            if (homeYellow < 0) {
                homeYellow = 0;
            }
            long guestYellow = countYellowCards(guestTactics, homeTactics, referee);
            if (guestYellow < 0) {
                guestYellow = 0;
            }
            long homeRed = countRedCards(homeTactics, referee, homeYellow);
            long guestRed = countRedCards(guestTactics, referee, guestYellow);
            if (homeRed > guestRed) {
                homeResults -= 1;
            } else if (guestRed > homeRed) {
                guestResults -= 1;
            }
            if (homeResults > guestResults) {
                int homeScored = rand.nextInt((4 - 1) + 1) + 1;
                int guestScored = rand.nextInt((homeScored - 0) + 1) + 0;
                match.setHomeScored((long) homeScored);
                match.setGuestScored((long) guestScored);
                match.setYellow_cards(homeYellow + guestYellow);
                match.setRed_cards(homeRed + guestRed);
                countGoals(homePlayers, homeScored, rand, match);
                countGoals(guestPlayers, guestScored, rand, match);
                homeTeam.setPoints(homeTeam.getPoints() + 3);
                homeTeam.setWins(homeTeam.getWins() + 1);
                homeTeam.setScored(homeTeam.getScored() + homeScored);
                homeTeam.setAgainst(homeTeam.getAgainst() + guestScored);
                guestTeam.setPoints(guestTeam.getPoints() + 0);
                guestTeam.setLoses(guestTeam.getLoses() + 1);
                guestTeam.setScored(guestTeam.getScored() + guestScored);
                guestTeam.setAgainst(guestTeam.getAgainst() + homeScored);
                homeTeamFinances.setAmount(homeTeamFinances.getAmount() + homeTeamFinances.getFixturePrice() +
                        homeTeamFinances.getWinPrice());
                guestTeamFinances.setAmount(guestTeamFinances.getAmount() + guestTeamFinances.getFixturePrice() +
                        guestTeamFinances.getLoosePrice());
                countGoals(homePlayers, homeScored, rand, match);
                countGoals(guestPlayers, guestScored, rand, match);
                setSubtitutesValues(homeTeam.getId());
                setSubtitutesValues(guestTeam.getId());
                for (PlayerDto player : homePlayers) {
                    player.setHealth(player.getHealth() - 5);
                    player.setMorale(96L);
                    player.setInLineUp(false);
                    playerService.update(player);
                }
                for (PlayerDto player : guestPlayers) {
                    player.setHealth(player.getHealth() - 7);
                    player.setMorale(92L);
                    player.setInLineUp(false);
                    playerService.update(player);
                }
                trainingPlayers(homeTeam.getId());
                trainingPlayers(guestTeam.getId());
                int posession = rand.nextInt((90 - 0) + 1) + 0;
                match.setHome_posession((long) posession);
                match.setGuest_posession((long) (100 - posession));
                match.setHomeTeam(homeTeam);
                match.setGuestTeam(guestTeam);
                teamRepository.save(teamMapper.fromDto(homeTeam));
                teamRepository.save(teamMapper.fromDto(guestTeam));
                financesRepository.save(financesMapper.fromDto(homeTeamFinances));
                financesRepository.save(financesMapper.fromDto(guestTeamFinances));
                matchRepository.save(matchMapper.fromDto(match));
            } else if (homeResults == guestResults) {
                int homeScored = rand.nextInt((3 - 0) + 1) + 0;
                int guestScored = homeScored;
                match.setHomeScored((long) homeScored);
                match.setGuestScored((long) guestScored);
                match.setYellow_cards(homeYellow + guestYellow);
                match.setRed_cards(homeRed + guestRed);
                homeTeam.setPoints(homeTeam.getPoints() + 1);
                homeTeam.setDraws(homeTeam.getDraws() + 1);
                homeTeam.setScored(homeTeam.getScored() + homeScored);
                homeTeam.setAgainst(homeTeam.getAgainst() + guestScored);
                guestTeam.setPoints(guestTeam.getPoints() + 1);
                guestTeam.setDraws(guestTeam.getDraws() + 1);
                guestTeam.setScored(guestTeam.getScored() + guestScored);
                guestTeam.setAgainst(guestTeam.getAgainst() + homeScored);
                homeTeamFinances.setAmount(homeTeamFinances.getAmount() + homeTeamFinances.getFixturePrice() +
                        homeTeamFinances.getDrawPrice());
                guestTeamFinances.setAmount(guestTeamFinances.getAmount() + guestTeamFinances.getFixturePrice() +
                        guestTeamFinances.getDrawPrice());
                countGoals(homePlayers, homeScored, rand, match);
                countGoals(guestPlayers, guestScored, rand, match);
                setSubtitutesValues(homeTeam.getId());
                setSubtitutesValues(guestTeam.getId());
                for (PlayerDto player : homePlayers) {
                    player.setHealth(player.getHealth() - 6);
                    player.setMorale(92L);
                    player.setInLineUp(false);
                    playerService.update(player);
                }
                for (PlayerDto player : guestPlayers) {
                    player.setHealth(player.getHealth() - 6);
                    player.setMorale(94L);
                    player.setInLineUp(false);
                    playerService.update(player);
                }
                trainingPlayers(homeTeam.getId());
                trainingPlayers(guestTeam.getId());
                int posession = rand.nextInt((90 - 0) + 1) + 0;
                match.setHome_posession((long) posession);
                match.setGuest_posession((long) (100 - posession));
                match.setHomeTeam(homeTeam);
                match.setGuestTeam(guestTeam);
                teamRepository.save(teamMapper.fromDto(homeTeam));
                teamRepository.save(teamMapper.fromDto(guestTeam));
                matchRepository.save(matchMapper.fromDto(match));
                financesRepository.save(financesMapper.fromDto(homeTeamFinances));
                financesRepository.save(financesMapper.fromDto(guestTeamFinances));
            } else {
                int guestScored = rand.nextInt((5 - 1) + 1) + 1;
                int homeScored = rand.nextInt(((guestScored - 1) - 0) + 1) + 0;
                match.setHomeScored((long) homeScored);
                match.setGuestScored((long) guestScored);
                match.setYellow_cards(homeYellow + guestYellow);
                match.setRed_cards(homeRed + guestRed);
                homeTeam.setLoses(homeTeam.getLoses() + 1);
                homeTeam.setScored(homeTeam.getScored() + homeScored);
                homeTeam.setAgainst(homeTeam.getAgainst() + guestScored);
                guestTeam.setPoints(guestTeam.getPoints() + 3);
                guestTeam.setWins(guestTeam.getWins() + 1);
                guestTeam.setScored(guestTeam.getScored() + guestScored);
                guestTeam.setAgainst(guestTeam.getAgainst() + homeScored);
                homeTeamFinances.setAmount(homeTeamFinances.getAmount() + homeTeamFinances.getFixturePrice() +
                        homeTeamFinances.getLoosePrice());
                guestTeamFinances.setAmount(guestTeamFinances.getAmount() + guestTeamFinances.getFixturePrice() +
                        guestTeamFinances.getWinPrice());
                countGoals(homePlayers, homeScored, rand, match);
                countGoals(guestPlayers, guestScored, rand, match);
                setSubtitutesValues(homeTeam.getId());
                setSubtitutesValues(guestTeam.getId());
                for (PlayerDto player : homePlayers) {
                    player.setHealth(player.getHealth() - 7);
                    player.setMorale(88L);
                    player.setInLineUp(false);
                    playerService.update(player);
                }
                for (PlayerDto player : guestPlayers) {
                    player.setHealth(player.getHealth() - 5);
                    player.setMorale(99L);
                    player.setInLineUp(false);
                    playerService.update(player);
                }
                trainingPlayers(homeTeam.getId());
                trainingPlayers(guestTeam.getId());
                int posession = rand.nextInt((90 - 0) + 1) + 0;
                match.setHome_posession((long) posession);
                match.setGuest_posession((long) (100 - posession));
                match.setHomeTeam(homeTeam);
                match.setGuestTeam(guestTeam);
                teamRepository.save(teamMapper.fromDto(homeTeam));
                teamRepository.save(teamMapper.fromDto(guestTeam));
                financesRepository.save(financesMapper.fromDto(homeTeamFinances));
                financesRepository.save(financesMapper.fromDto(guestTeamFinances));
                matchRepository.save(matchMapper.fromDto(match));
            }
            League league = leagueRepository.findById(1l).get();
            league.setCurrentFixture(fixture.getNumber() + 1);
        }
    }
}


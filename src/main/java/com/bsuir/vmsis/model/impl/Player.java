package com.bsuir.vmsis.model.impl;


import com.bsuir.vmsis.model.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
@Data
@Entity(name = "player")
@Table(name = "player")
public class Player extends BaseEntity implements Serializable {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birthday", updatable = false)
    private LocalDate birthday;

    @Column(name = "position")
    private String position;

    @Column(name = "number")
    private Long number;

    @Column(name = "player_image")
    private String playerImage;

    @Column(name = "overall")
    private Long overall;

    @Column(name = "international_ranting")
    private Long internationalRanting;

    @Column(name = "in_line_up")
    private Boolean inLineUp;

    @Column(name = "on_transfer")
    private Boolean onTransfer;

    @Column(name = "on_training")
    private Boolean onTraining;

    @Column(name = "progress")
    private Long progress;

    @Column(name = "morale")
    private Long morale;

    @Column(name = "health")
    private Long health;

    @Column(name = "type")
    private String type;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn (name="squad_id",referencedColumnName = "id")
    private Squad squad;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn (name="line_up_id",referencedColumnName = "id")
    private LineUp lineUp;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn (name="country_id",referencedColumnName = "id")
    private Country playerCountry;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn (name="price_id",referencedColumnName = "id")
    private PlayerPrice price;

    @OneToOne(mappedBy = "playerDefense", cascade = CascadeType.ALL)
    private Defense defense;

    @OneToOne(mappedBy = "playerDribbling", cascade = CascadeType.ALL)
    private Dribbling dribbling;

    @OneToOne(mappedBy = "playerPace", cascade = CascadeType.ALL)
    private Pace pace;

    @OneToOne(mappedBy = "playerShooting", cascade = CascadeType.ALL)
    private Shooting shooting;

    @OneToOne(mappedBy = "playerPassing", cascade = CascadeType.ALL)
    private Passing passing;

    @OneToOne(mappedBy = "playerPhysical", cascade = CascadeType.ALL)
    private Physical physical;

    @OneToOne(mappedBy = "playerHealth", cascade = CascadeType.ALL)
    private Health playerHealth;

    @OneToOne(mappedBy = "playerMorale", cascade = CascadeType.ALL)
    private Morale playerMorale;

    @OneToMany(mappedBy = "playerStatistics", cascade = CascadeType.ALL)
    private List<MatchStatistics> matchStatistics;

    public Defense getDefense() {
        return defense;
    }

    public void setDefense(Defense defense) {
        this.defense = defense;
    }

    public Dribbling getDribbling() {
        return dribbling;
    }

    public void setDribbling(Dribbling dribbling) {
        this.dribbling = dribbling;
    }

    public Pace getPace() {
        return pace;
    }

    public void setPace(Pace pace) {
        this.pace = pace;
    }

    public Shooting getShooting() {
        return shooting;
    }

    public void setShooting(Shooting shooting) {
        this.shooting = shooting;
    }

    public Passing getPassing() {
        return passing;
    }

    public void setPassing(Passing passing) {
        this.passing = passing;
    }

    public Physical getPhysical() {
        return physical;
    }

    public void setPhysical(Physical physical) {
        this.physical = physical;
    }

    public Health getPlayerHealth() {
        return playerHealth;
    }

    public void setPlayerHealth(Health playerHealth) {
        this.playerHealth = playerHealth;
    }

    public Morale getPlayerMorale() {
        return playerMorale;
    }

    public void setPlayerMorale(Morale playerMorale) {
        this.playerMorale = playerMorale;
    }

    public List<MatchStatistics> getMatchStatistics() {
        return matchStatistics;
    }

    public void setMatchStatistics(List<MatchStatistics> matchStatistics) {
        this.matchStatistics = matchStatistics;
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

    public Boolean getInLineUp() {
        return inLineUp;
    }

    public void setInLineUp(Boolean inLineUp) {
        this.inLineUp = inLineUp;
    }

    public Squad getSquad() {
        return squad;
    }

    public void setSquad(Squad squad) {
        this.squad = squad;
    }

    public LineUp getLineUp() {
        return lineUp;
    }

    public void setLineUp(LineUp lineUp) {
        this.lineUp = lineUp;
    }

    public Country getPlayerCountry() {
        return playerCountry;
    }

    public void setPlayerCountry(Country playerCountry) {
        this.playerCountry = playerCountry;
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

    public Long getProgress() {
        return progress;
    }

    public void setProgress(Long progress) {
        this.progress = progress;
    }

    public PlayerPrice getPrice() {
        return price;
    }

    public void setPrice(PlayerPrice price) {
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

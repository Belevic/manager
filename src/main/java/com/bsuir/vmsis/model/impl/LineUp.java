package com.bsuir.vmsis.model.impl;

import com.bsuir.vmsis.model.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity(name = "line_up")
@Table(name = "line_up")
public class LineUp extends BaseEntity implements Serializable {

    @Column(name = "schema")
    private String schema;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name="team_id",referencedColumnName = "id")
    private Team teamLineUp;

    @OneToMany(mappedBy = "lineUp", cascade = CascadeType.ALL)
    private List<Player> players;

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public Team getTeamLineUp() {
        return teamLineUp;
    }

    public void setTeamLineUp(Team teamLineUp) {
        this.teamLineUp = teamLineUp;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}

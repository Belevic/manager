package com.bsuir.vmsis.model.impl;


import com.bsuir.vmsis.model.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity(name = "squad")
@Table(name = "squad")
public class Squad extends BaseEntity implements Serializable {

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn (name="team_id",referencedColumnName = "id")
    private Team team;

    @OneToMany(mappedBy = "squad", cascade = CascadeType.ALL)
    private List<Player> players;
}

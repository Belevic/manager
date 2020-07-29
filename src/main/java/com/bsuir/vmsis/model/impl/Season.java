package com.bsuir.vmsis.model.impl;


import com.bsuir.vmsis.model.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity(name = "season")
@Table(name = "season")
public class Season extends BaseEntity implements Serializable {

    @Column(name = "year", updatable = false)
    private LocalDate year;
/*
    @OneToMany(mappedBy = "season", cascade = CascadeType.ALL)
    private List<PlayerStatistics> playerStatistics;
*/

    @OneToMany(mappedBy = "seasonFixture",cascade = CascadeType.ALL)
    private List<Fixture> fixtures;
}

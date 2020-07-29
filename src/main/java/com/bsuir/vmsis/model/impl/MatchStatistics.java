package com.bsuir.vmsis.model.impl;

import com.bsuir.vmsis.model.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "match_statistics")
@Table(name = "match_statistics")
public class MatchStatistics extends BaseEntity implements Serializable {

    @Column(name = "time")
    private Long time;

    @Column(name = "event")
    private String event;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn (name="player_id",referencedColumnName = "id")
    private Player playerStatistics;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @Cascade(org.hibernate.annotations.CascadeType.REPLICATE)
    @JoinColumn (name="match_id",referencedColumnName = "id")
    private Match matchStatistics;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Match getMatchStatistics() {
        return matchStatistics;
    }

    public void setMatchStatistics(Match matchStatistics) {
        this.matchStatistics = matchStatistics;
    }
}

package com.bsuir.vmsis.model.impl;

import com.bsuir.vmsis.model.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity(name = "transfer")
@Table(name = "transfer")
public class Transfer extends BaseEntity implements Serializable {

    @Column(name = "price")
    private Long price;

    @Column(name = "date", updatable = false)
    private LocalDate date;;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
    @JoinColumn(name="from_id",referencedColumnName = "id")
    private Team fromTeam;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
    @JoinColumn(name="to_id",referencedColumnName = "id")
    private Team toTeam;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @Cascade(org.hibernate.annotations.CascadeType.REPLICATE)
    @JoinColumn(name="player_id",referencedColumnName = "id")
    private Player playerTransfer;

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Team getFromTeam() {
        return fromTeam;
    }

    public void setFromTeam(Team fromTeam) {
        this.fromTeam = fromTeam;
    }

    public Team getToTeam() {
        return toTeam;
    }

    public void setToTeam(Team toTeam) {
        this.toTeam = toTeam;
    }

    public Player getPlayerTransfer() {
        return playerTransfer;
    }

    public void setPlayerTransfer(Player playerTransfer) {
        this.playerTransfer = playerTransfer;
    }
}

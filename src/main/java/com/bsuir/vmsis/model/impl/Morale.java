package com.bsuir.vmsis.model.impl;

import com.bsuir.vmsis.model.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "morale")
@Table(name = "morale")
public class Morale extends BaseEntity implements Serializable {

    @Column(name = "leadership")
    private Long leadership;

    @Column(name = "stressfull")
    private Long stressfull;

    @Column(name = "overall")
    private Long overall;

    @Column(name = "rampage")
    private Long rampage;

    @Column(name = "character")
    private String character;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @Cascade(org.hibernate.annotations.CascadeType.REPLICATE)
    @JoinColumn (name="player_id",referencedColumnName = "id")
    private Player playerMorale;

    public Long getLeadership() {
        return leadership;
    }

    public void setLeadership(Long leadership) {
        this.leadership = leadership;
    }

    public Long getStressfull() {
        return stressfull;
    }

    public void setStressfull(Long stressfull) {
        this.stressfull = stressfull;
    }

    public Long getOverall() {
        return overall;
    }

    public void setOverall(Long overall) {
        this.overall = overall;
    }

    public Long getRampage() {
        return rampage;
    }

    public void setRampage(Long rampage) {
        this.rampage = rampage;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public Player getPlayerMorale() {
        return playerMorale;
    }

    public void setPlayerMorale(Player playerMorale) {
        this.playerMorale = playerMorale;
    }
}

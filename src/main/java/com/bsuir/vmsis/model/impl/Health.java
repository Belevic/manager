package com.bsuir.vmsis.model.impl;

import com.bsuir.vmsis.model.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Entity(name = "health")
@Table(name = "health")
public class Health extends BaseEntity implements Serializable {

    @Column(name = "stamina_lessing")
    private Long staminaLessing;

    @Column(name = "injury_resistance")
    private Long injuryResistance;

    @Column(name = "recovery")
    private Long recovery;

    @Column(name = "overall")
    private Long overall;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @Cascade(org.hibernate.annotations.CascadeType.REPLICATE)
    @JoinColumn (name="player_id",referencedColumnName = "id")
    private Player playerHealth;

    public Long getStaminaLessing() {
        return staminaLessing;
    }

    public void setStaminaLessing(Long staminaLessing) {
        this.staminaLessing = staminaLessing;
    }

    public Long getInjuryResistance() {
        return injuryResistance;
    }

    public void setInjuryResistance(Long injuryResistance) {
        this.injuryResistance = injuryResistance;
    }

    public Long getRecovery() {
        return recovery;
    }

    public void setRecovery(Long recovery) {
        this.recovery = recovery;
    }

    public Long getOverall() {
        return overall;
    }

    public void setOverall(Long overall) {
        this.overall = overall;
    }

    public Player getPlayerHealth() {
        return playerHealth;
    }

    public void setPlayerHealth(Player playerHealth) {
        this.playerHealth = playerHealth;
    }
}

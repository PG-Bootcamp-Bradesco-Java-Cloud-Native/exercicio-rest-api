package pg.bootcamp_java_cloud_native.exercicio_rest_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
public class Run {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String playerName;
    @NotNull
    private Short score;
    private Date completedAt;

    protected Run() {
    }

    public Run(String playerName, Short score) {
        this.playerName = playerName;
        this.score = score;
        this.completedAt = new Date();
    }

    public int getId() {
        return id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Short getScore() {
        return score;
    }

    public Date getCompletedAt() {
        return completedAt;
    }
}

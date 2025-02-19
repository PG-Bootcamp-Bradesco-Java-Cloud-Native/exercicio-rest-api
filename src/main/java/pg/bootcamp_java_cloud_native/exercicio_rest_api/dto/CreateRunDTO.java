package pg.bootcamp_java_cloud_native.exercicio_rest_api.dto;

import jakarta.validation.constraints.NotNull;

public class CreateRunDTO {
    @NotNull
    public final String playerName;
    @NotNull
    public final Short score;

    public CreateRunDTO(String playerName, Short score) {
        this.playerName = playerName;
        this.score = score;
    }
}

package pg.bootcamp_java_cloud_native.exercicio_rest_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pg.bootcamp_java_cloud_native.exercicio_rest_api.dto.CreateRunDTO;
import pg.bootcamp_java_cloud_native.exercicio_rest_api.model.Run;
import pg.bootcamp_java_cloud_native.exercicio_rest_api.repository.RunRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/runs")
public class RunController {
    @Autowired
    RunRepository runRepository;

    @PostMapping
    public ResponseEntity<Run> create(@RequestBody CreateRunDTO newRunDTO) {
        Run newRun = new Run(newRunDTO.playerName, newRunDTO.score);
        runRepository.save(newRun);
        return ResponseEntity.created(
                UriComponentsBuilder.fromUriString("/runs/{id}")
                        .buildAndExpand(newRun.getId()).toUri()
        ).body(newRun);
    }

    @GetMapping
    public ResponseEntity<List<Run>> getDailyTop5() {
        return ResponseEntity.ok(runRepository.findDailyTop5(new Date()));
    }

    @GetMapping("/high-score")
    public ResponseEntity<Run> getHighScore() {
        Optional<Run> highScoreRun = runRepository.findHighScore();
        return highScoreRun.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }
}

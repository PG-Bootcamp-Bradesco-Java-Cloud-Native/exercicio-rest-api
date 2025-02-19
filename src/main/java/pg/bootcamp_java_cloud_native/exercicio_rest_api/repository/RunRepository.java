package pg.bootcamp_java_cloud_native.exercicio_rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pg.bootcamp_java_cloud_native.exercicio_rest_api.model.Run;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface RunRepository extends JpaRepository<Run, Integer> {
    @Query("SELECT r FROM Run r ORDER BY r.score DESC LIMIT 1")
    Optional<Run> findHighScore();

    @Query("SELECT r FROM Run r WHERE r.completedAt < ?1  ORDER BY r.score DESC LIMIT 5")
    List<Run> findDailyTop5(Date d);
}

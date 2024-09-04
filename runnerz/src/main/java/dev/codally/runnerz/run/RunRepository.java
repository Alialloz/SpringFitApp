package dev.codally.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {
    private List<Run> runs = new ArrayList<Run>();

    List<Run> findAll() {
        return runs;
    }

    Optional<Run> findById(Integer id) {
        return runs.stream()
                .filter(run -> run.id() == id)
                .findFirst();

    }

    void create(Run run) {
        runs.add(run);
    }

    @PostConstruct
    private void init() {
        runs.add(new Run(24,
                "Run 2",
                LocalDateTime.now(),
                LocalDateTime.now().plus(30, ChronoUnit.MINUTES),
                5,Location.INDOOR));

        runs.add(new Run(25, "Run 3", LocalDateTime.now(), LocalDateTime.now().plus(15, ChronoUnit.MINUTES), 10, Location.OUTDOOR));
        runs.add(new Run(26, "Run 4", LocalDateTime.now(), LocalDateTime.now().plus(45, ChronoUnit.MINUTES), 7, Location.OUTDOOR));
        runs.add(new Run(27, "Run 5", LocalDateTime.now(), LocalDateTime.now().plus(60, ChronoUnit.MINUTES), 8, Location.INDOOR));
        runs.add(new Run(28, "Run 6", LocalDateTime.now(), LocalDateTime.now().plus(30, ChronoUnit.MINUTES), 6, Location.OUTDOOR));

    }
}

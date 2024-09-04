package dev.codally.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

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


    void update(@RequestBody Run run, Integer id){
        Optional<Run> existingRun = findById(id);
        if(existingRun.isPresent()){
            runs.set(runs.indexOf(existingRun.get()), run);
        }
    }

    void delete(Integer id) {
//        Optional<Run> existingRun = findById(id);
//        if(existingRun.isPresent()){
//            runs.remove(existingRun.get());
//        }
        runs.removeIf(run -> run.id().equals(id));
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

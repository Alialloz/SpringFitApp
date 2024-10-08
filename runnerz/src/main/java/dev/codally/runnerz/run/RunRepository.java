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

    }
}

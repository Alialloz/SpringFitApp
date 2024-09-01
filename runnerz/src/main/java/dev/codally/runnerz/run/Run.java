package dev.codally.runnerz.run;

import java.time.LocalDateTime;

// Record est immuable, les getters setters et autres sont generees.
public record Run(
        Integer id,
        String title,
        LocalDateTime start,
        LocalDateTime end,
        Integer miles,
        Location location
) {}

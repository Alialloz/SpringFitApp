package dev.codally.runnerz.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

// Record est immuable, les getters setters et autres sont generees.
public record Run(
        Integer id,
        @NotEmpty String name,
        LocalDateTime startDate,
        LocalDateTime completedOnDate,
        @Positive
        Integer miles,
        Location location
) {
    public Run{
        if (!completedOnDate.isAfter(startDate)){
            throw new IllegalArgumentException("Start date must be after completed date");
        }
        if (!completedOnDate.isBefore(startDate)){
            throw new IllegalArgumentException("Start date must be before completed date");
        }
        // name not empty
        
    }

}

package com.example.poitl.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Goal {
    private Long id;
    private Long priority;
    private String name;

    public static List<Goal> getGoals() {
        return List.of(
                new Goal(1L, 1L, "Test1"),
                new Goal(2L, 1L, "Test2"),
                new Goal(3L, 2L, "Test3"),
                new Goal(4L, 3L, "Test4"),
                new Goal(5L, 3L, "Test5")
        );
    }
}

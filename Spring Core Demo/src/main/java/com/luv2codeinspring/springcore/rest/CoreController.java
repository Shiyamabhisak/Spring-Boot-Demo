package com.luv2codeinspring.springcore.rest;

import com.luv2codeinspring.springcore.common.Coach;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoreController {
    private Coach coach;


    public CoreController(Coach coach) {
        this.coach = coach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }

    @GetMapping("/dailyFortune")
    public String getDailyFortune() {
        return coach.getDailyFortune();
    }
}

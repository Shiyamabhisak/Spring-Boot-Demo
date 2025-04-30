package com.luv2codeinspring.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes !!!";
    }

    @Override
    public String getDailyFortune() {
        return "Today is your lucky day !!!";
    }
}

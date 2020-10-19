package com.practise.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	private FortuneService fortuneService;
	
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		super();
		this.fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practise your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}

package com.practise.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;
// dont kow per postconstruct and predestroy nahi chal raha isme, manually import bhi nhi ho rha


@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println(">> Tennis Coach: inside default constructor");
	}
//	@PostConstruct
//	public void doMyStartupStuff() {
//		System.out.println(">> TennisCoach: inside of doMyStartupStuff()");
//	}
	
//	@PreDestroy
//	public void doMyCleanupStuff() {
//		System.out.println(">> TennisCoach: inside of doMyStartupStuff()");
//	}
	
	
//	@Autowired
//	public TennisCoach(FortuneService theFortuneService) {
//		super();
//		this.fortuneService = theFortuneService;
//	}
	
//	@Autowired
//	public void setFortuneService(FortuneService theFortuneService) {
//		System.out.println(">> Tennis Coach: inside setFortuneService method");
//		this.fortuneService = theFortuneService;
//	}



	@Override
	public String getDailyWorkout() {
		return "Practise your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}

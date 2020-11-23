package com.practise.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addAc() {
		
		System.out.println(getClass() + ": Doing Stuff : Adding a membership account");
		
	}
	
public void goToSleep() {
		
		System.out.println(getClass() + ": I'm going to sleep now");
		
	}
}

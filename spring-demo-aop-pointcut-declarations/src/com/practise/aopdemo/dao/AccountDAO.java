package com.practise.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.practise.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account theAccount, boolean vipFlag) {
		
		System.out.println(getClass() + " : Doing my db work : Adding an account");		
	}
	
	public boolean doWork() {
		System.out.println(getClass() + " : dowork()");
		return false;
	}
}

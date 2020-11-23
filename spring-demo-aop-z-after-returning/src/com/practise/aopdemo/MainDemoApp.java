package com.practise.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.practise.aopdemo.dao.AccountDAO;
import com.practise.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
				
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
				
			
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
				
				
		MembershipDAO theMembershipDAO = 
				context.getBean("membershipDAO", MembershipDAO.class);
						
				
		Account myAccount = new Account();
		myAccount.setName("Anshul");
		myAccount.setLevel("Platinum");
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();
				
			
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
				
			
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();				
				
		context.close();
	}
}



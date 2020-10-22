package com.practise.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.practise.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context =
						new AnnotationConfigApplicationContext(DemoConfig.class);
								
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
								
		theAccountDAO.addAccount();
		
		System.out.println("\nCalling it again one more time\n");
							
		theAccountDAO.addAccount();
							
		context.close();
	}

}

package com.practise.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practise.hibernate.demo.entity.Course;
import com.practise.hibernate.demo.entity.Instructor;
import com.practise.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
	
		Session session = factory.getCurrentSession();
		
		try {			
				
			Instructor tempInstructor = 
					new Instructor("Zayn", "Malik", "zm@g.com");
			
			InstructorDetail tempInstructorDetail =
					new InstructorDetail(
							"http://www.youtube.com",
							"Model");		
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			session.beginTransaction();
			
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);					
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {		
			session.close();
			factory.close();
		}
	}

}






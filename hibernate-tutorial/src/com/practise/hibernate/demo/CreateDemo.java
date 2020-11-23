package com.practise.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practise.hibernate.demo.entity.Instructor;
import com.practise.hibernate.demo.entity.InstructorDetail;
import com.practise.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {			
			
			
			Instructor tempInstructor = 
					new Instructor("Jubin", "Shah", "js@g.com");
			
			InstructorDetail tempInstructorDetail =
					new InstructorDetail(
							"http://youtubejs.com",
							"Football");		
			
			
//			Instructor tempInstructor = 
//					new Instructor("Jay", "Alvarez", "ja@g.com");
//			
//			InstructorDetail tempInstructorDetail =
//					new InstructorDetail(
//							"http://www.youtube.com",
//							"Guitar");		
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
		
			session.beginTransaction();
			
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);			
		
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}






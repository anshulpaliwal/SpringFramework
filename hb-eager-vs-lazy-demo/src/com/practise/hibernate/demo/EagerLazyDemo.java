package com.practise.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practise.hibernate.demo.entity.Course;
import com.practise.hibernate.demo.entity.Instructor;
import com.practise.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
	
		Session session = factory.getCurrentSession();
		
		try {			
			
			session.beginTransaction();
			
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);		
			
			System.out.println("Console: Instructor: " + tempInstructor);
		
			System.out.println("Console: Courses: " + tempInstructor.getCourses());
			
			session.getTransaction().commit();
			
			session.close();
			
			System.out.println("\nConsole: The session is now closed!\n");

			System.out.println("Console: Courses: " + tempInstructor.getCourses());
			
			System.out.println("Console: Done!");
		}
		finally {		
			session.close();			
			factory.close();
		}
	}
}






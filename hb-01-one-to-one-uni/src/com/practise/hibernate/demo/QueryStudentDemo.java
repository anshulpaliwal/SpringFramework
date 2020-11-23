package com.practise.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practise.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {			
			
			session.beginTransaction();
		
			List<Student> theStudents = session.createQuery("from Student").getResultList();
		
			displayStudents(theStudents);
						
			theStudents = session.createQuery("from Student s where s.lastName='Paliwal'").getResultList();
			
			System.out.println("\n\nStudents who have last name of Paliwal");
			displayStudents(theStudents);
			
			theStudents =
					session.createQuery("from Student s where"
							+ " s.lastName='Paliwal' OR s.firstName='Paliwal'").getResultList();
			
			System.out.println("\n\nStudents who have last name of Paliwal OR first name Anshul");
			displayStudents(theStudents);
		
			theStudents = session.createQuery("from Student s where"
					+ " s.email LIKE '%g.com'").getResultList();

			System.out.println("\n\nStudents whose email ends with g.com");			
			displayStudents(theStudents);			
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}






package com.practise.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practise.hibernate.demo.entity.Course;
import com.practise.hibernate.demo.entity.Instructor;
import com.practise.hibernate.demo.entity.InstructorDetail;
import com.practise.hibernate.demo.entity.Review;
import com.practise.hibernate.demo.entity.Student;

public class AddCoursesForMaryDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
	
		Session session = factory.getCurrentSession();		
		try {			
			session.beginTransaction();			
			int studentId = 2;
			Student tempStudent = session.get(Student.class, studentId);			
			System.out.println("\nLoaded student: " + tempStudent);
			System.out.println("Courses: " + tempStudent.getCourses());
			
			Course tempCourse1 = new Course("Rubik's Cube");
			Course tempCourse2 = new Course("Atari 2600");
			
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);			
			System.out.println("\nSaving the courses ...");			
			session.save(tempCourse1);
			session.save(tempCourse2);
			
			session.getTransaction().commit();			
			System.out.println("Done!");
		}
		finally {			
			session.close();			
			factory.close();
		}
	}
}






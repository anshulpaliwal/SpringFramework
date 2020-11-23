package com.practise.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practise.hibernate.demo.entity.Course;
import com.practise.hibernate.demo.entity.Instructor;
import com.practise.hibernate.demo.entity.InstructorDetail;
import com.practise.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
	
		Session session = factory.getCurrentSession();		
		try {					
			session.beginTransaction();			
			Course tempCourse = new Course("Pacman - How To Score One Million Points");
			
			tempCourse.addReview(new Review("Review1"));
			tempCourse.addReview(new Review("Review2"));
			tempCourse.addReview(new Review("Review3"));
			
			System.out.println("Saving the course");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			
			session.save(tempCourse);			
			session.getTransaction().commit();			
			System.out.println("Done!");
		}
		finally {			
			session.close();			
			factory.close();
		}
	}

}






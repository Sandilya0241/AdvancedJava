package com.hibernatesdemo.learningOneToManyUni;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatesdemo.learningOneToManyUni.entity.Instructor;
import com.hibernatesdemo.learningOneToManyUni.entity.InstructorDetail;
import com.hibernatesdemo.learningOneToManyUni.entity.Review;
import com.hibernatesdemo.learningOneToManyUni.entity.Course;

public class DeleteCourseAndReviewOneToManyUniDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg4.xml")
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			//Delete Course
			int id = 10 ;
			
			// Start a transaction
			session.beginTransaction();
			
			Course course = session.get(Course.class, id);
			
			if(course != null) {
				session.delete(course);
			}
			//Commit the transaction
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			//Delete Review
			id = 4 ;
			
			// Start a transaction
			session.beginTransaction();
			
			Review review = session.get(Review.class, id);
			
			if(review != null) {
				session.delete(review);
			}
			//Commit the transaction
			session.getTransaction().commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

}

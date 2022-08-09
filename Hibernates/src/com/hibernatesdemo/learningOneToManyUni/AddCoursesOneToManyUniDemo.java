package com.hibernatesdemo.learningOneToManyUni;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatesdemo.learningOneToManyUni.entity.Instructor;
import com.hibernatesdemo.learningOneToManyUni.entity.InstructorDetail;
import com.hibernatesdemo.learningOneToManyUni.entity.Review;
import com.hibernatesdemo.learningOneToManyUni.entity.Course;

public class AddCoursesOneToManyUniDemo {

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
			int id = 13;
			List<Review> reviews = new ArrayList<Review>();
			session.beginTransaction();
			
			Course course = session.get(Course.class, id);
			
			reviews.add(new Review("Yo YO I LIke this"));
			reviews.add(new Review("No It is little difficult"));
			
			course.setReviews(reviews);
			session.save(course);
			
			session.getTransaction().commit();
//			
//			reviews.clear();
//			id = 11;
//			
//			session.beginTransaction();
//			
//			session.getTransaction().commit();
//			
//			reviews.clear();
//			id = 13;
//
//			session.beginTransaction();
//			
//			session.getTransaction().commit();
//			
//			reviews.clear();
//			id = 14;
//			
//			session.beginTransaction();
//			
//			session.getTransaction().commit();
//			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

}

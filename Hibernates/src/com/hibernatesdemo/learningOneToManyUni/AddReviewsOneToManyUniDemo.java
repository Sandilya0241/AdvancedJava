package com.hibernatesdemo.learningOneToManyUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatesdemo.learningOneToManyUni.entity.Instructor;
import com.hibernatesdemo.learningOneToManyUni.entity.InstructorDetail;
import com.hibernatesdemo.learningOneToManyUni.entity.Review;
import com.hibernatesdemo.learningOneToManyUni.entity.Course;

public class AddReviewsOneToManyUniDemo {

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
			int id = 2;
			session.beginTransaction();
			Course course = new Course("R Lang");
			Instructor instructor = session.get(Instructor.class, id);
			instructor.add(course);
			course.setInstructor(instructor);
			session.save(course);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

}

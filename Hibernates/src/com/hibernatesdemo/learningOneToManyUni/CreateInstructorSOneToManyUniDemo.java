package com.hibernatesdemo.learningOneToManyUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatesdemo.learningOneToManyUni.entity.Instructor;
import com.hibernatesdemo.learningOneToManyUni.entity.InstructorDetail;
import com.hibernatesdemo.learningOneToManyUni.entity.Review;
import com.hibernatesdemo.learningOneToManyUni.entity.Course;

public class CreateInstructorSOneToManyUniDemo {

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
			
			InstructorDetail instructorDetails = new InstructorDetail("https://mychannel.com/videos", "Play cricket and Watch movies");
			
			Instructor instructor = new Instructor("Sandilya", "Sripathi", "Sandilya.jikelraja@gmail.com");
			
			session.beginTransaction();
			
			instructor.setInstructorDetail(instructorDetails);
			
			session.save(instructor);
			
			instructorDetails = new InstructorDetail("https://youtube.com/videos", "Play badminton and Watch movies");
			instructor = new Instructor("King", "Arom", "King.Aron@gmail.com");
			instructor.setInstructorDetail(instructorDetails);
			
			session.save(instructor);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

}

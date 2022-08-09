package com.hibernatesdemo.learning6;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatesdemo.learning6.entity.Instructor;
import com.hibernatesdemo.learning6.entity.InstructorDetail;
import com.hibernatesdemo.learning6.entity.Course;

public class DeleteCourseOneToManyBiDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg3.xml")
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			
			int id = 17 ;
			
			// Start a transaction
			session.beginTransaction();
			
			Course course = session.get(Course.class, id);
			
			if(course != null) {
				session.delete(course);
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

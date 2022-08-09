package com.hibernatesdemo.learning6;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatesdemo.learning6.entity.Instructor;
import com.hibernatesdemo.learning6.entity.InstructorDetail;
import com.hibernatesdemo.learning6.entity.Course;

public class CreateCourseOneToManyBiDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg3.xml")
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			
			int id = 1 ;
			
			// Start a transaction
			session.beginTransaction();
			
			Instructor instructor = session.get(Instructor.class, id);
			
			if(instructor != null) {
				Course course = new Course("Go lang");
				instructor.add(course);
				
				session.save(course);
				
				course = new Course("SAP");
				instructor.add(course);
				
				session.save(course);
			}
			//Commit the transaction
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			id = 2;
			
			// Start a transaction
			session.beginTransaction();
			
			instructor = session.get(Instructor.class, id);
			if(instructor != null) {
				Course course = new Course("HTML");
				instructor.add(course);
				
				session.save(course);
				
				course = new Course("Jinjinaka");
				instructor.add(course);
				
				session.save(course);
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

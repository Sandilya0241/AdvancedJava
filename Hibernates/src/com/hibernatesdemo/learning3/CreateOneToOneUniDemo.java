package com.hibernatesdemo.learning3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatesdemo.learning3.entity.Instructor;
import com.hibernatesdemo.learning3.entity.InstructorDetail;

public class CreateOneToOneUniDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg2.xml")
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Instructor.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			// Create objects
			Instructor instructor = new Instructor("ABC First Name1", "ABC Last Name2", "ABC.EDFID2@gmail.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("https://mychasa.com", "My  movies");
			
			// associate objects
			instructor.setInstructorDetail(instructorDetail);
			
			// Start a transaction
			session.beginTransaction();
			
			
			// Save the entity (Instructor)
			// NOTE : the below statement will also save the instructor_detail object
			// because of CascadeType.ALL
			System.out.println("Instructor information " + instructor);
			session.save(instructor);
			
			//Commit the transaction
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}

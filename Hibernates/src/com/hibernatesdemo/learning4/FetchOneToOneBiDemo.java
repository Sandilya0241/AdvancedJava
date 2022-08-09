package com.hibernatesdemo.learning4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatesdemo.learning4.entity.Instructor;
import com.hibernatesdemo.learning4.entity.InstructorDetail;

public class FetchOneToOneBiDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg2.xml")
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Instructor.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			int id = 2;
			
			// Start a transaction
			session.beginTransaction();
			
			InstructorDetail instructorDtl = session.get(InstructorDetail.class, id);
			
			System.out.println("Instructor Details information " + instructorDtl);
			
			System.out.println("Respective Instructor information " + instructorDtl.getInstructor());
			
			
			//Commit the transaction
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}

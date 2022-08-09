package com.hibernatesdemo.learning3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatesdemo.learning3.entity.Instructor;
import com.hibernatesdemo.learning3.entity.InstructorDetail;

public class DeleteOneToOneUniDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg2.xml")
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Instructor.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			int id = 3;
			
			// Start a transaction
			session.beginTransaction();
			
			Instructor instructor = session.get(Instructor.class, id);
			
			System.out.println("Instructor information " + instructor);
			if(instructor != null) {
				// Delete the entity (Instructor)
				// NOTE : the below statement will also delete the instructor_detail object
				// because of CascadeType.ALL
				
				session.delete(instructor);
			}
			//Commit the transaction
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}

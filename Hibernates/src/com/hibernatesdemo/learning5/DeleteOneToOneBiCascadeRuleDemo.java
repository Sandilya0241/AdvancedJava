package com.hibernatesdemo.learning5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatesdemo.learning5.entity.Instructor;
import com.hibernatesdemo.learning5.entity.InstructorDetail;

public class DeleteOneToOneBiCascadeRuleDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg2.xml")
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Instructor.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			int id = 1;
			
			// Start a transaction
			session.beginTransaction();
			
			InstructorDetail instructorDtl = session.get(InstructorDetail.class, id);
			
			System.out.println("Instructor Details information " + instructorDtl);
			
			System.out.println("Respective Instructor information " + instructorDtl.getInstructor());
			
			// remove the associated object reference
			// breaking the bi-directiional link
			instructorDtl.getInstructor().setInstructorDetail(null);

			// Deleting the instructorDtl object
			session.delete(instructorDtl);
			
			//Commit the transaction
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}

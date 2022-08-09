package com.hibernatesdemo.learning6;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatesdemo.learning6.entity.Instructor;
import com.hibernatesdemo.learning6.entity.InstructorDetail;
import com.hibernatesdemo.learning6.entity.Course;

public class CreateOneToManyBiDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg3.xml")
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			
			InstructorDetail instructorDtl = new InstructorDetail("http://www.mychannel.com/mychannel", "Watch nonsense");
			
			Instructor instructor = new Instructor("Sandy", "Candy", "Sandy.Candy@gmail.com");
			
			// Start a transaction
			session.beginTransaction();
			
			instructor.setInstructorDetail(instructorDtl);
			
			session.save(instructor);
			
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

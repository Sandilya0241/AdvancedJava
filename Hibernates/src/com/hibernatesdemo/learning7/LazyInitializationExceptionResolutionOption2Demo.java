package com.hibernatesdemo.learning7;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernatesdemo.learning7.entity.Instructor;
import com.hibernatesdemo.learning7.entity.InstructorDetail;
import com.hibernatesdemo.learning7.entity.Course;


/*
 * 
 * Call getter when session is open
 * 
 */


public class LazyInitializationExceptionResolutionOption2Demo {

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
			
			
			Query<Instructor> query = session.createQuery("select i from Instructor i "
															+ "JOIN FETCH i.courses "
															+ "where i.id=:theInstructorID", Instructor.class);
			
			query.setParameter("theInstructorID", id);
			
			Instructor instructor = query.getSingleResult();
			
			if(instructor != null) {
				System.out.println("Found an instructor with id " + id + " - " + instructor);
				
				List<Course> courses = instructor.getCourses();
				for (Course c : courses) {
					System.out.println("Courses found for above instructor are " + c);
				}
				
			}
			//Commit the transaction
			session.getTransaction().commit();
			
			session.close();
			
			System.out.println("\n Session is closed \n");
			
			List<Course> courses = instructor.getCourses();
			for (Course c : courses) {
				System.out.println("Courses found for above instructor are " + c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

}

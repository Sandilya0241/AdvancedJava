package com.hibernatesdemo.learning7;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatesdemo.learning7.entity.Instructor;
import com.hibernatesdemo.learning7.entity.InstructorDetail;
import com.hibernatesdemo.learning7.entity.Course;

public class FetchInstructorCourseOneToManyBiDemo {

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
				System.out.println("Found an instructor with id " + id + " - " + instructor);
				List<Course> courses = instructor.getCourses();
				for (Course c : courses) {
					System.out.println("Courses found for above instructor are " + c);
				}
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

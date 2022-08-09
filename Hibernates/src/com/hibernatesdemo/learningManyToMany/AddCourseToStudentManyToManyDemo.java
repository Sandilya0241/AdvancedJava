package com.hibernatesdemo.learningManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatesdemo.learningManyToMany.entity.Instructor;
import com.hibernatesdemo.learningManyToMany.entity.InstructorDetail;
import com.hibernatesdemo.learningManyToMany.entity.Review;
import com.hibernatesdemo.learningManyToMany.entity.Student;
import com.hibernatesdemo.learningManyToMany.entity.Course;

public class AddCourseToStudentManyToManyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg5.xml")
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Student.class)
									.addAnnotatedClass(Review.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			
			int id = 2;
			
			Course course1 = new Course("Java complete");
			Course course2 = new Course("Python");
			session.beginTransaction();
			
			Student student = session.get(Student.class, id);
			
			if(student != null) {
				System.out.println("Student record fetched ... " + student);
				
				// Add student to courses
				course1.addStudent(student);
				course2.addStudent(student);
				
				// Save courses
				session.save(course1);
				session.save(course2);
			}
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

}

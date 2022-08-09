package com.hibernatesdemo.learningManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatesdemo.learningManyToMany.entity.Instructor;
import com.hibernatesdemo.learningManyToMany.entity.InstructorDetail;
import com.hibernatesdemo.learningManyToMany.entity.Review;
import com.hibernatesdemo.learningManyToMany.entity.Student;
import com.hibernatesdemo.learningManyToMany.entity.Course;

public class CreateManyToManyDemo {

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
			
			Course course = new Course("Pacman - How to score a million points");
			session.beginTransaction();
			
			System.out.println("\nSaving course ... ");
			session.save(course);
			System.out.println("Saved course " + course);
			
			// Create students
			Student student1 = new Student("sandilya", "sripathi", "gijiri.gigirija@gmail.com");
			Student student2 = new Student("name2", "sripathi", "mane2.gigirija@gmail.com");
			Student student3 = new Student("poctect", "sripathi", "poctect2@gmail.com");
			
			// Add students to course
			course.addStudent(student1);
			course.addStudent(student2);
			course.addStudent(student3);
			
			// Save students
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

}

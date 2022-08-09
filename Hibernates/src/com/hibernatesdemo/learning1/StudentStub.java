package com.hibernatesdemo.learning1;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatesdemo.learning1.entity.Student;

public class StudentStub {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			session.save(new Student("John", "Doe", "John.Doe@yahoo.com"));
			session.save(new Student("Alex", "Mike", "Alex.Mike@yahoo.com"));
			session.save(new Student("Bob", "Steven", "Bob.Steven@yahoo.com"));
			session.save(new Student("Alan", "King", "Alan.King@yahoo.com"));
			session.save(new Student("John", "Willams", "John.Willams@yahoo.com"));
			
			session.getTransaction().commit();
			System.out.println("Saved the student object");
		} finally {
			factory.close();
		}
	}

}

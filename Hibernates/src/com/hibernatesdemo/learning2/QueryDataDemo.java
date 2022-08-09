package com.hibernatesdemo.learning2;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatesdemo.learning2.entity.Student;

public class QueryDataDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		try {
			
			System.out.println("\nPrinting all students list");
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			List<Student> listOfStudents = session.createQuery("from Student").getResultList();
			session.getTransaction().commit();
			displayStudentDetails(listOfStudents);
			
			System.out.println("\nPrinting all students list with last name as King");
			session = factory.getCurrentSession();
			session.beginTransaction();
			listOfStudents = session.createQuery("from Student s where s.lastName = 'King'").getResultList();
			session.getTransaction().commit();
			displayStudentDetails(listOfStudents);
			
			
			System.out.println("\nPrinting all students whose either list with last name is King or first name is John");
			session = factory.getCurrentSession();
			session.beginTransaction();
			listOfStudents = session.createQuery("from Student s where s.lastName = 'King' or s.firstName = 'John'").getResultList();
			session.getTransaction().commit();
			displayStudentDetails(listOfStudents);
			
			
			System.out.println("\nPrinting all students whose mailid ends with yahoo.com");
			session = factory.getCurrentSession();
			session.beginTransaction();
			listOfStudents = session.createQuery("from Student s where s.email like '%yahoo.com'").getResultList();
			session.getTransaction().commit();
			displayStudentDetails(listOfStudents);
			
			System.out.println("\nPrinting all students whose mailid ends with gmail.com");
			session = factory.getCurrentSession();
			session.beginTransaction();
			listOfStudents = session.createQuery("from Student s where s.email like '%gmail.com'").getResultList();
			session.getTransaction().commit();
			displayStudentDetails(listOfStudents);
			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

	private static void displayStudentDetails(List<Student> listOfStudents) {
		for (Student st : listOfStudents) {
			System.out.println(st);
			System.out.println("\n");
		}
	}

}

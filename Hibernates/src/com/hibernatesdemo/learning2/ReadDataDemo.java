package com.hibernatesdemo.learning2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatesdemo.learning2.entity.Student;

public class ReadDataDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		try {
			Student student = new Student("Pumba", "Simon", "Pumba.Simon@yahoo.com");
			
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println(student);
			session.save(student);
			
			session.getTransaction().commit();
			
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			Student st = session.get(Student.class, student.getId());
			
			System.out.println("Data inserted was : " + st);
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}
}

package com.hibernatesdemo.learning2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatesdemo.learning2.entity.Student;

public class UpdateDataDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			int studentNumber = 1;
			session.beginTransaction();
			Student theStudent = session.get(Student.class, studentNumber);
			theStudent.setEmail("QBC1@apple.com");
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student set email='sandilya.sripathi@amazon.in' where id > 3").executeUpdate();
			session.getTransaction().commit();
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			factory.close();
		}
	}
}

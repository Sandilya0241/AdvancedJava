package com.hibernatesdemo.learning2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatesdemo.learning2.entity.Student;

public class DeleteDataDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			int studentNumber = 6;
			session.beginTransaction();
			Student theStudent = session.get(Student.class, studentNumber);
			if(theStudent != null) {
				session.delete(theStudent);
			}
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("delete from Student where id=2").executeUpdate();
			session.getTransaction().commit();
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			factory.close();
		}
	}
}

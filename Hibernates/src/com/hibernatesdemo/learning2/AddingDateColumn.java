package com.hibernatesdemo.learning2;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatesdemo.learning2.entity.Student;

/*
 * ALTER TABLE `hb_student_tracker`.`student` 
 * ADD COLUMN `date_of_birth` DATETIME NULL AFTER `last_name`;
 */

public class AddingDateColumn {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			int id = 1;
			session.beginTransaction();
			Student theStudent = session.get(Student.class, id);
			Date theDate = DateUtils.parseDate("29/01/1988");
			theStudent.setDateOfBirth(theDate);
			session.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			factory.close();
		}
	}

}

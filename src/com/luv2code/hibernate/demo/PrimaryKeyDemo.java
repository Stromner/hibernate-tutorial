package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		// Perform crud operations on the session
		try {
			Student student1 = new Student("A", "B", "A@B.com");
			Student student2 = new Student("C", "D", "C@D.com");
			Student student3 = new Student("E", "F", "E@F.com");
			
			// Save object
			System.out.println("Starting transaction");
			session.beginTransaction();
			System.out.println("Saving object");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			System.out.println("Committing the transaction");
			session.getTransaction().commit();
		}
		finally {
			System.out.println("Closing transaction");
			session.close();
		}
	}

}

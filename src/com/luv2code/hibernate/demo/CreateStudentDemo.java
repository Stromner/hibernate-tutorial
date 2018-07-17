package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

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
			Student student = new Student("David", "Stromner", "david@stromner.se");
			
			// Save object
			System.out.println("Starting transaction");
			session.beginTransaction();
			System.out.println("Saving object");
			session.save(student);
			System.out.println("Committing the transaction");
			session.getTransaction().commit();
		}
		finally {
			System.out.println("Closing transaction");
			session.close();
		}
	}

}

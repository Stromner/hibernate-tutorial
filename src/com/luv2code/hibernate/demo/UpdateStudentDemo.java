package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		// Perform CRUD operations on the session
		try {
			// Update a single student
			int studentId = 1;
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student student = session.get(Student.class, studentId);
			System.out.println(student.toString());

			student.setFirstName("Brock");
			
			session.getTransaction().commit(); // Don't need to call save/update first because the object is persistence
			
			// Quuery update
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session
				.createQuery("update Student set email='test@email.com'")
				.executeUpdate(); // No need to call commit for this
		}
		finally {
			System.out.println("Closing transaction");
			session.close();
		}
	}

}

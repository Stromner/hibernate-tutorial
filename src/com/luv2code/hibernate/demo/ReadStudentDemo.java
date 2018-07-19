package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student student = new Student("A", "Duck", "quack@hot-ducks.com");
			System.out.println("Student ID before save:\t"+student.getId());
			
			// Save object
			session.beginTransaction();
			session.save(student);
			System.out.println("Student ID after save:\t"+student.getId());
			
			session.getTransaction().commit();
			
			// Retrieve student
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student testStudent = session.get(Student.class, student.getId());
			System.out.println(testStudent.toString());
			session.getTransaction().commit();
		}
		finally {
			System.out.println("Closing transaction");
			session.close();
		}
	}

}

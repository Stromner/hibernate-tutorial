package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

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
			session.beginTransaction();
			
			// Query students: *
			System.out.println("\nQuery: *");
			List<Student> listStudent = session.createQuery("from Student").getResultList();
			displayStudents(listStudent);
			
			// Query students: lastName='B'
			System.out.println("\nQuery: lastname='B'");
			listStudent = session.createQuery("from Student where lastName='B'").getResultList();
			displayStudents(listStudent);
			
			// Query students: lastName='D' OR firstName='A'
			System.out.println("\nQuery: lastName='D' OR firstName='A'");
			listStudent = session
					.createQuery("from Student where lastName='D'"
							+ "OR firstName='A'")
					.getResultList();
			displayStudents(listStudent);
			
			// Query students: email='%A%'
			System.out.println("\nQuery: email=%A%");
			listStudent = session.createQuery("from Student where email LIKE '%A%'").getResultList();
			displayStudents(listStudent);
			
			session.getTransaction().commit();
		}
		finally {
			System.out.println("Closing transaction");
			session.close();
		}
	}

	private static void displayStudents(List<Student> listStudent) {
		for(Student s:listStudent) {
			System.out.println(s.toString());
		}
	}

}

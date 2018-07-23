package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			// Delete a single student
			/*session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student student = session.get(Student.class, 6);
			session.delete(student);
			session.getTransaction().commit();*/
			
			// Delete query
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session
				.createQuery("delete from Student where id=6")
				.executeUpdate();
			
		}
		finally {
			System.out.println("Closing transaction");
			session.close();
		}
	}

}

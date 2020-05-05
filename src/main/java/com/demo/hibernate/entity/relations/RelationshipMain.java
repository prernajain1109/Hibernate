package com.demo.hibernate.entity.relations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RelationshipMain {

	public static void main(String[] args) {

		// =====================================
		
		Laptop laptom = new Laptop();
		laptom.setId(2);
		laptom.setLname("HP");
		
		Student std = new Student();
		std.setMarks(100);
		std.setName("Vaibhav");
		std.setRollno(25);
		std.getLaptop().add(laptom);


		Configuration cfg = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		// ==============SESSION 1=========================================
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		std = (Student) session.get(Student.class, 25);
		tx.commit();
		session.close();
		// ==================SESSIION 2=====================================
		
		Session session1 = sessionFactory.openSession();
		 session1.beginTransaction();
		std = (Student) session1.get(Student.class, 25);
		session1.getTransaction().commit();
		session1.close();
		
		
		
		
	}

}

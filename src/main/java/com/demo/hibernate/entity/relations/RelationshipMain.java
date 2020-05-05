package com.demo.hibernate.entity.relations;

import org.hibernate.Query;
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
		Query q= session.createQuery("from Student where rollno=25");
		q.setCacheable(true);
		std=(Student) q.uniqueResult();
		System.out.println(std.toString());
		//std = (Student) session.get(Student.class, 25);
		tx.commit();
		session.close();
		// ==================SESSIION 2=====================================
		
		Session session1 = sessionFactory.openSession();
		 session1.beginTransaction();
		 Query q1= session1.createQuery("from Student where rollno=25");
		 q1.setCacheable(true);
			std=(Student) q1.uniqueResult();
			System.out.println(std.toString());
		session1.getTransaction().commit();
		session1.close();
		
		
		
		
	}

}

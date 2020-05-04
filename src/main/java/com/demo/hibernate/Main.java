package com.demo.hibernate;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		
		//=====================================
		User user = new User();
		FullName fn = new FullName();
		fn.setFirstName("prerna");
		fn.setMiddleName("Vikas");
		fn.setLastName("Jain");
		user.setId(1);
		user.setName(fn);
		user.setAddress("Mayur Vihar");
		//=======================================================

		Configuration cfg = new Configuration().configure().addAnnotatedClass(User.class);
		SessionFactory sessionFactory = cfg.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		//=========================================================================================
		session.save(user);
		// user = (User) session.get(User.class, 1);
		
		//==========================================================================================
		
		tx.commit();
	}

}

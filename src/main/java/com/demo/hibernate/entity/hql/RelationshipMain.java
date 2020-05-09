package com.demo.hibernate.entity.hql;

import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RelationshipMain {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure().addAnnotatedClass(Student.class);
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		//basic hql
		/*int b=1;
		Query query=session.createQuery("select rollno,marks,name from Student where marks= :b");
		query.setParameter("b", b);
		
		List<Object[]> stud=  query.list();
		for(Object[] std : stud) {
			System.err.println(std[0]+"......"+std[1]);
		}*/
		
		
		
		//SQL
		/*SQLQuery query= session.createSQLQuery("select * from student where marks=1");
		query.addEntity(Student.class);
		List<Student> l= query.list();
		
		for(Student std:l) {
			System.out.println(std);
		}*/
		SQLQuery query= session.createSQLQuery("select name from student where marks=1");
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		
		Map x = (Map)query.uniqueResult();
		System.out.println(x.get("name"));
		
		tx.commit();
		session.close();

	}

}

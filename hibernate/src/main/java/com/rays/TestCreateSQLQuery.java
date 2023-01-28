package com.rays;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class TestCreateSQLQuery {
	public static void main(String[] args) throws Exception  {
				// testCreateSQLQuery();
				// testCreateSQLQuery1();
				// testCreateSQLQuery2();
				// testCreateSQLQuery3();
	}
	
	//testCreateSQLQuery Method
	public static void testCreateSQLQuery() throws Exception{
			
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		Query q = session.createSQLQuery("Select * from User");//HQL Query
		
		List list = q.list();
		Iterator it = list.iterator();
		Object[] obj;
		while(it.hasNext()) {
			obj = (Object[])it.next();
			System.out.println(obj[0]);
			System.out.println(obj[1]);
			System.out.println(obj[2]);
			System.out.println(obj[3]);
			System.out.println(obj[4]);
			
		}
	}
	

	//testCreateSQLQuery1 Method
	public static void testCreateSQLQuery1() throws Exception{
			
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		
		Query q = session.createSQLQuery("Select u.id, u.fname from User u where fname like 'A%'");
		
		List list = q.list();
		Iterator it = list.iterator();
		Object[] obj;
		while(it.hasNext()) {
			obj = (Object[])it.next();
			System.out.println(obj[0]);
			System.out.println(obj[1]);
			
		}
	}
	

	//testCreateSQLQuery2 Method
	public static void testCreateSQLQuery2() throws Exception{
			
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		
		Query q = session.createSQLQuery("Select * from User order by id desc");
		
		List list = q.list();
		Iterator it = list.iterator();
		Object[] obj;
		while(it.hasNext()) {
			obj = (Object[])it.next();
			System.out.println(obj[0]);
			System.out.println(obj[1]);
			System.out.println(obj[2]);
			System.out.println(obj[3]);
			System.out.println(obj[4]);
			
		}
	}
	
	//testCreateSQLQuery3 Method
	public static void testCreateSQLQuery3() throws Exception{
			
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		
		Query q = session.createSQLQuery("Select * from User where fname = 'Amit' group by fname ");
		
		List list = q.list();
		Iterator it = list.iterator();
		Object[] obj;
		while(it.hasNext()) {
			obj = (Object[])it.next();
			System.out.println(obj[0]);
			System.out.println(obj[1]);
			System.out.println(obj[2]);
			System.out.println(obj[3]);
			System.out.println(obj[4]);
			
		}
	}

}

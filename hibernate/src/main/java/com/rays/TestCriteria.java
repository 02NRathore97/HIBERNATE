package com.rays;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class TestCriteria {
	public static void main(String[] args) throws Exception {

		// testCriteria();
		// testCriteriaRestriction();
		// testCriteriaProjection();
		// testCriteriaProjectionRestriction();
		// testCriteriaMultipleProjection();
		// testCriteriaOR();
	}
	//testCriteria Method
	public static void testCriteria() throws Exception{
			
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		
		
		List<User> list = criteria.list();//Using Generics
		Iterator<User> it = list.iterator();
		while(it.hasNext()) {
			User user = it.next();
			System.out.println(user.getId());
			System.out.println(user.getFname());
			System.out.println(user.getLname());
			System.out.println(user.getUsername());
			System.out.println(user.getPwd());
			
		}
	}
	
	//testCriteria+Restriction Method
	public static void testCriteriaRestriction() throws Exception{
			
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		//criteria.add(Restrictions.like("fname", "%d"));
		criteria.add(Restrictions.eq("id", 1));
		
		List<User> list = criteria.list();//Using Generics
		Iterator<User> it = list.iterator();
		while(it.hasNext()) {
			User user = it.next();
			System.out.println(user.getId());
			System.out.println(user.getFname());
			System.out.println(user.getLname());
			System.out.println(user.getUsername());
			System.out.println(user.getPwd());
			
		}
	}
	

	//testCriteria+Projection Method
	public static void testCriteriaProjection() throws Exception{
			
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		ProjectionList projection = Projections.projectionList();
		projection.add(Projections.property("fname"));
		criteria.setProjection(projection);
		
		List list = criteria.list();
		Iterator it = list.iterator();
		while(it.hasNext()) {
			String user =(String)it.next();
			System.out.println(user);	
		}
	}
	
	//testCriteria+Projection+Restriction Method
	public static void testCriteriaProjectionRestriction() throws Exception{
			
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("id", 1));
		ProjectionList projection = Projections.projectionList();
		projection.add(Projections.property("fname"));
		criteria.setProjection(projection);
		
		List list = criteria.list();
		Iterator it = list.iterator();
		while(it.hasNext()) {
			String user =(String)it.next();
			System.out.println(user);	
		}
	}

	//testCriteria+MultipleProjection Method
	public static void testCriteriaMultipleProjection() throws Exception{
			
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		
		ProjectionList projection = Projections.projectionList();
		projection.add(Projections.property("fname"));
		projection.add(Projections.property("id"));
		criteria.setProjection(projection);
		
		List list = criteria.list();
		Iterator it = list.iterator();
		Object[] obj;
		while(it.hasNext()) {
			obj =(Object[])it.next();
			System.out.println(obj[0]);
			System.out.println(obj[1]);
		}
	}

	//testCriteriaOR Method
	public static void testCriteriaOR() throws Exception{
			
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.or(Restrictions.like("fname", "%d"),Restrictions.eq("id", 1)));
		

		List<User> list = criteria.list();//Using Generics
		Iterator<User> it = list.iterator();
		while(it.hasNext()) {
			User user = it.next();
			System.out.println(user.getId());
			System.out.println(user.getFname());
			System.out.println(user.getLname());
			System.out.println(user.getUsername());
			System.out.println(user.getPwd());
	}
		}

}

package com.rays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestCache {
	public static void main(String[] args) throws Exception {

		// test_first_level_cache1();
		// test_first_level_cache2();
		// test_first_level_cache3();
		// test_first_level_cache4();
		// test_first_level_cache_evict();
		// test_first_level_cache_clear();
		
		// test_second_level_cache_clear();
	}
	
	//Cache 
	
	//test_first_level_cache1 Method
	private static void test_first_level_cache1() throws Exception{
			
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
			
		User user = (User)session.get(User.class, 1) ;
		System.out.println(user.getId());
		System.out.println(user.getFname());
		System.out.println(user.getLname());
		System.out.println(user.getUsername());
		System.out.println(user.getPwd());
		
		session.close();
	}
	
	//test_first_level_cache2 Method
	private static void test_first_level_cache2() throws Exception{
			
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
			
		User user = (User)session.get(User.class, 1) ;
		System.out.println(user.getId());
		System.out.println(user.getFname());
		System.out.println(user.getLname());
		System.out.println(user.getUsername());
		System.out.println(user.getPwd());
		
		
		User user1 = (User)session.get(User.class, 1) ;
		System.out.println(user1.getId());
		System.out.println(user1.getFname());
		System.out.println(user1.getLname());
		System.out.println(user1.getUsername());
		System.out.println(user1.getPwd());
		
		session.close();
	}
	

	//test_first_level_cache3 Method
	private static void test_first_level_cache3() throws Exception{
			
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
			
		User user = (User)session.get(User.class, 1) ;
		System.out.println(user.getId());
		System.out.println(user.getFname());
		System.out.println(user.getLname());
		System.out.println(user.getUsername());
		System.out.println(user.getPwd());
		session.close();
		
		User user1 = (User)session.get(User.class, 1) ;
		System.out.println(user1.getId());
		System.out.println(user1.getFname());
		System.out.println(user1.getLname());
		System.out.println(user1.getUsername());
		System.out.println(user1.getPwd());
		
		session.close();
	}
	

	//test_first_level_cache4 Method
	private static void test_first_level_cache4() throws Exception{
			
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
			
		User user = (User)session.get(User.class, 1) ;
		System.out.println(user.getId());
		System.out.println(user.getFname());
		System.out.println(user.getLname());
		System.out.println(user.getUsername());
		System.out.println(user.getPwd());
		session.close();
		
		Session session1 = factory.openSession();
		User user1 = (User)session1.get(User.class, 1) ;
		System.out.println(user1.getId());
		System.out.println(user1.getFname());
		System.out.println(user1.getLname());
		System.out.println(user1.getUsername());
		System.out.println(user1.getPwd());
		
		session1.close();
	}
	

	//test_first_level_cache_evict Method
	private static void test_first_level_cache_evict() throws Exception{
			
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
			
		User user = (User)session.get(User.class, 1) ;
		System.out.println(user.getId());
		System.out.println(user.getFname());
		System.out.println(user.getLname());
		System.out.println(user.getUsername());
		System.out.println(user.getPwd());
		session.evict(user);
		
		Session session1 = factory.openSession();
		User user1 = (User)session1.get(User.class, 1) ;
		System.out.println(user1.getId());
		System.out.println(user1.getFname());
		System.out.println(user1.getLname());
		System.out.println(user1.getUsername());
		System.out.println(user1.getPwd());
		
		session1.close();
	}
	
	//test_first_level_cache_clear Method
	private static void test_first_level_cache_clear() throws Exception{
			
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
			
		User user = (User)session.get(User.class, 1) ;
		System.out.println(user.getId());
		System.out.println(user.getFname());
		System.out.println(user.getLname());
		System.out.println(user.getUsername());
		System.out.println(user.getPwd());
		session.clear();
		
		Session session1 = factory.openSession();
		User user1 = (User)session1.get(User.class, 1) ;
		System.out.println(user1.getId());
		System.out.println(user1.getFname());
		System.out.println(user1.getLname());
		System.out.println(user1.getUsername());
		System.out.println(user1.getPwd());
		
		session1.close();
	}

	
	//test_second_level_cache_clear Method
	private static void test_second_level_cache_clear() throws Exception{
			
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
			
		User user = (User)session.get(User.class, 1) ;
		System.out.println(user.getId());
		System.out.println(user.getFname());
		System.out.println(user.getLname());
		System.out.println(user.getUsername());
		System.out.println(user.getPwd());
		//factory.close();
		session.close();
		Session session1 = factory.openSession();
		User user1 = (User)session1.get(User.class, 1) ;
		System.out.println(user1.getId());
		System.out.println(user1.getFname());
		System.out.println(user1.getLname());
		System.out.println(user1.getUsername());
		System.out.println(user1.getPwd());
		
		session1.close();
	}



}

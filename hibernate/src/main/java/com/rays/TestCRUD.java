package com.rays;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class TestCRUD {
	public static void main(String[] args) throws Exception{
		// testAdd();
		// testUpdate();
		// testDelete();
		// testAggregate();
		// testGet();
		 testGetList();
		// testGetColumn();
		// testGetMultipleColumn();
		

	}
	
	//testAdd Method
	public static void testAdd() throws Exception{
		//Load POJO
		User user = new User();
		user.setFname("Amit");
		user.setLname("Rathore");
		user.setUsername("rathoreamit123@gmail.com");
		user.setPwd("Amit@123");
		
		//Load Factory
		
		//Configuration cfg = new Configuration();
		//cfg.configure();
		//SessionFactory factory = cfg.buildSessionFactory();
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		
		//Create session
		Session session =  factory.openSession();
		Transaction tx = session.beginTransaction();
		
		//Save POJO 
		  session.save(user);
		  tx.commit();
		  
		  session.close();
		  System.out.println("Inserted");
	}
	
	//testUpdate Method
		public static void testUpdate() throws Exception{
			//Load POJO
			User user = new User();
			user.setId(1);
			user.setFname("Vinod");
			user.setLname("Rathore");
			user.setUsername("rathorevinod123@gmail.com");
			user.setPwd("Vinod@123");
			
			//Load Factory
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			
			//Create session
			Session session = factory.openSession();
		    Transaction tx = session.beginTransaction();
		    
		    //Save POJO 
			  session.update(user);
			  tx.commit();
			  
			  session.close();
			  System.out.println("update successful");
		}

		//testDelete Method
			public static void testDelete() throws Exception{
					
					User user = new User();
					user.setId(1);
					
					SessionFactory factory = new Configuration().configure().buildSessionFactory();
					
					Session session = factory.openSession();
					 Transaction tx = session.beginTransaction();
					 
					  session.delete(user);
					  tx.commit();
					  session.close();
					  System.out.println("Delete successful");
				}
			
			//testAggregate Method
			public static void testAggregate() throws Exception{
					
					SessionFactory factory = new Configuration().configure().buildSessionFactory();
					
					Session session = factory.openSession();
					Query q = session.createQuery("Select count(*) from User");
					List list = q.list();
					Long row = (Long)list.get(0);
					System.out.println(row);
				}
			

			//testGet Method
				public static void testGet() throws Exception{
						
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
				
				//testGetList Method
				public static void testGetList() throws Exception{
						
					SessionFactory factory = new Configuration().configure().buildSessionFactory();
					Session session = factory.openSession();
					
					Query q = session.createQuery("from User");//HQL Query
				 /**
				    *	List list  = q.list();
					*
					*	Iterator it = list.iterator();
					*	User user;
					*	while(it.hasNext()) {
					*		user = (User)it.next();
					*		System.out.println(user.getId());
					*		System.out.println(user.getFname());
					*		System.out.println(user.getLname());
					*		System.out.println(user.getUsername());
					*		System.out.println(user.getPwd());
					*	
					*	}
					**/
					
					List<User> list = q.list();//Using Generics
					Iterator<User> it = list.iterator();
					while(it.hasNext()) {
						User user = it.next();
						System.out.println(user.getId());
						System.out.println(user.getFname());
						System.out.println(user.getLname());
						System.out.println(user.getUsername());
						System.out.println(user.getPwd());
						
					}
					
					
					session.close();
				}

				//testGetColumn Method
				public static void testGetColumn() throws Exception{
						
					SessionFactory factory = new Configuration().configure().buildSessionFactory();
					Session session = factory.openSession();
					
					Query q = session.createQuery("from User where fname like '%Amit%'");//HQL Query
					List<User> list = q.list();//Using Generics
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
				
				//testGetMultipleColumn Method
				public static void testGetMultipleColumn() throws Exception{
						
					SessionFactory factory = new Configuration().configure().buildSessionFactory();
					Session session = factory.openSession();
					
					Query q = session.createQuery("Select u.id, u.fname from User u");//HQL Query
					List list = q.list();
					Iterator it = list.iterator();
					Object[] obj;
					while(it.hasNext()) {
						obj = (Object[])it.next();
						System.out.println(obj[0]);
						System.out.println(obj[1]);
						
						
					}
				}
			}

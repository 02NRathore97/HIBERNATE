package com.rays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestCRUD {
	public static void main(String[] args) throws Exception{
		// testAdd();
		
	}
	
	//testAdd Method
	private static void testAdd() throws Exception{
		//creating object of User class
		User user = new User();
		
		//setting values
		user.setFname("shubham");
		user.setLname("kumawat");
		user.setUsername("shubham123@gmail.com");
		user.setPwd("kumawat@123");
		
		
		//creating object of SessionFactory
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		 Transaction tx = session.beginTransaction();
		 
		  session.save(user);
		  tx.commit();
		  
		  session.close();
		  System.out.println("Inserted");
	}
	
	

}


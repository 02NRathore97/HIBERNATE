package com.rays.Association1;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestOne2Many {
	public static void main(String[] args) {
		One2Many();
}

	public static void One2Many() {
		AuctionItem item = new AuctionItem();
		item.setDescription("iphone");
		
		Bid bid1 = new Bid();
		bid1.setAmount(100);
		

		Bid bid2 = new Bid();
		bid2.setAmount(200);
		
		Bid bid3 = new Bid();
		bid3.setAmount(300);
		
		Set<Bid> set = new HashSet<Bid>();
		set.add(bid1);
		set.add(bid2);
		set.add(bid3);
		
		item.setBid(set);
		

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		
		//Create session
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		 
		//Save POJO 
		  session.save(item);
		  tx.commit();
		  
		  session.close();
		  System.out.println("Inserted");
	}
		
	}

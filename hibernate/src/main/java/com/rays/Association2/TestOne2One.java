package com.rays.Association2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestOne2One {
	public static void main(String[] args) {
		One2One();
	}

	public static void One2One() {
		Employee employee = new Employee();
		employee.setName("Neeraj");
		
		Address address = new Address();
		address.setCity("Indore");
		address.setState("MP");
		
		employee.setAddress(address);
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(employee);
		session.save(address);
		
		tx.commit();
		session.close();
		
		System.out.println("Inserted");
		
	}
}

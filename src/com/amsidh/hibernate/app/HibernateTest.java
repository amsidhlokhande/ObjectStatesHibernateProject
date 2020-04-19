package com.amsidh.hibernate.app;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.amsidh.hibernate.domains.UserDetails;

public class HibernateTest {

	
	public static void main(String[] args) {
		
		UserDetails user=new UserDetails();
		user.setUserName("Test user Name");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		user.setUserName("Update Test user Name");
		session.save(user);
		
		user.setUserName("Update User");
		
		session.getTransaction().commit();
		user.setUserName("Update User after committing Transaction");
		session.close();
		
		user.setUserName("Update User after closing session");
		
	}

}

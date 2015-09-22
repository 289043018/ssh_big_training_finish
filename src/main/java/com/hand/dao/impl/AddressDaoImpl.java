package com.hand.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.hand.dao.AddressDao;
import com.hand.model.Address;

@Repository("addressDao")
public class AddressDaoImpl implements AddressDao {
	
	@Autowired()
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	private Session session;
	
	/*public void setSessionFactory(SessionFactory sessionFactory) {  
        this.sessionFactory = sessionFactory;
        System.out.println(this.sessionFactory);
        }
	
	public Session getSession() {  
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-hibernate.xml"});
        sessionFactory = (SessionFactory)ac.getBean("sessionFactory");
        System.out.println(sessionFactory);      
        return this.sessionFactory.getCurrentSession();  
    } */
	
	
	
//	@PostConstruct 
//	*//*****bean实例化时执行该方法*******//*
//	 protected void injectSessionFactory(){
//		  super.setSessionFactory(sessionFactory);
//		 }
//	

	public List<Address> select() {
		session =sessionFactory.getCurrentSession();
		 List<Address> address = session.createQuery("FROM Address").list();
		return address;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Address findById(int addressId) {
		session =sessionFactory.getCurrentSession();
		return (Address) session.get(Address.class, addressId);
	}

}

package com.hand.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hand.dao.Om_cust_addressDao;
import com.hand.model.Customer;
import com.hand.model.Om_cust_address;


@Repository("om_cust_addressDao")
public class Om_cust_addressDaoImpl implements Om_cust_addressDao {

	@Autowired()
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	private Session session;
	
//	Om_cust_address om_cust_address = new Om_cust_address();
	
	public void create(Om_cust_address om_cust_address) {
		session = sessionFactory.getCurrentSession();
		session.save(om_cust_address);
		System.out.println("插入了一个地址");
		
	}
	
	public List<Om_cust_address> findByStatus(String status) {
		session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Om_cust_address.class);    
		cr.add(Restrictions.like("status", status));  
		List<Om_cust_address> om_cust_address = cr.list();  
		System.out.println(om_cust_address);
		return om_cust_address;
	}

	public Om_cust_address findByID(int address_id) {
		session = sessionFactory.getCurrentSession();
		Om_cust_address om_cust_address = null; 
		om_cust_address = (Om_cust_address) session.get(Om_cust_address.class, address_id); 
			System.out.println("查找到了："+om_cust_address.getAddress_id());
		return om_cust_address;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void update(Om_cust_address om_cust_address) {
		session = sessionFactory.getCurrentSession();
		session.update(om_cust_address);
		
	}

	
	
	

}

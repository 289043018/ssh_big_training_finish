package com.hand.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hand.dao.Om_cust_paymentDao;
import com.hand.model.Om_cust_contactors;
import com.hand.model.Om_cust_info;
import com.hand.model.Om_cust_payment;

@Repository("om_cust_paymentDao")
public class Om_cust_paymentDaoImpl implements Om_cust_paymentDao {

	@Autowired()
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	private Session session;
	
	Om_cust_payment om_cust_payment = new Om_cust_payment();
	
	public void create(Om_cust_payment om_cust_payment) {
		session = sessionFactory.getCurrentSession();
		session.save(om_cust_payment);
		System.out.println("插入了一个付款信息");

	}
	
	public Om_cust_payment findByCust_id(int cust_id) {
		session = sessionFactory.getCurrentSession();
		String hql = "FROM Om_cust_payment  WHERE cust_id = :cust_id";
		Query query = session.createQuery(hql);
		query.setParameter("cust_id",cust_id);
//		Om_cust_payment om_cust_payment = (Om_cust_payment) query.list();
		
		List<Om_cust_payment> om_cust_paymentList = query.list();
		Om_cust_payment om_cust_payment =null;
		
		if(!om_cust_paymentList.isEmpty()){
			Iterator<Om_cust_payment> it = om_cust_paymentList.iterator();
			om_cust_payment = it.next();
		}
		return om_cust_payment;
	}


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void update(Om_cust_payment om_cust_payment) {
		session = sessionFactory.getCurrentSession();
		session.update(om_cust_payment);
		
	}

	public Om_cust_payment findById(int payment_id) {
		session = sessionFactory.getCurrentSession();
//		Om_cust_info om_cust_info = null;
		om_cust_payment = (Om_cust_payment) session.get(Om_cust_payment.class, payment_id); 
		return om_cust_payment;
	}


	

	
	
}

package com.hand.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hand.dao.Om_cust_contactorsDao;
import com.hand.model.Om_cust_contactors;
@Repository("om_cust_contactorsDao")
public class Om_cust_contactorsDaoImpl implements Om_cust_contactorsDao {

	@Autowired()
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	private Session session;
	
	Om_cust_contactors om_cust_contactors = new Om_cust_contactors();
	
	public void create(Om_cust_contactors om_cust_contactors) {
		session = sessionFactory.getCurrentSession();
		session.save(om_cust_contactors);
		System.out.println("插入了一个联系人");
		
	}
	
	public Om_cust_contactors findByCust_id(int cust_id) {
		session = sessionFactory.getCurrentSession();
//		System.out.println(cust_id);
		String hql = "FROM Om_cust_contactors  WHERE cust_id = :cust_id";
		Query query = session.createQuery(hql);
		query.setParameter("cust_id",cust_id);
		List<Om_cust_contactors> om_cust_contactorsList = query.list();
		Om_cust_contactors om_cust_contactors =null;
		
		if(!om_cust_contactorsList.isEmpty()){
			Iterator<Om_cust_contactors> it = om_cust_contactorsList.iterator();
			om_cust_contactors = it.next();
		}

//		System.out.println(om_cust_contactors);
		return om_cust_contactors;
	}


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void update(Om_cust_contactors om_cust_contactors) {
		session = sessionFactory.getCurrentSession();
		session.update(om_cust_contactors);
	}

	public Om_cust_contactors findById(int cont_id) {
		session = sessionFactory.getCurrentSession();
		om_cust_contactors = (Om_cust_contactors) session.get(Om_cust_contactors.class, cont_id);
		return om_cust_contactors;
	}

	
}

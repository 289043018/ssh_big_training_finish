package com.hand.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hand.dao.DiscountBaseDao;
import com.hand.model.Discount_base;
import com.hand.model.Discount_type;
@Repository("discountBaseDao")
public class DiscountBaseDaoImpl implements DiscountBaseDao{
	@Autowired()
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	private Session session;
	
	public List<Discount_base> select() {
		
		session =sessionFactory.getCurrentSession();
		 List<Discount_base> discount_base = session.createQuery("FROM Discount_base").list();
		return discount_base;
	}

	public Discount_base findById(int id) {
		session =sessionFactory.getCurrentSession();
		return (Discount_base) session.get(Discount_base.class, id);
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}

package com.hand.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hand.dao.DiscountTypeDao;
import com.hand.model.Address;
import com.hand.model.Discount_type;
@Repository("discountTypeDao")
public class DiscountTypeDaoImpl implements DiscountTypeDao{
	@Autowired()
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	private Session session;
	
	public List<Discount_type> select() {
		session =sessionFactory.getCurrentSession();
		 List<Discount_type> discount_type = session.createQuery("FROM Discount_type").list();
		return discount_type;
	}

	public Discount_type findById(int type_id) {
		session =sessionFactory.getCurrentSession();
		return (Discount_type) session.get(Discount_type.class, type_id);
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}

package com.hand.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hand.dao.AppliedRecordDao;
import com.hand.model.Om_discount_applied_records;
@Repository("appliedRecordDao")
public class AppliedRecordDaoImpl implements AppliedRecordDao{
	@Autowired()
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	private Session session;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public void create(Om_discount_applied_records om_discount_applied_records) {
		session = sessionFactory.getCurrentSession();
		session.save(om_discount_applied_records);
		System.out.println("插入一个用户");
		
	}

	public List<Om_discount_applied_records> select() {
		// TODO Auto-generated method stub
		return null;
	}

}

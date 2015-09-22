package com.hand.dao.impl;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hand.dao.Om_cust_infoDao;
import com.hand.model.Customer;
import com.hand.model.Om_cust_address;
import com.hand.model.Om_cust_info;


@Repository("om_cust_infoDao")
public class Om_cust_infoDaoImpl implements Om_cust_infoDao {
	
	@Autowired()
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	private Session session;
	
	
	Om_cust_info om_cust_info = new Om_cust_info();

	public Om_cust_info findById(int cust_id) {
		session = sessionFactory.getCurrentSession();
//		Om_cust_info om_cust_info = null;
		om_cust_info = (Om_cust_info) session.get(Om_cust_info.class, cust_id); 
		System.out.println("查找到了："+om_cust_info.getCustomer_name());
		return om_cust_info;
	}
	
	public List<Om_cust_info> findByName(String customer_name) {
		session = sessionFactory.getCurrentSession();
		System.out.println("开始按名字查找");
//		List<Om_cust_info> om_cust_info = session.createQuery("FROM Om_cust_info where customer_name="+customer_name).list();
		Criteria cr = session.createCriteria(Om_cust_info.class);    
		cr.add(Restrictions.like("customer_name", customer_name));  
		List<Om_cust_info> om_cust_info = cr.list();  
		System.out.println("结束按名字查找");
		
		return om_cust_info;
	}
	
	public List<Om_cust_info> findByCode(String customer_code) {
		session = sessionFactory.getCurrentSession();
		System.out.println("开始按CODE查找");
//		List<Om_cust_info> om_cust_info = session.createQuery("FROM Om_cust_info where customer_name="+customer_name).list();
		Criteria cr = session.createCriteria(Om_cust_info.class);    
		cr.add(Restrictions.like("customer_code", customer_code));  
		List<Om_cust_info> om_cust_info = cr.list();  
		System.out.println("结束按CODE查找");
		return om_cust_info;
	}
	public List<Om_cust_info> findByType(String Type) {
		session = sessionFactory.getCurrentSession();
		System.out.println("开始按Type查找");
//		List<Om_cust_info> om_cust_info = session.createQuery("FROM Om_cust_info where customer_name="+customer_name).list();
		Criteria cr = session.createCriteria(Om_cust_info.class);    
		cr.add(Restrictions.like("type", Type));  
		List<Om_cust_info> om_cust_info = cr.list();  
		System.out.println("结束按Type查找");
		return om_cust_info;
	}
	
	public List<Om_cust_info> findByGroup_company(String group_company) {
		session = sessionFactory.getCurrentSession();
		System.out.println("开始按分公司查找");
//		List<Om_cust_info> om_cust_info = session.createQuery("FROM Om_cust_info where customer_name="+customer_name).list();
		Criteria cr = session.createCriteria(Om_cust_info.class);    
		cr.add(Restrictions.like("group_company", group_company));  
		List<Om_cust_info> om_cust_info = cr.list();  
		System.out.println("结束按分公司查找");
		return om_cust_info;
	}

	public List<Om_cust_info> findByCorporation(String corporation) {
		session = sessionFactory.getCurrentSession();
		System.out.println("开始按总公司查找");
//		List<Om_cust_info> om_cust_info = session.createQuery("FROM Om_cust_info where customer_name="+customer_name).list();
		Criteria cr = session.createCriteria(Om_cust_info.class);    
		cr.add(Restrictions.like("corporation", corporation));  
		List<Om_cust_info> om_cust_info = cr.list();  
		System.out.println("结束按总公司查找");
		return om_cust_info;
	}
	
	public Om_cust_info findByAddress(int address_id) {
		session = sessionFactory.getCurrentSession();
		
		String hql = "FROM Om_cust_info  WHERE address_id = :address_id";
		Query query = session.createQuery(hql);
		query.setParameter("address_id",address_id);
		List<Om_cust_info> results =  query.list();
		Iterator<Om_cust_info> it = results.iterator();
		while (it.hasNext()) {
			om_cust_info = it.next();
		}
		return om_cust_info;
	}
	
	public Om_cust_info findByOrg(int org_id) {
		session = sessionFactory.getCurrentSession();
		
		String hql = "FROM Om_cust_org  WHERE org_id = :org_id";
		Query query = session.createQuery(hql);
		query.setParameter("org_id",org_id);
		List<Om_cust_info> results =  query.list();
		Iterator<Om_cust_info> it = results.iterator();
		while (it.hasNext()) {
			om_cust_info = it.next();
		}
		return om_cust_info;
	}
	
	public void update(Om_cust_info om_cust_info) {
		session = sessionFactory.getCurrentSession();
		session.update(om_cust_info);
	
	}

	public int create(Om_cust_info om_cust_info) {
		session = sessionFactory.getCurrentSession();
		int cust_id = (Integer) session.save(om_cust_info);
		System.out.println("插入了一个用户");
		return cust_id;
	}
	
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	

	

	

	

	

	

	
	
	
	
	

}

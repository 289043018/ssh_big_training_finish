package com.hand.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hand.dao.PageDao;
import com.hand.model.Customer;

@Repository("pageDao")
public class PageDaoImpl implements PageDao {

	@Autowired()
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	private Session session;
	
	
	
//	public void setSessionFactory(SessionFactory sessionFactory) {  
//        this.sessionFactory = sessionFactory;
//        System.out.println(this.sessionFactory);
//        }
	
/*	public Session getSession() {  
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-hibernate.xml"});
        sessionFactory = (SessionFactory)ac.getBean("sessionFactory");
        System.out.println(sessionFactory);      
        return this.sessionFactory.getCurrentSession();  
    } */
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	public int getPageCount() {
		session = sessionFactory.getCurrentSession();
		int rows = 0; 
	 	Criteria cr = session.createCriteria(Customer.class);
//		Criteria cr = getSession().createCriteria(Customer.class);
	   	Number num = (Number) cr.setProjection(Projections.rowCount()).uniqueResult();
	   	
//	   	rows = (Integer) cr.setProjection(Projections.rowCount()).uniqueResult();
	   	
	   	rows = num.intValue();
	   	
	   	System.out.println("计算出来的总数据条数："+rows);
		        if (rows % 50 == 0) {  
		            return rows / 50;  
		        } else {  
		            return rows / 50 + 1;  
		        } 
	}

}

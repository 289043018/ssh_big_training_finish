package com.hand.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hand.dao.NormalDiscountDao;
import com.hand.model.Discount_base;
import com.hand.model.Discount_type;
import com.hand.model.Om_normal_discount;
import com.hand.model.Om_special_discount;
@Repository("normalDiscountDao")
public class NormalDiscountDaoImpl implements NormalDiscountDao{
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


	public void create(Om_normal_discount om_normal_discount) {
		session = sessionFactory.getCurrentSession();
		session.save(om_normal_discount);
		
		System.out.println("插入一个用户");
		
	}

	public Om_normal_discount find(int discount_id) {
		session = sessionFactory.getCurrentSession();
		Om_normal_discount om_normal_discount = null;
		om_normal_discount = (Om_normal_discount)session.get(Om_normal_discount.class, discount_id);
		return om_normal_discount;
	}

	public List<Om_normal_discount> select() {
		session = sessionFactory.getCurrentSession();
		List<Om_normal_discount> om_normal_discount = null;
		//List<Om_normal_discount> om_normal_discount =session.createSQLQuery("select * from om_normal_discount").addEntity(Om_normal_discount.class).list();
		
			//Query query = session.createQuery("From Om_normal_discount");
			//om_normal_discount = query.list();
		try{
			om_normal_discount = session.createQuery("From Om_normal_discount").list();
			//om_normal_discount =session.createSQLQuery("select * from om_normal_discount").addEntity(Om_normal_discount.class).list();
			//System.out.println(om_normal_discount);
		}catch(Exception e){
			e.printStackTrace();
		}
		 
		/*
		for(Iterator<Om_normal_discount> itertor = om_normal_discount.iterator();itertor.hasNext(); ){
			System.out.println(itertor.next());
			String str  = itertor.next().getDiscount_name();
			System.out.println(str);
			
		}*/
		
		return om_normal_discount;
		//System.out.println(om_normal_discount);
				//setFirstResult((pagenum-1)*pagesize).setMaxResults(pagesize).list();
		
	}

	public void update(int discount_id, String discount_name, String discount_base1,String discount_type1, int base_qty,
			float discount_rate) {
		session = sessionFactory.getCurrentSession();
		Om_normal_discount om_normal_discount =(Om_normal_discount)session.get(Om_normal_discount.class, discount_id);
		om_normal_discount.setDiscount_name(discount_name);
		om_normal_discount.setDiscount_base1(discount_base1);
		om_normal_discount.setDiscount_type1(discount_type1);
		om_normal_discount.setBase_qty(base_qty);
		om_normal_discount.setDiscount_rate(discount_rate);
		session.update(om_normal_discount);
		System.out.println("更新了一条记录");
	}
/*
	public List<Om_normal_discount> findAll() {
		
		return sessionFactory.getCurrentSession().createQuery(
				"FROM om_normal_discount")
				.list();
	}*/

	public List<Om_normal_discount> findByName(String discount_name,String discount_type1) {
		session = sessionFactory.getCurrentSession();
		System.out.println("开始按名字查找");
//		List<Om_cust_info> om_cust_info = session.createQuery("FROM Om_cust_info where customer_name="+customer_name).list();
		Criteria cr = session.createCriteria(Om_normal_discount.class);
		if(StringHelper.isNotEmpty(discount_name)){
		cr.add(Restrictions.like("discount_name", discount_name));
		}
		if(StringHelper.isNotEmpty(discount_type1)){
		cr.add(Restrictions.like("discount_type1", discount_type1));
		}
		//cr.add(Restrictions.like("discount_name", discount_name));  
		//cr.add(Restrictions.like("type", type));
		System.out.println(cr);
		List<Om_normal_discount> om_normal_discount = cr.list();  
		
		System.out.println("结束按名字查找");
		System.out.println(om_normal_discount);
		return om_normal_discount;
	}

	

}

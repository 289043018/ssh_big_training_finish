package com.hand.dao.impl;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hand.dao.PriceListDao;
import com.hand.model.Om_cust_price_list;
@Repository("priceListDao")
public class PriceListDaoImpl implements PriceListDao{
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

	public void create(Om_cust_price_list om_cust_price_list) {
		session = sessionFactory.getCurrentSession();
		session.save(om_cust_price_list);
		System.out.println("插入一个用户");
		
	}

	public Om_cust_price_list find(String cust_name) {
		session = sessionFactory.getCurrentSession();
		Om_cust_price_list om_cust_price_list = null;
		om_cust_price_list = (Om_cust_price_list)session.get(Om_cust_price_list.class, cust_name);
		return om_cust_price_list;
	}

	public void update(String cust_name,String PL_YH_ITEM,Date effective_date_from, Date effective_date_to, String user_def1, String user_def2, String user_def3,
			String user_def4, String user_def5, String user_def6, String user_def7, String user_def8,
			String user_def21, String user_def9, String user_def10, String user_def11, String user_def12,
			String user_def22, String user_def13, String user_def14, String user_def15, String user_def16,
			String user_def23, String user_def17, String user_def18, String user_def19, String user_def20,
			String user_def24, String user_def25, String user_def26, String user_def27, String user_def28,
			String user_def29, String user_def30) {
		session = sessionFactory.getCurrentSession();
		Om_cust_price_list om_cust_price_list = (Om_cust_price_list)session.get(Om_cust_price_list.class,cust_name);
		om_cust_price_list.setPL_YH_ITEM(PL_YH_ITEM);
		om_cust_price_list.setEffective_date_from(effective_date_from);
		om_cust_price_list.setEffective_date_to(effective_date_to);
		om_cust_price_list.setUser_def1(user_def1);
		om_cust_price_list.setUser_def2(user_def2);
		om_cust_price_list.setUser_def3(user_def3);
		om_cust_price_list.setUser_def4(user_def4);
		om_cust_price_list.setUser_def5(user_def5);
		om_cust_price_list.setUser_def6(user_def6);
		om_cust_price_list.setUser_def7(user_def7);
		om_cust_price_list.setUser_def8(user_def8);
		om_cust_price_list.setUser_def9(user_def9);
		om_cust_price_list.setUser_def10(user_def10);
		om_cust_price_list.setUser_def11(user_def11);
		om_cust_price_list.setUser_def12(user_def12);
		om_cust_price_list.setUser_def13(user_def13);
		om_cust_price_list.setUser_def14(user_def14);
		om_cust_price_list.setUser_def15(user_def15);
		om_cust_price_list.setUser_def16(user_def16);
		om_cust_price_list.setUser_def17(user_def17);
		om_cust_price_list.setUser_def18(user_def18);
		om_cust_price_list.setUser_def19(user_def19);
		om_cust_price_list.setUser_def20(user_def20);
		om_cust_price_list.setUser_def21(user_def21);
		om_cust_price_list.setUser_def22(user_def22);
		om_cust_price_list.setUser_def23(user_def23);
		om_cust_price_list.setUser_def24(user_def24);
		om_cust_price_list.setUser_def25(user_def25);
		om_cust_price_list.setUser_def26(user_def26);
		om_cust_price_list.setUser_def27(user_def27);
		om_cust_price_list.setUser_def28(user_def28);
		om_cust_price_list.setUser_def29(user_def29);
		om_cust_price_list.setUser_def30(user_def30);
		session.update(om_cust_price_list);
		System.out.println("更新了一条记录");
		// TODO Auto-generated method stub
		
	}

	public List<Om_cust_price_list> select() {
		session = sessionFactory.getCurrentSession();
		List<Om_cust_price_list> om_cust_price_list = null;
		om_cust_price_list = session.createQuery("From Om_cust_price_list").list();
		return om_cust_price_list;
	}
}

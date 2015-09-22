package com.hand.dao;

import java.sql.Date;
import java.util.List;

import com.hand.model.Om_cust_price_list;

public interface PriceListDao {
	public void create(Om_cust_price_list om_cust_price_list);
	public List<Om_cust_price_list> select();
	public Om_cust_price_list find(String cust_name);
	public void update(String cust_name,String PL_YH_ITEM,Date effective_date_from, Date effective_date_to, String user_def1, String user_def2, String user_def3,
			String user_def4, String user_def5, String user_def6, String user_def7, String user_def8,
			String user_def21, String user_def9, String user_def10, String user_def11, String user_def12,
			String user_def22, String user_def13, String user_def14, String user_def15, String user_def16,
			String user_def23, String user_def17, String user_def18, String user_def19, String user_def20,
			String user_def24, String user_def25, String user_def26, String user_def27, String user_def28,
			String user_def29, String user_def30);
}

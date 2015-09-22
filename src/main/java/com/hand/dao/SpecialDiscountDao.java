package com.hand.dao;

import java.util.List;

import com.hand.model.Om_special_discount;

public interface SpecialDiscountDao {
	public void create(Om_special_discount om_special_discount);
	public Om_special_discount find(int discount_id);
	//public List<Om_special_discount> select(int pagesize,int pagenum);
	public void update(int discount_id,String discount_name,String cust_code,int amount,int applied_amount,int balance,String activity);
	//public List<Om_special_discount> findAll();
	public List<Om_special_discount> select();
	public List<Om_special_discount> findByName(String discount_name,String cust_code);
	
	
	
	
}

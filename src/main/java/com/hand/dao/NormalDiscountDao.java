package com.hand.dao;

import java.util.List;

import com.hand.model.Discount_base;
import com.hand.model.Discount_type;
import com.hand.model.Om_normal_discount;

public interface NormalDiscountDao {
	public void create(Om_normal_discount om_normal_discount);
	public Om_normal_discount find(int discount_id);
	//public List<Om_normal_discount> select(int pagesize,int pagenum);
	//public void update(int discount_id,String discount_name,Discount_base discount_base,Discount_type discount_type ,int base_qty,float discount_rate);
	//public List<Om_normal_discount> findAll();
	public List<Om_normal_discount> select();
	public List<Om_normal_discount> findByName(String discount_name,String discount_type1);
	
	public void update(int discount_id,String discount_name,String discount_base1,String  discount_type1 ,int base_qty,float discount_rate);
	
	
	//public List<Object> GetObjectsDataByHQL(String hql, Object entity);
}

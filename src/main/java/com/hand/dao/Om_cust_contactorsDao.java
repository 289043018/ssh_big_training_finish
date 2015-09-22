package com.hand.dao;

import org.springframework.stereotype.Component;

import com.hand.model.Om_cust_contactors;

@Component
public interface Om_cust_contactorsDao {
	public void create(Om_cust_contactors om_cust_contactors);
	public void update(Om_cust_contactors om_cust_contactors);
	public Om_cust_contactors findByCust_id(int cust_id);
	public Om_cust_contactors findById(int cont_id);
}

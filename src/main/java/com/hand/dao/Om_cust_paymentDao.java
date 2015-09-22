package com.hand.dao;

import org.springframework.stereotype.Component;

import com.hand.model.Om_cust_payment;
@Component
public interface Om_cust_paymentDao {
	public void create(Om_cust_payment om_cust_payment);
	public void update(Om_cust_payment om_cust_payment);
	public Om_cust_payment findByCust_id(int cust_id);
	public Om_cust_payment findById(int payment_id);
}

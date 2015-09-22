package com.hand.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hand.model.Om_cust_address;
@Component
public interface Om_cust_addressDao {
	public List<Om_cust_address> findByStatus(String status);
	public Om_cust_address findByID(int address_id);
	public void create(Om_cust_address  om_cust_address);
	public void update(Om_cust_address  om_cust_address);

}

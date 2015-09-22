package com.hand.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hand.model.Om_cust_org;

@Component
public interface Om_cust_orgDao {
	public Om_cust_org findById(int org_id);
	public void create(Om_cust_org om_cust_org);
	public void update(Om_cust_org om_cust_org);
	
}

package com.hand.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hand.model.Om_cust_address;
import com.hand.model.Om_cust_info;

@Component
public interface Om_cust_infoDao {
	
	public Om_cust_info findById(int cust_id);
	public List<Om_cust_info> findByName(String customer_name);
	public List<Om_cust_info> findByCode(String customer_code);
	public List<Om_cust_info> findByType(String Type);
	public List<Om_cust_info> findByGroup_company(String group_company);
	public List<Om_cust_info> findByCorporation(String corporation);
	public Om_cust_info findByAddress(int address_id);
	public Om_cust_info findByOrg(int org_id);
	
	public int create(Om_cust_info om_cust_info);
	
	public void update(Om_cust_info om_cust_info);
}

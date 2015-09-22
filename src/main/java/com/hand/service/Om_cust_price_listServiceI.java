package com.hand.service;

import java.util.List;

import com.hand.model.Om_cust_price_list;

public interface Om_cust_price_listServiceI {

	List<Om_cust_price_list> list(int page,int rows,String sort,String order);
	int getTotal();
}
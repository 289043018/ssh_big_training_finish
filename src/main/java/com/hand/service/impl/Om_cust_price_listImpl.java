package com.hand.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hand.dao.Om_cust_price_listDaoI;
import com.hand.dao.impl.Om_cust_price_listDaoImpl;
import com.hand.model.Om_cust_price_list;
import com.hand.service.Om_cust_price_listServiceI;

public class Om_cust_price_listImpl implements Om_cust_price_listServiceI {

	private Om_cust_price_listDaoI om_cust_price_listDao = new Om_cust_price_listDaoImpl();
	public List<Om_cust_price_list> list(int page, int rows, String sort, String order) {
		List<Om_cust_price_list> om_cust_price_lists = new ArrayList<Om_cust_price_list>();
		try {
			om_cust_price_lists = om_cust_price_listDao.list(page, rows, sort, order);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return om_cust_price_lists;
	}
	
	public int getTotal(){
		int total = 0;
		try {
			total = om_cust_price_listDao.getTotal();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}
}
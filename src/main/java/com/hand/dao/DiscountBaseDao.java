package com.hand.dao;

import java.util.List;

import com.hand.model.Discount_base;
import com.hand.model.Discount_type;

public interface DiscountBaseDao {
	public List<Discount_base> select();
	public Discount_base findById(int id);
}

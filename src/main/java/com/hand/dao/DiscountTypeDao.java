package com.hand.dao;

import java.util.List;

import com.hand.model.Discount_type;

public interface DiscountTypeDao {
	public List<Discount_type> select();
	public Discount_type findById(int type_id);
}

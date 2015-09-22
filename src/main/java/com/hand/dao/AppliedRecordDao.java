package com.hand.dao;

import java.util.List;

import com.hand.model.Om_discount_applied_records;
import com.hand.model.Om_special_discount;

public interface AppliedRecordDao {
	public void create(Om_discount_applied_records om_discount_applied_records);
	public List<Om_discount_applied_records> select();
}

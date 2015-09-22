package com.hand.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Component;

@Component
public interface PageDao {
	public int  getPageCount();
}

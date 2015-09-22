package com.hand.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name="discount_base")
public class Discount_base {
	private int Id;
	private String discount_base;
	
	public Discount_base() {
		super();
	}
	
	
	public Discount_base(int id, String discount_base) {
		super();
		Id = id;
		this.discount_base = discount_base;
	}


	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id",columnDefinition="int")
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	
	@Column(name="discount_base",columnDefinition="String")
	public String getDiscount_base() {
		return discount_base;
	}
	
	public void setDiscount_base(String discount_base) {
		this.discount_base = discount_base;
	}


	
	
}

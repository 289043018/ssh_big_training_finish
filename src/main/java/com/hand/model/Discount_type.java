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
@Table(name="discount_type")
public class Discount_type {
	private int type_id;
	private String type;
	
	public Discount_type() {
		super();
	}
	public Discount_type(int type_id, String type) {
		super();
		this.type_id = type_id;
		this.type = type;
	}
	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="type_id",columnDefinition="int")
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	@Column(name="type",columnDefinition="String")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}

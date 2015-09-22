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
@Table(name="om_cust_org")
public class Om_cust_org {
	private int org_id;
	private String market_area;
	private String bussiness_manager;
	private String bussiness_assistant;
	
	public Om_cust_org() {
	}
	public Om_cust_org(int org_id,String market_area, String bussiness_manager, String bussiness_assistant) {
		super();
		this.org_id = org_id;
		this.market_area = market_area;
		this.bussiness_manager = bussiness_manager;
		this.bussiness_assistant = bussiness_assistant;
	}
	
	
	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO) 
	public int getOrg_id() {
		return org_id;
	}
	public void setOrg_id(int org_id) {
		this.org_id = org_id;
	}
	
	@Column(name="market_area")
	public String getMarket_area() {
		return market_area;
	}
	public void setMarket_area(String market_area) {
		this.market_area = market_area;
	}
	
	@Column(name="bussiness_manager")
	public String getBussiness_manager() {
		return bussiness_manager;
	}
	public void setBussiness_manager(String bussiness_manager) {
		this.bussiness_manager = bussiness_manager;
	}
	
	@Column(name="bussiness_assistant")
	public String getBussiness_assistant() {
		return bussiness_assistant;
	}
	public void setBussiness_assistant(String bussiness_assistant) {
		this.bussiness_assistant = bussiness_assistant;
	}
	

}

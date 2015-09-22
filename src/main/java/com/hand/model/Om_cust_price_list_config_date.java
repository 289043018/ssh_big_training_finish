package com.hand.model;

import java.security.Timestamp;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;


@Repository
@Entity
@Table(name="om_cust_price_list_config_date")
public class Om_cust_price_list_config_date {
	private int id;
	private String cust_code;
	private String type;
	private String display_name;
	private String price_list_col;
	private int EXCEL_col;
	private String activity;
	private Timestamp activity_date_from;
	private Timestamp activity_date_to;
	public Om_cust_price_list_config_date() {
	}
	public Om_cust_price_list_config_date(int id, String cust_code, String type, String display_name,
			String price_list_col, int eXCEL_col, String activity, Timestamp activity_date_from, Timestamp activity_date_to) {
		super();
		this.id = id;
		this.cust_code = cust_code;
		this.type = type;
		this.display_name = display_name;
		this.price_list_col = price_list_col;
		EXCEL_col = eXCEL_col;
		this.activity = activity;
		this.activity_date_from = activity_date_from;
		this.activity_date_to = activity_date_to;
	}
	
	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO) 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="cust_code")
	public String getCust_code() {
		return cust_code;
	}
	public void setCust_code(String cust_code) {
		this.cust_code = cust_code;
	}
	
	@Column(name="type")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name="display_name")
	public String getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	
	@Column(name="price_list_col")
	public String getPrice_list_col() {
		return price_list_col;
	}
	public void setPrice_list_col(String price_list_col) {
		this.price_list_col = price_list_col;
	}
	
	@Column(name="EXCEL_col")
	public int getEXCEL_col() {
		return EXCEL_col;
	}
	public void setEXCEL_col(int eXCEL_col) {
		EXCEL_col = eXCEL_col;
	}
	
	@Column(name="activity")
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	
	@Column(name="activity_date_from",columnDefinition="Timestamp")
	public Timestamp getActivity_date_from() {
		return activity_date_from;
	}
	public void setActivity_date_from(Timestamp activity_date_from) {
		this.activity_date_from = activity_date_from;
	}
	
	@Column(name="activity_date_to",columnDefinition="Timestamp")
	public Timestamp getActivity_date_to() {
		return activity_date_to;
	}
	public void setActivity_date_to(Timestamp activity_date_to) {
		this.activity_date_to = activity_date_to;
	}
	

}

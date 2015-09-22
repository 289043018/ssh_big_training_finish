package com.hand.model;

import javax.persistence.*;

import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name="om_customers_info")
public class Om_cust_info {
	private int cust_id;
	private String customer_code;
	private String customer_name;
	private String type;
	private String group_company;
	private String corporation;
	private Om_cust_org org;
	private Om_cust_address address;
	private Om_normal_discount discount;
	public Om_cust_info() {
	}
	public Om_cust_info(int cust_id, String customer_code, String customer_name, String type, String group_company,
			String corporation, Om_cust_org org, Om_normal_discount discount,Om_cust_address address) {
		super();
		this.cust_id = cust_id;
		this.customer_code = customer_code;
		this.customer_name = customer_name;
		this.type = type;
		this.group_company = group_company;
		this.corporation = corporation;
		this.org = org;
		this.discount = discount;
		this.address=address;
	}
	
	
	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO) 
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	
	@Column(name="customer_code")
	public String getCustomer_code() {
		return customer_code;
	}
	public void setCustomer_code(String customer_code) {
		this.customer_code = customer_code;
	}
	
	@Column(name="customter_name")
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	
	@Column(name="type")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name="group_company")
	public String getGroup_company() {
		return group_company;
	}
	public void setGroup_company(String group_company) {
		this.group_company = group_company;
	}
	
	@Column(name="corporation")
	public String getCorporation() {
		return corporation;
	}
	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}
	
	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="discount_id")
	public Om_normal_discount getDiscount() {
		return discount;
	}
	public void setDiscount(Om_normal_discount discount) {
		this.discount = discount;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="org_id")
	public Om_cust_org getOrg() {
		return org;
	}
	public void setOrg(Om_cust_org org) {
		this.org = org;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="address_id")
	public Om_cust_address getAddress() {
		return address;
	}
	public void setAddress(Om_cust_address address) {
		this.address = address;
	}

	

}

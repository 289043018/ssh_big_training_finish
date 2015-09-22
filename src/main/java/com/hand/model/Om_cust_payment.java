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
@Table(name="om_cust_payment")
public class Om_cust_payment {
	private int payment_id;
	private int cust_id;
	private String invoice_group;
	private String currency;
	private String payment_term;
	private String price_term1;
	private String price_term2;
	private String price_term3;
	private String markup_name;
	private String discount_name;
	public Om_cust_payment() {
	}
	public Om_cust_payment(int payment_id, int cust_id, String invoice_group, String currency, String payment_term,
			String price_term1, String price_term2, String price_term3, String markup_name, String discount_name) {
		super();
		this.payment_id = payment_id;
		this.cust_id = cust_id;
		this.invoice_group = invoice_group;
		this.currency = currency;
		this.payment_term = payment_term;
		this.price_term1 = price_term1;
		this.price_term2 = price_term2;
		this.price_term3 = price_term3;
		this.markup_name = markup_name;
		this.discount_name = discount_name;
	}
	
	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO) 
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	
	@Column(name="cust_id")
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	
	@Column(name="invoice_group")
	public String getInvoice_group() {
		return invoice_group;
	}
	public void setInvoice_group(String invoice_group) {
		this.invoice_group = invoice_group;
	}
	
	@Column(name="currency")
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	@Column(name="payment_term")
	public String getPayment_term() {
		return payment_term;
	}
	public void setPayment_term(String payment_term) {
		this.payment_term = payment_term;
	}
	
	@Column(name="price_term1")
	public String getPrice_term1() {
		return price_term1;
	}
	public void setPrice_term1(String price_term1) {
		this.price_term1 = price_term1;
	}
	
	@Column(name="price_term2")
	public String getPrice_term2() {
		return price_term2;
	}
	public void setPrice_term2(String price_term2) {
		this.price_term2 = price_term2;
	}
	
	@Column(name="price_term3")
	public String getPrice_term3() {
		return price_term3;
	}
	public void setPrice_term3(String price_term3) {
		this.price_term3 = price_term3;
	}
	
	@Column(name="markup_name")
	public String getMarkup_name() {
		return markup_name;
	}
	public void setMarkup_name(String markup_name) {
		this.markup_name = markup_name;
	}
	
	@Column(name="discount_name")
	public String getDiscount_name() {
		return discount_name;
	}
	public void setDiscount_name(String discount_name) {
		this.discount_name = discount_name;
	}
	

}

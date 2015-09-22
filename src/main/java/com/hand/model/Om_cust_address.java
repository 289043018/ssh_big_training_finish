package com.hand.model;

import java.security.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;


@Repository
@Entity
@Table(name="om_cust_address")
public class Om_cust_address {
	private int address_id;
	private String country;
	private String state;
	private String city;
	private String address1;
	private String address2;
	private String postcode;
	private String port_of_destination;
	private String shipping_mark;
	private String status;
	private Date inactive_date;
	
	
	public Om_cust_address() { 
	}
	public Om_cust_address(int address_id, String country, String state, String city, String address1, String address2,
			String postcode, String port_of_destination, String shipping_mark, String status, Date inactive_date) {
		super();
		this.address_id = address_id;
		this.country = country;
		this.state = state;
		this.city = city;
		this.address1 = address1;
		this.address2 = address2;
		this.postcode = postcode;
		this.port_of_destination = port_of_destination;
		this.shipping_mark = shipping_mark;
		this.status = status;
		this.inactive_date = inactive_date;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name="address_id")
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	
	@Column(name="country")
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Column(name="state")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@Column(name="city")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name="address1")
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	
	@Column(name="address2")
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	@Column(name="postcode")
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	@Column(name="port_of_destination")
	public String getPort_of_destination() {
		return port_of_destination;
	}
	public void setPort_of_destination(String port_of_destination) {
		this.port_of_destination = port_of_destination;
	}
	
	@Column(name="shipping_mark")
	public String getShipping_mark() {
		return shipping_mark;
	}
	public void setShipping_mark(String shipping_mark) {
		this.shipping_mark = shipping_mark;
	}
	
	@Column(name="status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name="inactive_date",columnDefinition="Date")
	public Date getInactive_date() {
		return inactive_date;
	}
	public void setInactive_date(Date inactive_date) {
		this.inactive_date = inactive_date;
	}

}

package com.hand.model;

import java.security.Timestamp;
import java.sql.Date;

import javax.persistence.*;


import org.springframework.stereotype.Repository;


@Repository
@Entity
@Table(name="user")
public class User {
	private int user_id;
	private String user_name;
	private String user_pwd;
	private String ch_name;
	private int staff_id;
	private String en_name;
	private String role;
	private int phone;
	private String email;
	private Timestamp expiry_date;
	
	
	public User() {
	}
	public User(int user_id, String user_name, String user_pwd, String ch_name, int staff_id, String en_name,
			String role, int phone, String email, Timestamp expiry_date) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_pwd = user_pwd;
		this.ch_name = ch_name;
		this.staff_id = staff_id;
		this.en_name = en_name;
		this.role = role;
		this.phone = phone;
		this.email = email;
		this.expiry_date = expiry_date;
	}
	
	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	@Column(name="user_name")
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	@Column(name="user_pwd")
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	
	@Column(name="ch_name")
	public String getCh_name() {
		return ch_name;
	}
	public void setCh_name(String ch_name) {
		this.ch_name = ch_name;
	}
	
	@Column(name="staff_id")
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	
	@Column(name="en_name")
	public String getEn_name() {
		return en_name;
	}
	public void setEn_name(String en_name) {
		this.en_name = en_name;
	}
	
	@Column(name="role")
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Column(name="phone")
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	@Column(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="expiry_date",columnDefinition="Timestamp")
	public Timestamp getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(Timestamp expiry_date) {
		this.expiry_date = expiry_date;
	}
}

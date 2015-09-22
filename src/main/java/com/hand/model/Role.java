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
@Table(name="role")
public class Role {
	private int id;
	private String role;
	private String authority1;
	private String authority2;
	private String authority3;
	private String authority4;
	private String authority5;
	private String authority6;
	public Role() {
	}
	public Role(int id, String role, String authority1, String authority2, String authority3, String authority4,
			String authority5, String authority6) {
		super();
		this.id = id;
		this.role = role;
		this.authority1 = authority1;
		this.authority2 = authority2;
		this.authority3 = authority3;
		this.authority4 = authority4;
		this.authority5 = authority5;
		this.authority6 = authority6;
	}
	
	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO) 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="role")
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Column(name="authority1")
	public String getAuthority1() {
		return authority1;
	}
	public void setAuthority1(String authority1) {
		this.authority1 = authority1;
	}
	
	@Column(name="authority2")
	public String getAuthority2() {
		return authority2;
	}
	public void setAuthority2(String authority2) {
		this.authority2 = authority2;
	}
	
	@Column(name="authority3")
	public String getAuthority3() {
		return authority3;
	}
	public void setAuthority3(String authority3) {
		this.authority3 = authority3;
	}
	
	@Column(name="authority4")
	public String getAuthority4() {
		return authority4;
	}
	public void setAuthority4(String authority4) {
		this.authority4 = authority4;
	}
	
	@Column(name="authority5")
	public String getAuthority5() {
		return authority5;
	}
	public void setAuthority5(String authority5) {
		this.authority5 = authority5;
	}
	
	@Column(name="authority6")
	public String getAuthority6() {
		return authority6;
	}
	public void setAuthority6(String authority6) {
		this.authority6 = authority6;
	}
}

package com.hand.model;

import java.security.Timestamp;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;


@Repository
@Entity
@Table(name="om_normal_discount")
public class Om_normal_discount implements java.io.Serializable {
	private static final long serialVersionUID = 1111L;
	private int discount_id;
	private String discount_name;
	private int base_qty;
	private float discount_rate;
	private String activity;
	private Date activity_date_from;
	private Date activity_date_to;
	private Discount_base discount_base;
	private Discount_type discount_type;
	private String discount_type1;
	private String discount_base1;
	public Om_normal_discount() {
	}

	public Om_normal_discount(int discount_id, String discount_name, String type, int base_qty, float discount_rate,
			String activity, Date activity_date_from, Date activity_date_to, Discount_base discount_base,
			Discount_type discount_type) {
		super();
		this.discount_id = discount_id;
		this.discount_name = discount_name;
	
		this.base_qty = base_qty;
		this.discount_rate = discount_rate;
		this.activity = activity;
		this.activity_date_from = activity_date_from;
		this.activity_date_to = activity_date_to;
		this.discount_base = discount_base;
		this.discount_type = discount_type;
	}
	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="discount_id",columnDefinition="int")
	public int getDiscount_id() {
		return discount_id;
	}
	public void setDiscount_id(int discount_id) {
		this.discount_id = discount_id;
	}
	
	@Column(name="discount_name",columnDefinition="string")
	public String getDiscount_name() {
		return discount_name;
	}
	public void setDiscount_name(String discount_name) {
		this.discount_name = discount_name;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	 @JoinColumn(name="id")
	public Discount_base getDiscount_base() {
		return discount_base;
	}
	public void setDiscount_base(Discount_base discount_base) {
		this.discount_base = discount_base;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	 @JoinColumn(name="type_id")
	public Discount_type getDiscount_type() {
		return discount_type;
	}
	public void setDiscount_type(Discount_type discount_type) {
		this.discount_type = discount_type;
	}


	@Column(name="base_qty",columnDefinition="int")
	public int getBase_qty() {
		return base_qty;
	}
	public void setBase_qty(int base_qty) {
		this.base_qty = base_qty;
	}
	
	@Column(name="discount_rate",columnDefinition="float")
	public float getDiscount_rate() {
		return discount_rate;
	}
	public void setDiscount_rate(float discount_rate) {
		this.discount_rate = discount_rate;
	}
	
	@Column(name="activity",columnDefinition="string")
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	
	@Column(name="activity_date_from",columnDefinition="date")
	public Date getActivity_date_from() {
		return activity_date_from;
	}
	public void setActivity_date_from(Date activity_date_from) {
		this.activity_date_from = activity_date_from;
	}
	
	@Column(name="activity_date_to",columnDefinition="date")
	public Date getActivity_date_to() {
		return activity_date_to;
	}
	public void setActivity_date_to(Date activity_date_to) {
		this.activity_date_to = activity_date_to;
	}
	@Column(name="type",columnDefinition="String")
	public String getDiscount_type1() {
		return discount_type1;
	}

	public void setDiscount_type1(String discount_type1) {
		this.discount_type1 = discount_type1;
	}
	@Column(name="discount_base",columnDefinition="String")
	public String getDiscount_base1() {
		return discount_base1;
	}

	public void setDiscount_base1(String discount_base1) {
		this.discount_base1 = discount_base1;
	}
	
	
	
}

package com.hand.action;

import java.sql.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hand.dao.AppliedRecordDao;
import com.hand.dao.NormalDiscountDao;
import com.hand.dao.SpecialDiscountDao;
import com.hand.model.Discount_base;
import com.hand.model.Discount_type;
import com.hand.model.Om_discount_applied_records;
import com.hand.model.Om_special_discount;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class doSpecialDiscountAction extends ActionSupport {
	private int discount_id;
	private String discount_name;
	private String cust_code;
	private int amount;
	private int applied_amount;
	private int balance;
	private String activity;
	private int delet_id;
	private Date activity_date_from;
	private Date activity_date_to;
	
	private String discount_name1;
	private String cust_code1;
	private int applied_amount1;
	private String ADN_identify_num;
	private Date applied_date;
	private int cancel;
	private Date Cancel_date;
	private String search;
	private String search1;

	ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-hibernate.xml"});
	SpecialDiscountDao specialdiscountDao = (SpecialDiscountDao)ac.getBean("specialdiscountDao");
	AppliedRecordDao appliedRecordDao = (AppliedRecordDao)ac.getBean("appliedRecordDao");
	Om_special_discount om_special_discount = (Om_special_discount)ac.getBean("om_special_discount");
	
	Om_discount_applied_records om_discount_applied_records = (Om_discount_applied_records)ac.getBean("om_discount_applied_records");
	public String add() throws Exception{
		om_special_discount.setDiscount_name(discount_name);
		om_special_discount.setAmount(amount);
		om_special_discount.setApplied_amount(applied_amount);
		om_special_discount.setBalance(balance);
		om_special_discount.setCust_code(cust_code);
		om_special_discount.setActivity(activity);
		om_special_discount.setActivity_date_from(activity_date_from);
		om_special_discount.setActivity_date_to(activity_date_to);
		specialdiscountDao.create(om_special_discount);
		//历史记录
		om_discount_applied_records.setDiscount_name(discount_name);
		om_discount_applied_records.setCust_code(cust_code);
		om_discount_applied_records.setApplied_amount(applied_amount);
		om_discount_applied_records.setADN_identify_num("1");
		om_discount_applied_records.setApplied_date(activity_date_from);
		om_discount_applied_records.setCancel(cancel);
		om_discount_applied_records.setCancel_date(activity_date_to);
		appliedRecordDao.create(om_discount_applied_records);
		return "success_tolistSpecialDiscount";
		
	}
	public String update() throws Exception{
		specialdiscountDao.update(delet_id, discount_name,cust_code, amount, applied_amount, balance,activity);
		return "success_tolistSpecialDiscount";
	}
	public String list() throws Exception{
		System.out.println("---------speciallist-----------");
		search = getSearch();
		search1 = getSearch1();
		if(search!=null || search1!=null){
			return query();
		}else{
			
			List<Om_special_discount> om_special_discount_list = specialdiscountDao.select();
			System.out.println(om_special_discount_list);
			ActionContext.getContext().put("om_special_discount_list", om_special_discount_list);
			return "success_tolistSpecialDiscount";
		}
		/*
		for(Object m : om_special_discount_List){
			System.out.println(m);
		}*/
	
		//System.out.println(om_special_discount_List);

		
	}
	public String query() throws Exception{
		search = getSearch();
		search1 = getSearch1();
		System.out.println(search);
		System.out.println("---------查找----------");
		List<Om_special_discount> om_special_discount_list = specialdiscountDao.findByName(search,search1);
		System.out.println("--------------haha--------------"+om_special_discount_list);
		ActionContext.getContext().put("om_special_discount_list", om_special_discount_list);
		return "query1";
	}
	public String toupdate(){
		Om_special_discount om_special_discount = specialdiscountDao.find(delet_id);
		ActionContext.getContext().put("om_special_discount", om_special_discount);
		return "toupdate";
	}
	
	public String toadd(){
		
		return "toadd";
	}
	public int getDiscount_id() {
		return discount_id;
	}
	public void setDiscount_id(int discount_id) {
		this.discount_id = discount_id;
	}
	public String getDiscount_name() {
		return discount_name;
	}
	public void setDiscount_name(String discount_name) {
		this.discount_name = discount_name;
	}
	public String getCust_code() {
		return cust_code;
	}
	public void setCust_code(String cust_code) {
		this.cust_code = cust_code;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getApplied_amount() {
		return applied_amount;
	}
	public void setApplied_amount(int applied_amount) {
		this.applied_amount = applied_amount;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public int getDelet_id() {
		return delet_id;
	}
	public void setDelet_id(int delet_id) {
		this.delet_id = delet_id;
	}
	public Date getActivity_date_from() {
		return activity_date_from;
	}
	public void setActivity_date_from(Date activity_date_from) {
		this.activity_date_from = activity_date_from;
	}
	public Date getActivity_date_to() {
		return activity_date_to;
	}
	public void setActivity_date_to(Date activity_date_to) {
		this.activity_date_to = activity_date_to;
	}
	public String getADN_identify_num() {
		return ADN_identify_num;
	}
	public void setADN_identify_num(String aDN_identify_num) {
		ADN_identify_num = aDN_identify_num;
	}
	public Date getApplied_date() {
		return applied_date;
	}
	public void setApplied_date(Date applied_date) {
		this.applied_date = applied_date;
	}
	public int getCancel() {
		return cancel;
	}
	public void setCancel(int cancel) {
		this.cancel = cancel;
	}
	public Date getCancel_date() {
		return Cancel_date;
	}
	public void setCancel_date(Date cancel_date) {
		Cancel_date = cancel_date;
	}
	public String getDiscount_name1() {
		return discount_name1;
	}
	public void setDiscount_name1(String discount_name1) {
		this.discount_name1 = discount_name1;
	}
	public String getCust_code1() {
		return cust_code1;
	}
	public void setCust_code1(String cust_code1) {
		this.cust_code1 = cust_code1;
	}
	public int getApplied_amount1() {
		return applied_amount1;
	}
	public void setApplied_amount1(int applied_amount1) {
		this.applied_amount1 = applied_amount1;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getSearch1() {
		return search1;
	}
	public void setSearch1(String search1) {
		this.search1 = search1;
	}
	
}

package com.hand.action;

import java.sql.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hand.dao.NormalDiscountDao;
import com.hand.dao.PriceListDao;
import com.hand.dao.SpecialDiscountDao;
import com.hand.model.Discount_base;
import com.hand.model.Discount_type;
import com.hand.model.Om_cust_price_list;
import com.hand.model.Om_special_discount;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class doPriceListAction extends ActionSupport {
	private String cust_name;
	private String PL_YH_ITEM;
	private Date effective_date_from;
	private Date effective_date_to;
	private String user_def1;
	private String user_def2;
	private String user_def3;
	private String user_def4;
	private String user_def5;
	private String user_def6;
	private String user_def7;
	private String user_def8;
	private String user_def9;
	private String user_def10;
	private String user_def11;
	private String user_def12;
	private String user_def13;
	private String user_def14;
	private String user_def15;
	private String user_def16;
	private String user_def17;
	private String user_def18;
	private String user_def19;
	private String user_def20;
	private String user_def21;
	private String user_def22;
	private String user_def23;
	private String user_def24;
	private String user_def25;
	private String user_def26;
	private String user_def27;
	private String user_def28;
	private String user_def29;
	private String user_def30;
	
	ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-hibernate.xml"});
	PriceListDao priceListDao = (PriceListDao)ac.getBean("priceListDao");
	Om_cust_price_list om_cust_price_list = (Om_cust_price_list)ac.getBean("om_cust_price_list");
	public String add() throws Exception{
		om_cust_price_list.setPL_YH_ITEM(PL_YH_ITEM);
		om_cust_price_list.setEffective_date_from(effective_date_from);
		om_cust_price_list.setEffective_date_to(effective_date_to);
		om_cust_price_list.setUser_def1(user_def1);
		om_cust_price_list.setUser_def2(user_def2);
		om_cust_price_list.setUser_def3(user_def3);
		om_cust_price_list.setUser_def4(user_def4);
		om_cust_price_list.setUser_def5(user_def5);
		om_cust_price_list.setUser_def6(user_def6);
		om_cust_price_list.setUser_def7(user_def7);
		om_cust_price_list.setUser_def8(user_def8);
		om_cust_price_list.setUser_def9(user_def9);
		om_cust_price_list.setUser_def10(user_def10);
		om_cust_price_list.setUser_def11(user_def11);
		om_cust_price_list.setUser_def12(user_def12);
		om_cust_price_list.setUser_def13(user_def13);
		om_cust_price_list.setUser_def14(user_def14);
		om_cust_price_list.setUser_def15(user_def15);
		om_cust_price_list.setUser_def16(user_def16);
		om_cust_price_list.setUser_def17(user_def17);
		om_cust_price_list.setUser_def18(user_def18);
		om_cust_price_list.setUser_def19(user_def19);
		om_cust_price_list.setUser_def20(user_def20);
		om_cust_price_list.setUser_def21(user_def21);
		om_cust_price_list.setUser_def22(user_def22);
		om_cust_price_list.setUser_def23(user_def23);
		om_cust_price_list.setUser_def24(user_def24);
		om_cust_price_list.setUser_def25(user_def25);
		om_cust_price_list.setUser_def26(user_def26);
		om_cust_price_list.setUser_def27(user_def27);
		om_cust_price_list.setUser_def28(user_def28);
		om_cust_price_list.setUser_def29(user_def29);
		om_cust_price_list.setUser_def30(user_def30);
		priceListDao.create(om_cust_price_list);
		return "priceListSuccess";
		
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String list() throws Exception{
		System.out.println("---------priceList-----------");
		List<Om_cust_price_list> om_cust_price_Lists = priceListDao.select();
		System.out.println(om_cust_price_Lists);
		ActionContext.getContext().put("om_cust_price_Lists", om_cust_price_Lists);
		/*
		for(Object m : om_special_discount_List){
			System.out.println(m);
		}*/
	
		//System.out.println(om_special_discount_List);

		return "priceListSuccess";
	}
	
	public String toadd(){
		
		return "toAddPriceList";
	}
	public String getPL_YH_ITEM() {
		return PL_YH_ITEM;
	}
	public void setPL_YH_ITEM(String pL_YH_ITEM) {
		PL_YH_ITEM = pL_YH_ITEM;
	}
	public Date getEffective_date_from() {
		return effective_date_from;
	}
	public void setEffective_date_from(Date effective_date_from) {
		this.effective_date_from = effective_date_from;
	}
	public Date getEffective_date_to() {
		return effective_date_to;
	}
	public void setEffective_date_to(Date effective_date_to) {
		this.effective_date_to = effective_date_to;
	}
	public String getUser_def1() {
		return user_def1;
	}
	public void setUser_def1(String user_def1) {
		this.user_def1 = user_def1;
	}
	public String getUser_def2() {
		return user_def2;
	}
	public void setUser_def2(String user_def2) {
		this.user_def2 = user_def2;
	}
	public String getUser_def3() {
		return user_def3;
	}
	public void setUser_def3(String user_def3) {
		this.user_def3 = user_def3;
	}
	public String getUser_def4() {
		return user_def4;
	}
	public void setUser_def4(String user_def4) {
		this.user_def4 = user_def4;
	}
	public String getUser_def5() {
		return user_def5;
	}
	public void setUser_def5(String user_def5) {
		this.user_def5 = user_def5;
	}
	public String getUser_def6() {
		return user_def6;
	}
	public void setUser_def6(String user_def6) {
		this.user_def6 = user_def6;
	}
	public String getUser_def7() {
		return user_def7;
	}
	public void setUser_def7(String user_def7) {
		this.user_def7 = user_def7;
	}
	public String getUser_def8() {
		return user_def8;
	}
	public void setUser_def8(String user_def8) {
		this.user_def8 = user_def8;
	}
	public String getUser_def9() {
		return user_def9;
	}
	public void setUser_def9(String user_def9) {
		this.user_def9 = user_def9;
	}
	public String getUser_def10() {
		return user_def10;
	}
	public void setUser_def10(String user_def10) {
		this.user_def10 = user_def10;
	}
	public String getUser_def11() {
		return user_def11;
	}
	public void setUser_def11(String user_def11) {
		this.user_def11 = user_def11;
	}
	public String getUser_def12() {
		return user_def12;
	}
	public void setUser_def12(String user_def12) {
		this.user_def12 = user_def12;
	}
	public String getUser_def13() {
		return user_def13;
	}
	public void setUser_def13(String user_def13) {
		this.user_def13 = user_def13;
	}
	public String getUser_def14() {
		return user_def14;
	}
	public void setUser_def14(String user_def14) {
		this.user_def14 = user_def14;
	}
	public String getUser_def15() {
		return user_def15;
	}
	public void setUser_def15(String user_def15) {
		this.user_def15 = user_def15;
	}
	public String getUser_def16() {
		return user_def16;
	}
	public void setUser_def16(String user_def16) {
		this.user_def16 = user_def16;
	}
	public String getUser_def17() {
		return user_def17;
	}
	public void setUser_def17(String user_def17) {
		this.user_def17 = user_def17;
	}
	public String getUser_def18() {
		return user_def18;
	}
	public void setUser_def18(String user_def18) {
		this.user_def18 = user_def18;
	}
	public String getUser_def19() {
		return user_def19;
	}
	public void setUser_def19(String user_def19) {
		this.user_def19 = user_def19;
	}
	public String getUser_def20() {
		return user_def20;
	}
	public void setUser_def20(String user_def20) {
		this.user_def20 = user_def20;
	}
	public String getUser_def21() {
		return user_def21;
	}
	public void setUser_def21(String user_def21) {
		this.user_def21 = user_def21;
	}
	public String getUser_def22() {
		return user_def22;
	}
	public void setUser_def22(String user_def22) {
		this.user_def22 = user_def22;
	}
	public String getUser_def23() {
		return user_def23;
	}
	public void setUser_def23(String user_def23) {
		this.user_def23 = user_def23;
	}
	public String getUser_def24() {
		return user_def24;
	}
	public void setUser_def24(String user_def24) {
		this.user_def24 = user_def24;
	}
	public String getUser_def25() {
		return user_def25;
	}
	public void setUser_def25(String user_def25) {
		this.user_def25 = user_def25;
	}
	public String getUser_def26() {
		return user_def26;
	}
	public void setUser_def26(String user_def26) {
		this.user_def26 = user_def26;
	}
	public String getUser_def27() {
		return user_def27;
	}
	public void setUser_def27(String user_def27) {
		this.user_def27 = user_def27;
	}
	public String getUser_def28() {
		return user_def28;
	}
	public void setUser_def28(String user_def28) {
		this.user_def28 = user_def28;
	}
	public String getUser_def29() {
		return user_def29;
	}
	public void setUser_def29(String user_def29) {
		this.user_def29 = user_def29;
	}
	public String getUser_def30() {
		return user_def30;
	}
	public void setUser_def30(String user_def30) {
		this.user_def30 = user_def30;
	}
	
}

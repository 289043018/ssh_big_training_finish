package com.hand.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hand.dao.Om_cust_addressDao;
import com.hand.dao.Om_cust_contactorsDao;
import com.hand.dao.Om_cust_infoDao;
import com.hand.dao.Om_cust_orgDao;
import com.hand.dao.Om_cust_paymentDao;
import com.hand.dao.UserDao;
import com.hand.dao.impl.Om_cust_addressDaoImpl;
import com.hand.model.Om_cust_address;
import com.hand.model.Om_cust_contactors;
import com.hand.model.Om_cust_info;
import com.hand.model.Om_cust_org;
import com.hand.model.Om_cust_payment;
import com.hand.model.Om_normal_discount;
import com.hand.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TextAction extends ActionSupport  {
	private int cust_id;
	private String customer_name;
	private String customer_code;
	private String type;
	private String status;
	private String group_company;
	private String corporation;
	//地址参数
	private int address_id;
	private String country;
	private String port_of_destination;
	private String address1;
	private String address2;
	private String postcode;
	private String shipping_mark;
	private String state;
	private String city;
	private Date inactive_date;

	//付款信息
	private int payment_id;
	private String invoice_group;
	private String markup_name;
	private String currency;
	private String discount_name;
	private String payment_term;
	private String price_term1;
	private String price_term2;
	private String price_term3;

	//组织信息
	private int org_id;
	private String market_area;
	private String bussiness_manager;
	private String bussiness_assistant;

	//联系人信息
	private int cont_id;
	private String mailfrom;
	private String prepr_mailto;
	private String po_mailto;
	private String ocpi_mailto;
	private String inv_pklist_mailto;
	//用户信息
	private int user_id;
	private String user_name;
	private String user_pwd;
	private String ch_name;
	private int staff_id;
	private String en_name;
	private String role;
	private int phone;
	private String email;
	
	private HttpSession httpsession = ServletActionContext.getRequest().getSession(); ;
	
	
	
	
	Om_normal_discount om_normal_discount = new Om_normal_discount();
	
	

	ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-hibernate.xml"});
	Om_cust_infoDao om_cust_infoDao = (Om_cust_infoDao) ac.getBean("om_cust_infoDao");
	Om_cust_addressDao om_cust_addressDao = (Om_cust_addressDao) ac.getBean("om_cust_addressDao");
	Om_cust_orgDao om_cust_orgDao = (Om_cust_orgDao) ac.getBean("om_cust_orgDao");
	Om_cust_contactorsDao om_cust_contactorsDao = (Om_cust_contactorsDao) ac.getBean("om_cust_contactorsDao");
	Om_cust_paymentDao om_cust_paymentDao = (Om_cust_paymentDao) ac.getBean("om_cust_paymentDao");
	User user = (User) ac.getBean("user");
	UserDao userDao = (UserDao) ac.getBean("userDao");
//	Om_cust_info om_cust_info = (Om_cust_info) ac.getBean("om_cust_info");
	Om_cust_info om_cust_info = new Om_cust_info();
	Om_cust_address	om_cust_address = new Om_cust_address();
	Om_cust_contactors	om_cust_contactors = new Om_cust_contactors();
	Om_cust_payment	om_cust_payment = new Om_cust_payment();
	Om_cust_org	om_cust_org = new Om_cust_org();
	
	
	//创建用户
	public String createUser(){
		user.setUser_name(user_name);
		user.setUser_pwd(user_pwd);
		user.setCh_name(ch_name);
		user.setEn_name(en_name);
		user.setStaff_id(staff_id);
		user.setRole(role);
		user.setEmail(email);
		user.setPhone(phone);
		userDao.createUser(user);
		System.out.println("创建用户成功！");
		return "success";
	}
	
	
	//创建用户详细信息
	public String create_customer(){
		//添加地址表
//		System.out.println("地址信息：");
//		System.out.println(country);
//		System.out.println(port_of_destination);
//		System.out.println(address1);
//		System.out.println(address2);
//		System.out.println(postcode);
//		System.out.println(shipping_mark);
		om_cust_address.setCountry(country);
		om_cust_address.setPort_of_destination(port_of_destination);
		om_cust_address.setAddress1(address1);
		om_cust_address.setAddress2(address2);
		om_cust_address.setPostcode(postcode);
		om_cust_address.setShipping_mark(shipping_mark);
		om_cust_address.setStatus(status);
		om_cust_address.setState(state);
		om_cust_address.setCity(city);
		om_cust_address.setInactive_date(inactive_date);
		
		
		om_cust_addressDao.create(om_cust_address);

		//设置用户表的地址对象
		om_cust_info.setAddress(om_cust_address);
		
		//插入组织信息
//		System.out.println("组织信息：");
//		System.out.println(market_area);
//		System.out.println(bussiness_manager);
//		System.out.println(bussiness_assistant);
		om_cust_org.setMarket_area(market_area);
		om_cust_org.setBussiness_manager(bussiness_manager);
		om_cust_org.setBussiness_assistant(bussiness_assistant);
		om_cust_orgDao.create(om_cust_org);
		
		//设置用户表的组织对象
		om_cust_info.setOrg(om_cust_org);
		
		//插入用户信息
//		System.out.println("用户基本信息：");
//		System.out.println(customer_name);
//		System.out.println(customer_code);
//		System.out.println(type);
//		System.out.println(group_company);
//		System.out.println(corporation);
		om_cust_info.setCustomer_name(customer_name);
		om_cust_info.setCustomer_code(customer_code);
		om_cust_info.setType(type);
		om_cust_info.setGroup_company(group_company);
		om_cust_info.setCorporation(corporation);
		int cust_id = om_cust_infoDao.create(om_cust_info);
		
//		System.out.println("付款信息：");
//		System.out.println(invoice_group);
//		System.out.println(markup_name);
//		System.out.println(currency);
//		System.out.println(payment_term);
//		System.out.println(price_term1);
//		System.out.println(price_term2);
//		System.out.println(price_term3);
//		System.out.println(discount_name);
		
		om_cust_payment.setInvoice_group(invoice_group);
		om_cust_payment.setMarkup_name(markup_name);
		om_cust_payment.setCurrency(currency);
		om_cust_payment.setPayment_term(payment_term);
		om_cust_payment.setPrice_term1(price_term1);
		om_cust_payment.setPrice_term2(price_term2);
		om_cust_payment.setPrice_term3(price_term3);
		om_cust_payment.setDiscount_name(discount_name);
		om_cust_payment.setCust_id(cust_id);
		om_cust_paymentDao.create(om_cust_payment);
		

//		System.out.println("联系人信息：");
//		System.out.println(mailfrom);
//		System.out.println(prepr_mailto);
//		System.out.println(po_mailto);
//		System.out.println(ocpi_mailto);
//		System.out.println(inv_pklist_mailto);
		om_cust_contactors.setMailfrom(mailfrom);
		om_cust_contactors.setPrepr_mailto(prepr_mailto);
		om_cust_contactors.setPo_mailto(po_mailto);
		om_cust_contactors.setOcpi_mailto(ocpi_mailto);
		om_cust_contactors.setInv_pklist_mailto(inv_pklist_mailto);
		om_cust_contactors.setCust_id(cust_id);
		om_cust_contactorsDao.create(om_cust_contactors);
		return SUCCESS;
	}

	//按客户确认
	public String doit(){
		om_cust_info = om_cust_infoDao.findById(cust_id);
		System.out.println(om_cust_info.getCustomer_name());
		int id = om_cust_info.getAddress().getAddress_id();
		om_cust_address = om_cust_addressDao.findByID(id);
		om_cust_address.setStatus("确认");
		om_cust_addressDao.update(om_cust_address);
		return "doit";
	}
	
	//模糊查询方法
	public void findByName() throws IOException{
		
//		List<Om_cust_info> om_cust_infoList = om_cust_infoDao.findByName("%"+customer_name+"%");
		List<Om_cust_info> om_cust_infoList = new ArrayList<Om_cust_info>();
		if(!customer_name.isEmpty()){
			om_cust_infoList = om_cust_infoDao.findByName("%"+customer_name+"%");
			ajaxback(om_cust_infoList);
		}else if(!customer_code.isEmpty()){
			om_cust_infoList = om_cust_infoDao.findByCode("%"+customer_code+"%");
			ajaxback(om_cust_infoList);
		}else if(!type.isEmpty()){
			om_cust_infoList = om_cust_infoDao.findByType("%"+type+"%");
			ajaxback(om_cust_infoList);
		}else if(!status.isEmpty()){
			List<Om_cust_address> om_cust_addressList = om_cust_addressDao.findByStatus("%"+status+"%");
			Iterator<Om_cust_address> it = om_cust_addressList.iterator();
			while (it.hasNext()) {
				Om_cust_address om_cust_address =  it.next();
				
				System.out.println("getAddress_id"+om_cust_address.getAddress_id());
				Om_cust_info om_cust_info = om_cust_infoDao.findByAddress(om_cust_address.getAddress_id());
				System.out.println("查找到的："+om_cust_info);
				om_cust_infoList.add(om_cust_info);
				System.out.println("添加："+om_cust_infoList);
			}
			System.out.println("结果集合："+om_cust_infoList);
			ajaxback(om_cust_infoList);
		}else if(!group_company.isEmpty()){
			om_cust_infoList = om_cust_infoDao.findByGroup_company("%"+group_company+"%");
			ajaxback(om_cust_infoList);
			}else{
				om_cust_infoList = om_cust_infoDao.findByCorporation("%"+corporation+"%");
				ajaxback(om_cust_infoList);
			}
	}
	
	//模糊查询返回数据的json数组格式
	public void ajaxback(List<Om_cust_info> om_cust_infoList) throws IOException{
		JsonObject lan = null;
		JsonArray jArray = new JsonArray();
		System.out.println("过滤前的数据："+om_cust_infoList);
		List<Om_cust_info> myList = isMyCustomer(om_cust_infoList);
		System.out.println("过滤后的数据："+myList);
		for(Iterator<Om_cust_info> iterator = myList.iterator();iterator.hasNext();){
			
			om_cust_info =iterator.next();
			System.out.println("开始添加JSON列表");
			lan = new JsonObject();
			lan.addProperty("cust_id", om_cust_info.getCust_id());
			lan.addProperty("customer_name", om_cust_info.getCustomer_name());
			lan.addProperty("customer_code", om_cust_info.getCustomer_code());
			lan.addProperty("Type", om_cust_info.getType());
			lan.addProperty("market_area", om_cust_info.getOrg().getMarket_area());
			lan.addProperty("bussiness_assistant", om_cust_info.getOrg().getBussiness_assistant());
			lan.addProperty("bussiness_manager", om_cust_info.getOrg().getBussiness_manager());
			lan.addProperty("status", om_cust_info.getAddress().getStatus());
			jArray.add(lan);
			System.out.println("添加JSON列表成功");
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		 PrintWriter out = response.getWriter();  
		 out.print(jArray);  
		 System.out.println(jArray);
	        out.flush();  
	        out.close();
//		ActionContext.getContext().put("om_cust_infoList", om_cust_infoList);
	}
	
	public void showdetail() throws IOException{
		System.out.println(cust_id);
		om_cust_info = om_cust_infoDao.findById(cust_id);
		om_cust_contactors = om_cust_contactorsDao.findByCust_id(cust_id);
//		System.out.println(om_cust_contactors);
		om_cust_payment = om_cust_paymentDao.findByCust_id(cust_id);
		System.out.println(om_cust_payment);
		om_cust_address = om_cust_addressDao.findByID(om_cust_info.getAddress().getAddress_id());
		System.out.println(om_cust_address);
		om_cust_org = om_cust_orgDao.findById(om_cust_info.getOrg().getOrg_id());
		System.out.println(om_cust_org);
		JsonObject lan = new JsonObject();
//		JsonArray jArray = new JsonArray();
//		lan = new JsonObject();
		//添加用户数据到json对象
		lan.addProperty("cust_id", om_cust_info.getCust_id());
		lan.addProperty("customer_name", om_cust_info.getCustomer_name());
		lan.addProperty("customer_code", om_cust_info.getCustomer_code());
		lan.addProperty("type", om_cust_info.getType());
		lan.addProperty("group_company", om_cust_info.getGroup_company());
		lan.addProperty("corporation", om_cust_info.getCorporation());
		
		//添加地址信心到json对象
//		("地址信息：")
//		(country)
//		(port_of_destination)
//		(address1)
//		(address2)
//		(postcode)
//		(shipping_mark);
		//所有信息都会返回它的ID
		lan.addProperty("address_id", om_cust_address.getAddress_id());
		lan.addProperty("state", om_cust_address.getState());
		lan.addProperty("city", om_cust_address.getCity());
		lan.addProperty("country", om_cust_address.getCountry());
		lan.addProperty("port_of_destination", om_cust_address.getPort_of_destination());
		lan.addProperty("address1", om_cust_address.getAddress1());
		lan.addProperty("address2", om_cust_address.getAddress2());
		lan.addProperty("postcode", om_cust_address.getPostcode());
		lan.addProperty("shipping_mark", om_cust_address.getShipping_mark());
		lan.addProperty("status", om_cust_address.getStatus());
		String date_str =  om_cust_address.getInactive_date().toString();
		lan.addProperty("inactive_date",date_str);
		
		//添加付款信息到json对象
//		(invoice_group);
//		(markup_name);
//		(currency);
//		(payment_term);
//		(price_term1);
//		(price_term2);
//		(price_term3);
//		(discount_name);
		//所有信息都会返回它的ID
		lan.addProperty("payment_id", om_cust_payment.getPayment_id());
		
		lan.addProperty("invoice_group", om_cust_payment.getInvoice_group());
		lan.addProperty("markup_name", om_cust_payment.getMarkup_name());
		lan.addProperty("currency", om_cust_payment.getCurrency());
		lan.addProperty("payment_term", om_cust_payment.getPayment_term());
		lan.addProperty("price_term1", om_cust_payment.getPrice_term1());
		lan.addProperty("price_term2", om_cust_payment.getPrice_term2());
		lan.addProperty("price_term3", om_cust_payment.getPrice_term3());
		lan.addProperty("discount_name", om_cust_payment.getDiscount_name());
		
		
		//添加组织信息到json对象
//		("组织信息：");
//		(market_area);
//		(bussiness_manager);
//		(bussiness_assistant);
		//所有信息都会返回它的ID
		lan.addProperty("org_id", om_cust_org.getOrg_id());
		
		lan.addProperty("market_area", om_cust_org.getMarket_area());
		lan.addProperty("bussiness_manager", om_cust_org.getBussiness_manager());
		lan.addProperty("bussiness_assistant", om_cust_org.getBussiness_assistant());
		
		
		//添加联系人到json对象
//		(mailfrom);
//		(prepr_mailto);
//		(po_mailto);
//		(ocpi_mailto);
//		(inv_pklist_mailto);
		//所有信息都会返回它的ID
		lan.addProperty("cont_id", om_cust_contactors.getCont_id());
		lan.addProperty("mailfrom", om_cust_contactors.getMailfrom());
		lan.addProperty("prepr_mailto", om_cust_contactors.getPrepr_mailto());
		lan.addProperty("po_mailto", om_cust_contactors.getPo_mailto());
		lan.addProperty("ocpi_mailto", om_cust_contactors.getOcpi_mailto());
		lan.addProperty("inv_pklist_mailto", om_cust_contactors.getInv_pklist_mailto());
		

//		jArray.add(lan);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		 PrintWriter out = response.getWriter();  
		 out.print(lan);  
//		 System.out.println(jArray);
	        out.flush();  
	        out.close();
		
	}
	
	public void updateCust(){
//		System.out.println("用户信息：");
//		System.out.println(cust_id);
//		System.out.println(customer_name);
//		System.out.println(customer_code);
//		System.out.println(type);
//		System.out.println(group_company);
//		System.out.println(corporation);
		om_cust_info = om_cust_infoDao.findById(cust_id);
		om_cust_info.setCustomer_code(customer_code);
		om_cust_info.setCustomer_name(customer_name);
		om_cust_info.setType(type);
		om_cust_info.setGroup_company(group_company);
		om_cust_info.setCorporation(corporation);
		om_cust_infoDao.update(om_cust_info);
		System.out.println("保存成功");
	}
	
	public void updateAddress(){
//		System.out.println("地址信息：");
//		System.out.println(address_id);
//		System.out.println(country);
//		System.out.println(port_of_destination);
//		System.out.println(address1);
//		System.out.println(address2);
//		System.out.println(postcode);
//		System.out.println(shipping_mark);
//		System.out.println(status);
		om_cust_address = om_cust_addressDao.findByID(address_id);
		om_cust_address.setCountry(country);
		om_cust_address.setState(state);
		om_cust_address.setCity(city);
		om_cust_address.setPort_of_destination(port_of_destination);
		om_cust_address.setAddress1(address1);
		om_cust_address.setAddress2(address2);
		om_cust_address.setPostcode(postcode);
		om_cust_address.setShipping_mark(shipping_mark);
		om_cust_address.setStatus(status);
		om_cust_address.setInactive_date(inactive_date);
		om_cust_addressDao.update(om_cust_address);
		System.out.println("保存成功");
		
		
		
		
	
	}
	
	public void updateOrg(){
//		System.out.println("组织信息：");
//		System.out.println(org_id);
//		System.out.println(market_area);
//		System.out.println(bussiness_manager);
//		System.out.println(bussiness_assistant);
		om_cust_org = om_cust_orgDao.findById(org_id);
		om_cust_org.setMarket_area(market_area);
		om_cust_org.setBussiness_manager(bussiness_manager);
		om_cust_org.setBussiness_assistant(bussiness_assistant);
		om_cust_orgDao.update(om_cust_org);
		System.out.println("保存成功");
		
		
	}
	
	public void updatePayment(){
//		System.out.println("付款信息：");
		System.out.println(payment_id);
		System.out.println(invoice_group);
		System.out.println(markup_name);
		System.out.println(currency);
		System.out.println(payment_term);
		System.out.println(price_term1);
		System.out.println(price_term2);
		System.out.println(price_term3);
		System.out.println(discount_name);
		om_cust_payment = om_cust_paymentDao.findById(payment_id);
		om_cust_payment.setInvoice_group(invoice_group);
		om_cust_payment.setMarkup_name(markup_name);
		om_cust_payment.setCurrency(currency);
		om_cust_payment.setPayment_term(payment_term);
		om_cust_payment.setPrice_term1(price_term1);
		om_cust_payment.setPrice_term2(price_term2);
		om_cust_payment.setPrice_term3(price_term3);
		om_cust_payment.setDiscount_name(discount_name);
		om_cust_paymentDao.update(om_cust_payment);
		System.out.println("保存成功");
		
		
		
	}
	
	public void updateCont(){
//		System.out.println("联系人信息：");
//		System.out.println(cont_id);
//		System.out.println(mailfrom);
//		System.out.println(prepr_mailto);
//		System.out.println(po_mailto);
//		System.out.println(ocpi_mailto);
//		System.out.println(inv_pklist_mailto);
		om_cust_contactors = om_cust_contactorsDao.findById(cont_id);
		om_cust_contactors.setMailfrom(mailfrom);
		om_cust_contactors.setPrepr_mailto(prepr_mailto);
		om_cust_contactors.setPo_mailto(po_mailto);
		om_cust_contactors.setOcpi_mailto(ocpi_mailto);
		om_cust_contactors.setInv_pklist_mailto(inv_pklist_mailto);
		om_cust_contactorsDao.update(om_cust_contactors);
		System.out.println("保存成功");
	}
	
	public List<Om_cust_info> isMyCustomer(List<Om_cust_info> list){
		String role = (String) httpsession.getAttribute("role");
		System.out.println(role);
		List<Om_cust_info> listReturn = new ArrayList<Om_cust_info>();
		if(role.equals("财务人员")){
			listReturn = list;
		}else if(role.equals("业务经理")){
			Iterator<Om_cust_info> iterator = list.iterator();
			while(iterator.hasNext()){
				Om_cust_info om_cust_info = iterator.next();
				String str = om_cust_info.getOrg().getBussiness_manager();
				System.out.println("该用户的客户业务经理为："+str);
				String str2 = (String) httpsession.getAttribute("ch_name"); 
				System.out.println("当前用户为："+str2);
				if(str.equals(str2)){
					System.out.println("您有权限查看该客户！");
					listReturn.add(om_cust_info);
				}
			}
			return listReturn;
		}else if(role.equals("业务员")){
			Iterator<Om_cust_info> iterator = list.iterator();
			while(iterator.hasNext()){
				Om_cust_info om_cust_info = iterator.next();
				String str = om_cust_info.getOrg().getBussiness_assistant();
				System.out.println("该用户的客户业务员为："+str);
				String str2 = (String) httpsession.getAttribute("ch_name"); 
				System.out.println("当前用户为："+str2);
				if(str.equals(str2)){
					System.out.println("您有权限查看该客户！");
					listReturn.add(om_cust_info);
				}
			}
			return listReturn;
		}
		return listReturn;
		
	}
	
	
	
//	public void create(){
//		om_cust_info.setCustomer_code("HZL");
//		om_cust_info.setCustomer_name("huangziliang");
//		om_cust_info.setType("STD");
//		om_cust_info.setGroup_company("hand");
//		om_cust_info.setCorporation("hand");
////		om_cust_info.setOrg(om_cust_org);
////		om_cust_info.setDiscount(om_normal_discount);
//		 System.out.println("开始插入");
//		 om_cust_infoDao.create(om_cust_info);
//		 System.out.println("结束插入");
//	}

	
	public String toshowdetail(){
		return "for_showdetail";
	}
	
	public String toupdatedetail(){
		return "for_updatedetail";
	}
	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_code() {
		return customer_code;
	}

	public void setCustomer_code(String customer_code) {
		this.customer_code = customer_code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGroup_company() {
		return group_company;
	}

	public void setGroup_company(String group_company) {
		this.group_company = group_company;
	}

	public String getCorporation() {
		return corporation;
	}

	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPort_of_destination() {
		return port_of_destination;
	}

	public void setPort_of_destination(String port_of_destination) {
		this.port_of_destination = port_of_destination;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getShipping_mark() {
		return shipping_mark;
	}

	public void setShipping_mark(String shipping_mark) {
		this.shipping_mark = shipping_mark;
	}

	public String getInvoice_group() {
		return invoice_group;
	}

	public void setInvoice_group(String invoice_group) {
		this.invoice_group = invoice_group;
	}

	public String getMarkup_name() {
		return markup_name;
	}

	public void setMarkup_name(String markup_name) {
		this.markup_name = markup_name;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDiscount_name() {
		return discount_name;
	}

	public void setDiscount_name(String discount_name) {
		this.discount_name = discount_name;
	}

	public String getPayment_term() {
		return payment_term;
	}

	public void setPayment_term(String payment_term) {
		this.payment_term = payment_term;
	}

	public String getPrice_term1() {
		return price_term1;
	}

	public void setPrice_term1(String price_term1) {
		this.price_term1 = price_term1;
	}

	public String getPrice_term2() {
		return price_term2;
	}

	public void setPrice_term2(String price_term2) {
		this.price_term2 = price_term2;
	}

	public String getPrice_term3() {
		return price_term3;
	}

	public void setPrice_term3(String price_term3) {
		this.price_term3 = price_term3;
	}

	public String getMarket_area() {
		return market_area;
	}

	public void setMarket_area(String market_area) {
		this.market_area = market_area;
	}

	public String getBussiness_manager() {
		return bussiness_manager;
	}

	public void setBussiness_manager(String bussiness_manager) {
		this.bussiness_manager = bussiness_manager;
	}

	public String getBussiness_assistant() {
		return bussiness_assistant;
	}

	public void setBussiness_assistant(String bussiness_assistant) {
		this.bussiness_assistant = bussiness_assistant;
	}

	public String getMailfrom() {
		return mailfrom;
	}

	public void setMailfrom(String mailfrom) {
		this.mailfrom = mailfrom;
	}

	public String getPrepr_mailto() {
		return prepr_mailto;
	}

	public void setPrepr_mailto(String prepr_mailto) {
		this.prepr_mailto = prepr_mailto;
	}

	public String getPo_mailto() {
		return po_mailto;
	}

	public void setPo_mailto(String po_mailto) {
		this.po_mailto = po_mailto;
	}

	public String getOcpi_mailto() {
		return ocpi_mailto;
	}

	public void setOcpi_mailto(String ocpi_mailto) {
		this.ocpi_mailto = ocpi_mailto;
	}

	public String getInv_pklist_mailto() {
		return inv_pklist_mailto;
	}

	public void setInv_pklist_mailto(String inv_pklist_mailto) {
		this.inv_pklist_mailto = inv_pklist_mailto;
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public int getOrg_id() {
		return org_id;
	}

	public void setOrg_id(int org_id) {
		this.org_id = org_id;
	}

	public int getCont_id() {
		return cont_id;
	}

	public void setCont_id(int cont_id) {
		this.cont_id = cont_id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getInactive_date() {
		return inactive_date;
	}

	public void setInactive_date(Date inactive_date) {
		this.inactive_date = inactive_date;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public String getCh_name() {
		return ch_name;
	}

	public void setCh_name(String ch_name) {
		this.ch_name = ch_name;
	}

	public int getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}

	public String getEn_name() {
		return en_name;
	}

	public void setEn_name(String en_name) {
		this.en_name = en_name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}

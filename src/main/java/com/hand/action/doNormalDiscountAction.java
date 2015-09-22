package com.hand.action;

import java.sql.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hand.dao.DiscountBaseDao;
import com.hand.dao.DiscountTypeDao;
import com.hand.dao.NormalDiscountDao;
import com.hand.model.Address;
import com.hand.model.Discount_base;
import com.hand.model.Discount_type;
import com.hand.model.Om_normal_discount;
import com.hand.model.Om_special_discount;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class doNormalDiscountAction extends ActionSupport{
	private String discount_name;
	private Discount_type discount_type;
	private Discount_base discount_base;
	
	private int base_qty;
	private float discount_rate;
	private String activity;
	private int delet_id;
	private Date activity_date_from;
	private Date activity_date_to;
	private int id;
	private int type_id;
	private int pagenum = 1;
	private String  discount_type1;
	private String discount_base1;
	private String search;
	private String search1;
	ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-hibernate.xml"});
	NormalDiscountDao normaldiscountDao = (NormalDiscountDao)ac.getBean("normaldiscountDao");
	Om_normal_discount om_normal_discount = (Om_normal_discount)ac.getBean("om_normal_discount");
	DiscountTypeDao  discountTypeDao = (DiscountTypeDao)ac.getBean("discountTypeDao");
	DiscountBaseDao discountBaseDao = (DiscountBaseDao)ac.getBean("discountBaseDao");
	
	
	public String add() throws Exception{
		System.out.println("-------------add------------------");
		//Date date = new Date();
		//Timestamp time=new Timestamp (date.getTime());
		discount_base = discountBaseDao.findById(id);
		discount_type = discountTypeDao.findById(type_id);
		discount_type1 = discount_type.getType();
		discount_base1 = discount_base.getDiscount_base();
		
	
		//discount_base1=discount_base.getDiscount_base();
		//System.out.println("-----------1-------------");
		//System.out.println(discount_base);
		
		om_normal_discount.setDiscount_name(discount_name);
		om_normal_discount.setDiscount_type(discount_type);
		
		om_normal_discount.setDiscount_type1(discount_type1);
		om_normal_discount.setDiscount_base1(discount_base1);
		
		om_normal_discount.setDiscount_base(discount_base);
		om_normal_discount.setBase_qty(base_qty);
		om_normal_discount.setDiscount_rate(discount_rate);
		om_normal_discount.setActivity(activity);
		om_normal_discount.setActivity_date_from(activity_date_from);
		om_normal_discount.setActivity_date_to(activity_date_to);
		//System.out.println("------------------2-----------------");
		System.out.println(discount_type1);
		System.out.println(om_normal_discount);
		normaldiscountDao.create(om_normal_discount);
		
		return "to_normalDiscountList";
		
	}
	public String update() throws Exception{
		discount_base = discountBaseDao.findById(id);
		discount_type = discountTypeDao.findById(type_id);
		discount_type1 = discount_type.getType();
		discount_base1 = discount_base.getDiscount_base();
		normaldiscountDao.update(delet_id, discount_name, discount_base1,discount_type1, base_qty, discount_rate);
		return "to_normalDiscountList";
	}
	/*
	public String search()throws Exception{
		System.out.println("---------查找----------");
		List<Om_special_discount> om_special_dicount_Lis = specialdiscountDao.findByName(discount_name);
		ActionContext.getContext().put("om_special_dicount_Lis", om_special_dicount_Lis);
		return SUCCESS;
	}*/
	public String list() throws Exception{
		System.out.println("---------list-----------");
		//System.out.println(search);
		//System.out.println(getSearch());
		search = getSearch();
		List<Om_normal_discount> om_normal_discount_List = null;
		if(search!=null || search1!=null){
			return query();
		}else{
			 om_normal_discount_List = normaldiscountDao.select();
				ActionContext.getContext().put("om_normal_discount_List", om_normal_discount_List);
				
				List<Discount_base> discountbaseList = discountBaseDao.select();
				ActionContext.getContext().put("discountbaseList", discountbaseList);
				
				List<Discount_type> discounttypeList = discountTypeDao.select();
				ActionContext.getContext().put("discounttypeList", discounttypeList);
				return "to_normalDiscountList";
		}
		/*
		for(Object m : om_normal_discount_List){
			System.out.println(m);
		}*/
	
		//System.out.println(om_normal_discount_List);
		
		
	}
	public String query() throws Exception{
		search = getSearch();
		search1 = getSearch1();
		System.out.println("--------query------"+search);
		List<Om_normal_discount> om_normal_discount_List = null;
		 om_normal_discount_List = normaldiscountDao.findByName(search,search1);
		 ActionContext.getContext().put("om_normal_discount_List", om_normal_discount_List);
			
			List<Discount_base> discountbaseList = discountBaseDao.select();
			ActionContext.getContext().put("discountbaseList", discountbaseList);
			
			List<Discount_type> discounttypeList = discountTypeDao.select();
			ActionContext.getContext().put("discounttypeList", discounttypeList);
		
		return "query";
	}
	public String toupdate(){
		 List<Discount_base> discountbaseList = discountBaseDao.select();
			ActionContext.getContext().put("discountbaseList", discountbaseList);
		
				List<Discount_type> discounttypeList = discountTypeDao.select();
				ActionContext.getContext().put("discounttypeList", discounttypeList);
			
		Om_normal_discount om_normal_discount = normaldiscountDao.find(delet_id);
		ActionContext.getContext().put("om_normal_discount", om_normal_discount);
		return "toupdate";
	}
	
	public String toadd(){
		/* 获取types列表 */
		 List<Discount_type> discounttypeList = discountTypeDao.select();
		ActionContext.getContext().put("discounttypeList", discounttypeList);
		/* 获取discount_base列表 */
		 List<Discount_base> discountbaseList = discountBaseDao.select();
			ActionContext.getContext().put("discountbaseList", discountbaseList);
		return "toadd1";
	}
	
	
	public String getDiscount_name() {
		return discount_name;
	}
	public void setDiscount_name(String discount_name) {
		this.discount_name = discount_name;
	}
	
	
	
	public Discount_type getDiscount_type() {
		return discount_type;
	}
	public void setDiscount_type(Discount_type discount_type) {
		this.discount_type = discount_type;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public Discount_base getDiscount_base() {
		return discount_base;
	}
	public void setDiscount_base(Discount_base discount_base) {
		this.discount_base = discount_base;
	}
	public int getBase_qty() {
		return base_qty;
	}
	public void setBase_qty(int base_qty) {
		this.base_qty = base_qty;
	}
	public float getDiscount_rate() {
		return discount_rate;
	}
	public void setDiscount_rate(float discount_rate) {
		this.discount_rate = discount_rate;
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
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDiscount_type1() {
		return discount_type1;
	}
	public void setDiscount_type1(String discount_type1) {
		this.discount_type1 = discount_type1;
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

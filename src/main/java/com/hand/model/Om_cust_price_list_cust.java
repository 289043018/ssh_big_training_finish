package com.hand.model;

import java.security.Timestamp;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;


@Repository
@Entity
@Table(name="om_cust_price_list_cust")
public class Om_cust_price_list_cust {
	private int id;
	private int cust_id;
	private String cust_name;
	private String type;
	private String YH_item;
	private Timestamp effective_date_form;
	private Timestamp effective_date_to;
	private String SEGMENT1;
	private String SEGMENT2;
	private String SEGMENT3;
	private String SEGMENT4;
	private String SEGMENT5;
	private String SEGMENT6;
	private String SEGMENT7;
	private String SEGMENT8;
	private String SEGMENT9;
	private String SEGMENT10;
	private String SEGMENT11;
	private String SEGMENT12;
	private String SEGMENT13;
	private String SEGMENT14;
	private String SEGMENT15;
	private String SEGMENT16;
	private String SEGMENT17;
	private String SEGMENT18;
	private String SEGMENT19;
	private String SEGMENT20;
	private String SEGMENT21;
	private String SEGMENT22;
	private String SEGMENT23;
	private String SEGMENT24;
	private String SEGMENT25;
	private String SEGMENT26;
	private String SEGMENT27;
	private String SEGMENT28;
	private String SEGMENT29;
	private String SEGMENT30;
	private String SEGMENT31;
	private String SEGMENT32;
	private String SEGMENT33;
	private String SEGMENT34;
	private String SEGMENT35;
	private String SEGMENT36;
	private String SEGMENT37;
	private String SEGMENT38;
	private String SEGMENT39;
	private String SEGMENT40;
	private String SEGMENT41;
	private String SEGMENT42;
	private String SEGMENT43;
	private String SEGMENT44;
	private String SEGMENT45;
	private String SEGMENT46;
	private String SEGMENT47;
	private String SEGMENT48;
	private String SEGMENT49;
	private String SEGMENT50;
	public Om_cust_price_list_cust() {
	}
	public Om_cust_price_list_cust(int id, int cust_id, String cust_name, String type, String yH_item,
			Timestamp effective_date_form, Timestamp effective_date_to, String sEGMENT1, String sEGMENT2, String sEGMENT3,
			String sEGMENT4, String sEGMENT5, String sEGMENT6, String sEGMENT7, String sEGMENT8, String sEGMENT9,
			String sEGMENT10, String sEGMENT11, String sEGMENT12, String sEGMENT13, String sEGMENT14, String sEGMENT15,
			String sEGMENT16, String sEGMENT17, String sEGMENT18, String sEGMENT19, String sEGMENT20, String sEGMENT21,
			String sEGMENT22, String sEGMENT23, String sEGMENT24, String sEGMENT25, String sEGMENT26, String sEGMENT27,
			String sEGMENT28, String sEGMENT29, String sEGMENT30, String sEGMENT31, String sEGMENT32, String sEGMENT33,
			String sEGMENT34, String sEGMENT35, String sEGMENT36, String sEGMENT37, String sEGMENT38, String sEGMENT39,
			String sEGMENT40, String sEGMENT41, String sEGMENT42, String sEGMENT43, String sEGMENT44, String sEGMENT45,
			String sEGMENT46, String sEGMENT47, String sEGMENT48, String sEGMENT49, String sEGMENT50) {
		super();
		this.id = id;
		this.cust_id = cust_id;
		this.cust_name = cust_name;
		this.type = type;
		YH_item = yH_item;
		this.effective_date_form = effective_date_form;
		this.effective_date_to = effective_date_to;
		SEGMENT1 = sEGMENT1;
		SEGMENT2 = sEGMENT2;
		SEGMENT3 = sEGMENT3;
		SEGMENT4 = sEGMENT4;
		SEGMENT5 = sEGMENT5;
		SEGMENT6 = sEGMENT6;
		SEGMENT7 = sEGMENT7;
		SEGMENT8 = sEGMENT8;
		SEGMENT9 = sEGMENT9;
		SEGMENT10 = sEGMENT10;
		SEGMENT11 = sEGMENT11;
		SEGMENT12 = sEGMENT12;
		SEGMENT13 = sEGMENT13;
		SEGMENT14 = sEGMENT14;
		SEGMENT15 = sEGMENT15;
		SEGMENT16 = sEGMENT16;
		SEGMENT17 = sEGMENT17;
		SEGMENT18 = sEGMENT18;
		SEGMENT19 = sEGMENT19;
		SEGMENT20 = sEGMENT20;
		SEGMENT21 = sEGMENT21;
		SEGMENT22 = sEGMENT22;
		SEGMENT23 = sEGMENT23;
		SEGMENT24 = sEGMENT24;
		SEGMENT25 = sEGMENT25;
		SEGMENT26 = sEGMENT26;
		SEGMENT27 = sEGMENT27;
		SEGMENT28 = sEGMENT28;
		SEGMENT29 = sEGMENT29;
		SEGMENT30 = sEGMENT30;
		SEGMENT31 = sEGMENT31;
		SEGMENT32 = sEGMENT32;
		SEGMENT33 = sEGMENT33;
		SEGMENT34 = sEGMENT34;
		SEGMENT35 = sEGMENT35;
		SEGMENT36 = sEGMENT36;
		SEGMENT37 = sEGMENT37;
		SEGMENT38 = sEGMENT38;
		SEGMENT39 = sEGMENT39;
		SEGMENT40 = sEGMENT40;
		SEGMENT41 = sEGMENT41;
		SEGMENT42 = sEGMENT42;
		SEGMENT43 = sEGMENT43;
		SEGMENT44 = sEGMENT44;
		SEGMENT45 = sEGMENT45;
		SEGMENT46 = sEGMENT46;
		SEGMENT47 = sEGMENT47;
		SEGMENT48 = sEGMENT48;
		SEGMENT49 = sEGMENT49;
		SEGMENT50 = sEGMENT50;
	}
	
	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO) 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="cust_id")
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	
	@Column(name="Cust_name")
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	
	@Column(name="type")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name="YH_item")
	public String getYH_item() {
		return YH_item;
	}
	public void setYH_item(String yH_item) {
		YH_item = yH_item;
	}
	
	@Column(name="Effective_date_form",columnDefinition="Timestamp")
	public Timestamp getEffective_date_form() {
		return effective_date_form;
	}
	public void setEffective_date_form(Timestamp effective_date_form) {
		this.effective_date_form = effective_date_form;
	}
	
	@Column(name="Effective_date_to",columnDefinition="Timestamp")
	public Timestamp getEffective_date_to() {
		return effective_date_to;
	}
	public void setEffective_date_to(Timestamp effective_date_to) {
		this.effective_date_to = effective_date_to;
	}
	
	@Column(name="SEGMENT1")
	public String getSEGMENT1() {
		return SEGMENT1;
	}
	public void setSEGMENT1(String sEGMENT1) {
		SEGMENT1 = sEGMENT1;
	}
	
	@Column(name="SEGMENT2")
	public String getSEGMENT2() {
		return SEGMENT2;
	}
	public void setSEGMENT2(String sEGMENT2) {
		SEGMENT2 = sEGMENT2;
	}
	
	@Column(name="SEGMENT3")
	public String getSEGMENT3() {
		return SEGMENT3;
	}
	public void setSEGMENT3(String sEGMENT3) {
		SEGMENT3 = sEGMENT3;
	}
	
	@Column(name="SEGMENT4")
	public String getSEGMENT4() {
		return SEGMENT4;
	}
	public void setSEGMENT4(String sEGMENT4) {
		SEGMENT4 = sEGMENT4;
	}
	
	@Column(name="SEGMENT5")
	public String getSEGMENT5() {
		return SEGMENT5;
	}
	public void setSEGMENT5(String sEGMENT5) {
		SEGMENT5 = sEGMENT5;
	}
	
	@Column(name="SEGMENT6")
	public String getSEGMENT6() {
		return SEGMENT6;
	}
	public void setSEGMENT6(String sEGMENT6) {
		SEGMENT6 = sEGMENT6;
	}
	
	@Column(name="SEGMENT7")
	public String getSEGMENT7() {
		return SEGMENT7;
	}
	public void setSEGMENT7(String sEGMENT7) {
		SEGMENT7 = sEGMENT7;
	}
	
	@Column(name="SEGMENT8")
	public String getSEGMENT8() {
		return SEGMENT8;
	}
	public void setSEGMENT8(String sEGMENT8) {
		SEGMENT8 = sEGMENT8;
	}
	
	@Column(name="SEGMENT9")
	public String getSEGMENT9() {
		return SEGMENT9;
	}
	public void setSEGMENT9(String sEGMENT9) {
		SEGMENT9 = sEGMENT9;
	}
	
	@Column(name="SEGMENT10")
	public String getSEGMENT10() {
		return SEGMENT10;
	}
	public void setSEGMENT10(String sEGMENT10) {
		SEGMENT10 = sEGMENT10;
	}
	
	@Column(name="SEGMENT11")
	public String getSEGMENT11() {
		return SEGMENT11;
	}
	public void setSEGMENT11(String sEGMENT11) {
		SEGMENT11 = sEGMENT11;
	}
	
	@Column(name="SEGMENT12")
	public String getSEGMENT12() {
		return SEGMENT12;
	}
	public void setSEGMENT12(String sEGMENT12) {
		SEGMENT12 = sEGMENT12;
	}
	
	@Column(name="SEGMENT13")
	public String getSEGMENT13() {
		return SEGMENT13;
	}
	public void setSEGMENT13(String sEGMENT13) {
		SEGMENT13 = sEGMENT13;
	}
	
	@Column(name="SEGMENT14")
	public String getSEGMENT14() {
		return SEGMENT14;
	}
	public void setSEGMENT14(String sEGMENT14) {
		SEGMENT14 = sEGMENT14;
	}
	
	@Column(name="SEGMENT15")
	public String getSEGMENT15() {
		return SEGMENT15;
	}
	public void setSEGMENT15(String sEGMENT15) {
		SEGMENT15 = sEGMENT15;
	}
	
	@Column(name="SEGMENT16")
	public String getSEGMENT16() {
		return SEGMENT16;
	}
	public void setSEGMENT16(String sEGMENT16) {
		SEGMENT16 = sEGMENT16;
	}
	
	@Column(name="SEGMENT17")
	public String getSEGMENT17() {
		return SEGMENT17;
	}
	public void setSEGMENT17(String sEGMENT17) {
		SEGMENT17 = sEGMENT17;
	}
	
	@Column(name="SEGMENT18")
	public String getSEGMENT18() {
		return SEGMENT18;
	}
	public void setSEGMENT18(String sEGMENT18) {
		SEGMENT18 = sEGMENT18;
	}
	
	@Column(name="SEGMENT19")
	public String getSEGMENT19() {
		return SEGMENT19;
	}
	public void setSEGMENT19(String sEGMENT19) {
		SEGMENT19 = sEGMENT19;
	}
	
	@Column(name="SEGMENT20")
	public String getSEGMENT20() {
		return SEGMENT20;
	}
	public void setSEGMENT20(String sEGMENT20) {
		SEGMENT20 = sEGMENT20;
	}
	
	@Column(name="SEGMENT21")
	public String getSEGMENT21() {
		return SEGMENT21;
	}
	public void setSEGMENT21(String sEGMENT21) {
		SEGMENT21 = sEGMENT21;
	}
	
	@Column(name="SEGMENT22")
	public String getSEGMENT22() {
		return SEGMENT22;
	}
	public void setSEGMENT22(String sEGMENT22) {
		SEGMENT22 = sEGMENT22;
	}
	
	@Column(name="SEGMENT23")
	public String getSEGMENT23() {
		return SEGMENT23;
	}
	public void setSEGMENT23(String sEGMENT23) {
		SEGMENT23 = sEGMENT23;
	}
	
	@Column(name="SEGMENT24")
	public String getSEGMENT24() {
		return SEGMENT24;
	}
	public void setSEGMENT24(String sEGMENT24) {
		SEGMENT24 = sEGMENT24;
	}
	
	@Column(name="SEGMENT25")
	public String getSEGMENT25() {
		return SEGMENT25;
	}
	public void setSEGMENT25(String sEGMENT25) {
		SEGMENT25 = sEGMENT25;
	}
	
	@Column(name="SEGMENT26")
	public String getSEGMENT26() {
		return SEGMENT26;
	}
	public void setSEGMENT26(String sEGMENT26) {
		SEGMENT26 = sEGMENT26;
	}
	
	@Column(name="SEGMENT27")
	public String getSEGMENT27() {
		return SEGMENT27;
	}
	public void setSEGMENT27(String sEGMENT27) {
		SEGMENT27 = sEGMENT27;
	}
	
	@Column(name="SEGMENT28")
	public String getSEGMENT28() {
		return SEGMENT28;
	}
	public void setSEGMENT28(String sEGMENT28) {
		SEGMENT28 = sEGMENT28;
	}
	
	@Column(name="SEGMENT29")
	public String getSEGMENT29() {
		return SEGMENT29;
	}
	public void setSEGMENT29(String sEGMENT29) {
		SEGMENT29 = sEGMENT29;
	}
	
	@Column(name="SEGMENT30")
	public String getSEGMENT30() {
		return SEGMENT30;
	}
	public void setSEGMENT30(String sEGMENT30) {
		SEGMENT30 = sEGMENT30;
	}
	
	@Column(name="SEGMENT31")
	public String getSEGMENT31() {
		return SEGMENT31;
	}
	public void setSEGMENT31(String sEGMENT31) {
		SEGMENT31 = sEGMENT31;
	}
	
	@Column(name="SEGMENT32")
	public String getSEGMENT32() {
		return SEGMENT32;
	}
	public void setSEGMENT32(String sEGMENT32) {
		SEGMENT32 = sEGMENT32;
	}
	
	@Column(name="SEGMENT33")
	public String getSEGMENT33() {
		return SEGMENT33;
	}
	public void setSEGMENT33(String sEGMENT33) {
		SEGMENT33 = sEGMENT33;
	}
	
	@Column(name="SEGMENT34")
	public String getSEGMENT34() {
		return SEGMENT34;
	}
	public void setSEGMENT34(String sEGMENT34) {
		SEGMENT34 = sEGMENT34;
	}
	
	@Column(name="SEGMENT35")
	public String getSEGMENT35() {
		return SEGMENT35;
	}
	public void setSEGMENT35(String sEGMENT35) {
		SEGMENT35 = sEGMENT35;
	}
	
	@Column(name="SEGMENT36")
	public String getSEGMENT36() {
		return SEGMENT36;
	}
	public void setSEGMENT36(String sEGMENT36) {
		SEGMENT36 = sEGMENT36;
	}
	
	@Column(name="SEGMENT37")
	public String getSEGMENT37() {
		return SEGMENT37;
	}
	public void setSEGMENT37(String sEGMENT37) {
		SEGMENT37 = sEGMENT37;
	}
	
	@Column(name="SEGMENT38")
	public String getSEGMENT38() {
		return SEGMENT38;
	}
	public void setSEGMENT38(String sEGMENT38) {
		SEGMENT38 = sEGMENT38;
	}
	
	@Column(name="SEGMENT39")
	public String getSEGMENT39() {
		return SEGMENT39;
	}
	public void setSEGMENT39(String sEGMENT39) {
		SEGMENT39 = sEGMENT39;
	}
	
	@Column(name="SEGMENT40")
	public String getSEGMENT40() {
		return SEGMENT40;
	}
	public void setSEGMENT40(String sEGMENT40) {
		SEGMENT40 = sEGMENT40;
	}
	
	@Column(name="SEGMENT41")
	public String getSEGMENT41() {
		return SEGMENT41;
	}
	public void setSEGMENT41(String sEGMENT41) {
		SEGMENT41 = sEGMENT41;
	}
	
	@Column(name="SEGMENT42")
	public String getSEGMENT42() {
		return SEGMENT42;
	}
	public void setSEGMENT42(String sEGMENT42) {
		SEGMENT42 = sEGMENT42;
	}
	
	@Column(name="SEGMENT43")
	public String getSEGMENT43() {
		return SEGMENT43;
	}
	public void setSEGMENT43(String sEGMENT43) {
		SEGMENT43 = sEGMENT43;
	}
	
	@Column(name="SEGMENT44")
	public String getSEGMENT44() {
		return SEGMENT44;
	}
	public void setSEGMENT44(String sEGMENT44) {
		SEGMENT44 = sEGMENT44;
	}
	
	@Column(name="SEGMENT45")
	public String getSEGMENT45() {
		return SEGMENT45;
	}
	public void setSEGMENT45(String sEGMENT45) {
		SEGMENT45 = sEGMENT45;
	}
	
	@Column(name="SEGMENT46")
	public String getSEGMENT46() {
		return SEGMENT46;
	}
	public void setSEGMENT46(String sEGMENT46) {
		SEGMENT46 = sEGMENT46;
	}
	
	@Column(name="SEGMENT47")
	public String getSEGMENT47() {
		return SEGMENT47;
	}
	public void setSEGMENT47(String sEGMENT47) {
		SEGMENT47 = sEGMENT47;
	}
	
	@Column(name="SEGMENT48")
	public String getSEGMENT48() {
		return SEGMENT48;
	}
	public void setSEGMENT48(String sEGMENT48) {
		SEGMENT48 = sEGMENT48;
	}
	
	@Column(name="SEGMENT49")
	public String getSEGMENT49() {
		return SEGMENT49;
	}
	public void setSEGMENT49(String sEGMENT49) {
		SEGMENT49 = sEGMENT49;
	}
	
	@Column(name="SEGMENT50")
	public String getSEGMENT50() {
		return SEGMENT50;
	}
	public void setSEGMENT50(String sEGMENT50) {
		SEGMENT50 = sEGMENT50;
	}
}

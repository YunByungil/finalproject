package joa.pay.model;

import java.util.*;

public class JoaPayDTO {
	
	private int pay_idx;
	private String pay_mem_id;
	private String pay_mem_email;
	private String pay_mem_tel;
	private String pay_pg; 
	private String pay_method; 
	private String pay_pro_name;
	private int pay_price_sum;
	private int pay_discount;
	private int pay_total_price;
	private String merchant_uid;
	private Date pay_date;
	
	public JoaPayDTO() {
		// TODO Auto-generated constructor stub
	}

	public JoaPayDTO(int pay_idx, String pay_mem_id, String pay_mem_email, String pay_mem_tel, String pay_pg,
			String pay_method, String pay_pro_name, int pay_price_sum, int pay_discount, int pay_total_price,
			String merchant_uid, Date pay_date) {
		super();
		this.pay_idx = pay_idx;
		this.pay_mem_id = pay_mem_id;
		this.pay_mem_email = pay_mem_email;
		this.pay_mem_tel = pay_mem_tel;
		this.pay_pg = pay_pg;
		this.pay_method = pay_method;
		this.pay_pro_name = pay_pro_name;
		this.pay_price_sum = pay_price_sum;
		this.pay_discount = pay_discount;
		this.pay_total_price = pay_total_price;
		this.merchant_uid = merchant_uid;
		this.pay_date = pay_date;
	}

	public int getPay_idx() {
		return pay_idx;
	}

	public void setPay_idx(int pay_idx) {
		this.pay_idx = pay_idx;
	}

	public String getPay_mem_id() {
		return pay_mem_id;
	}

	public void setPay_mem_id(String pay_mem_id) {
		this.pay_mem_id = pay_mem_id;
	}

	public String getPay_mem_email() {
		return pay_mem_email;
	}

	public void setPay_mem_email(String pay_mem_email) {
		this.pay_mem_email = pay_mem_email;
	}

	public String getPay_mem_tel() {
		return pay_mem_tel;
	}

	public void setPay_mem_tel(String pay_mem_tel) {
		this.pay_mem_tel = pay_mem_tel;
	}

	public String getPay_pg() {
		return pay_pg;
	}

	public void setPay_pg(String pay_pg) {
		this.pay_pg = pay_pg;
	}

	public String getPay_method() {
		return pay_method;
	}

	public void setPay_method(String pay_method) {
		this.pay_method = pay_method;
	}

	public String getPay_pro_name() {
		return pay_pro_name;
	}

	public void setPay_pro_name(String pay_pro_name) {
		this.pay_pro_name = pay_pro_name;
	}

	public int getPay_price_sum() {
		return pay_price_sum;
	}

	public void setPay_price_sum(int pay_price_sum) {
		this.pay_price_sum = pay_price_sum;
	}

	public int getPay_discount() {
		return pay_discount;
	}

	public void setPay_discount(int pay_discount) {
		this.pay_discount = pay_discount;
	}

	public int getPay_total_price() {
		return pay_total_price;
	}

	public void setPay_total_price(int pay_total_price) {
		this.pay_total_price = pay_total_price;
	}

	public String getMerchant_uid() {
		return merchant_uid;
	}

	public void setMerchant_uid(String merchant_uid) {
		this.merchant_uid = merchant_uid;
	}

	public Date getPay_date() {
		return pay_date;
	}

	public void setPay_date(Date pay_date) {
		this.pay_date = pay_date;
	}
	
	

}

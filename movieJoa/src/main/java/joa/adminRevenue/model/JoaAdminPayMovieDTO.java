package joa.adminRevenue.model;

import java.sql.Date;

public class JoaAdminPayMovieDTO {
	
	private int payMov_idx;
	private String payMov_mem_id;
	private String payMov_mem_email;
	private String payMov_mem_tel;
	private String payMov_pg;
	private String payMov_method;
	private String payMov_mov_title;
	private int payMov_price_sum;
	private int payMov_discount;
	private int payMov_total_price;
	private String payMov_merchant_uid;
	private Date payMov_date;
	
	public JoaAdminPayMovieDTO() {
		// TODO Auto-generated constructor stub
	}

	public JoaAdminPayMovieDTO(int payMov_idx, String payMov_mem_id, String payMov_mem_email, String payMov_mem_tel,
			String payMov_pg, String payMov_method, String payMov_mov_title, int payMov_price_sum, int payMov_discount,
			int payMov_total_price, String payMov_merchant_uid, Date payMov_date) {
		super();
		this.payMov_idx = payMov_idx;
		this.payMov_mem_id = payMov_mem_id;
		this.payMov_mem_email = payMov_mem_email;
		this.payMov_mem_tel = payMov_mem_tel;
		this.payMov_pg = payMov_pg;
		this.payMov_method = payMov_method;
		this.payMov_mov_title = payMov_mov_title;
		this.payMov_price_sum = payMov_price_sum;
		this.payMov_discount = payMov_discount;
		this.payMov_total_price = payMov_total_price;
		this.payMov_merchant_uid = payMov_merchant_uid;
		this.payMov_date = payMov_date;
	}

	public int getPayMov_idx() {
		return payMov_idx;
	}

	public void setPayMov_idx(int payMov_idx) {
		this.payMov_idx = payMov_idx;
	}

	public String getPayMov_mem_id() {
		return payMov_mem_id;
	}

	public void setPayMov_mem_id(String payMov_mem_id) {
		this.payMov_mem_id = payMov_mem_id;
	}

	public String getPayMov_mem_email() {
		return payMov_mem_email;
	}

	public void setPayMov_mem_email(String payMov_mem_email) {
		this.payMov_mem_email = payMov_mem_email;
	}

	public String getPayMov_mem_tel() {
		return payMov_mem_tel;
	}

	public void setPayMov_mem_tel(String payMov_mem_tel) {
		this.payMov_mem_tel = payMov_mem_tel;
	}

	public String getPayMov_pg() {
		return payMov_pg;
	}

	public void setPayMov_pg(String payMov_pg) {
		this.payMov_pg = payMov_pg;
	}

	public String getPayMov_method() {
		return payMov_method;
	}

	public void setPayMov_method(String payMov_method) {
		this.payMov_method = payMov_method;
	}

	public String getPayMov_mov_title() {
		return payMov_mov_title;
	}

	public void setPayMov_mov_title(String payMov_mov_title) {
		this.payMov_mov_title = payMov_mov_title;
	}

	public int getPayMov_price_sum() {
		return payMov_price_sum;
	}

	public void setPayMov_price_sum(int payMov_price_sum) {
		this.payMov_price_sum = payMov_price_sum;
	}

	public int getPayMov_discount() {
		return payMov_discount;
	}

	public void setPayMov_discount(int payMov_discount) {
		this.payMov_discount = payMov_discount;
	}

	public int getPayMov_total_price() {
		return payMov_total_price;
	}

	public void setPayMov_total_price(int payMov_total_price) {
		this.payMov_total_price = payMov_total_price;
	}

	public String getPayMov_merchant_uid() {
		return payMov_merchant_uid;
	}

	public void setPayMov_merchant_uid(String payMov_merchant_uid) {
		this.payMov_merchant_uid = payMov_merchant_uid;
	}

	public Date getPayMov_date() {
		return payMov_date;
	}

	public void setPayMov_date(Date payMov_date) {
		this.payMov_date = payMov_date;
	}
	
}

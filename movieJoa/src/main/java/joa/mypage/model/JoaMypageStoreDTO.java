package joa.mypage.model;

import java.sql.*;

public class JoaMypageStoreDTO {

	private int prs_idx;
	private String prs_pro_name;
	private int prs_pro_price;
	private String prs_order_idx;
	private String prs_pro_filename;
	private String prs_pro_count;
	private Date prs_date;
	private String prs_mem_id;

	public JoaMypageStoreDTO() {

	}

	public JoaMypageStoreDTO(int prs_idx, String prs_pro_name, int prs_pro_price, String prs_order_idx,
			String prs_pro_filename, String prs_pro_count, Date prs_date, String prs_mem_id) {
		super();
		this.prs_idx = prs_idx;
		this.prs_pro_name = prs_pro_name;
		this.prs_pro_price = prs_pro_price;
		this.prs_order_idx = prs_order_idx;
		this.prs_pro_filename = prs_pro_filename;
		this.prs_pro_count = prs_pro_count;
		this.prs_date = prs_date;
		this.prs_mem_id = prs_mem_id;
	}

	public int getPrs_idx() {
		return prs_idx;
	}

	public void setPrs_idx(int prs_idx) {
		this.prs_idx = prs_idx;
	}

	public String getPrs_pro_name() {
		return prs_pro_name;
	}

	public void setPrs_pro_name(String prs_pro_name) {
		this.prs_pro_name = prs_pro_name;
	}

	public int getPrs_pro_price() {
		return prs_pro_price;
	}

	public void setPrs_pro_price(int prs_pro_price) {
		this.prs_pro_price = prs_pro_price;
	}

	public String getPrs_order_idx() {
		return prs_order_idx;
	}

	public void setPrs_order_idx(String prs_order_idx) {
		this.prs_order_idx = prs_order_idx;
	}

	public String getPrs_pro_filename() {
		return prs_pro_filename;
	}

	public void setPrs_pro_filename(String prs_pro_filename) {
		this.prs_pro_filename = prs_pro_filename;
	}

	public String getPrs_pro_count() {
		return prs_pro_count;
	}

	public void setPrs_pro_count(String prs_pro_count) {
		this.prs_pro_count = prs_pro_count;
	}

	public Date getPrs_date() {
		return prs_date;
	}

	public void setPrs_date(Date prs_date) {
		this.prs_date = prs_date;
	}

	public String getPrs_mem_id() {
		return prs_mem_id;
	}

	public void setPrs_mem_id(String prs_mem_id) {
		this.prs_mem_id = prs_mem_id;
	}

}

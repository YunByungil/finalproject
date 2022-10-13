package joa.adminStore.model;

import java.sql.*;

public class AdminStoreDTO {
	
	private int pro_idx;
	private String pro_name;
	private int pro_price;
	private String pro_category;
	private String pro_filename;
    private String pro_info; 
    private Date pro_date;
    
    public AdminStoreDTO() {

	}

	public AdminStoreDTO(int pro_idx, String pro_name, int pro_price, String pro_category, String pro_filename,
			String pro_info, Date pro_date) {
		super();
		this.pro_idx = pro_idx;
		this.pro_name = pro_name;
		this.pro_price = pro_price;
		this.pro_category = pro_category;
		this.pro_filename = pro_filename;
		this.pro_info = pro_info;
		this.pro_date = pro_date;
	}

	public int getPro_idx() {
		return pro_idx;
	}

	public void setPro_idx(int pro_idx) {
		this.pro_idx = pro_idx;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public int getPro_price() {
		return pro_price;
	}

	public void setPro_price(int pro_price) {
		this.pro_price = pro_price;
	}

	public String getPro_category() {
		return pro_category;
	}

	public void setPro_category(String pro_category) {
		this.pro_category = pro_category;
	}

	public String getPro_filename() {
		return pro_filename;
	}

	public void setPro_filename(String pro_filename) {
		this.pro_filename = pro_filename;
	}

	public String getPro_info() {
		return pro_info;
	}

	public void setPro_info(String pro_info) {
		this.pro_info = pro_info;
	}

	public Date getPro_date() {
		return pro_date;
	}

	public void setPro_date(Date pro_date) {
		this.pro_date = pro_date;
	}
    
    


}

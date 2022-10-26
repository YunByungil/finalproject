package joa.adminOwncou.model;

import java.sql.Date;

public class AdminOwncouDTO {
	
    private int own_idx;
    private String own_name;
    private String own_member_id;
    private int own_discount;
    private String own_issue_date;
    private String own_limit_date;
    private String own_status;
    
	public AdminOwncouDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminOwncouDTO(int own_idx, String own_name, String own_member_id, int own_discount, String own_issue_date,
			String own_limit_date, String own_status) {
		super();
		this.own_idx = own_idx;
		this.own_name = own_name;
		this.own_member_id = own_member_id;
		this.own_discount = own_discount;
		this.own_issue_date = own_issue_date.substring(0,10);
		this.own_limit_date = own_limit_date.substring(0,10);
		this.own_status = own_status;
	}

	public int getOwn_idx() {
		return own_idx;
	}

	public void setOwn_idx(int own_idx) {
		this.own_idx = own_idx;
	}

	public String getOwn_name() {
		return own_name;
	}

	public void setOwn_name(String own_name) {
		this.own_name = own_name;
	}

	public String getOwn_member_id() {
		return own_member_id;
	}

	public void setOwn_member_id(String own_member_id) {
		this.own_member_id = own_member_id;
	}

	public int getOwn_discount() {
		return own_discount;
	}

	public void setOwn_discount(int own_discount) {
		this.own_discount = own_discount;
	}

	public String getOwn_issue_date() {
		return own_issue_date.substring(0,10);
	}

	public void setOwn_issue_date(String own_issue_date) {
		this.own_issue_date = own_issue_date;
	}

	public String getOwn_limit_date() {
		return own_limit_date.substring(0,10);
	}

	public void setOwn_limit_date(String own_limit_date) {
		this.own_limit_date = own_limit_date;
	}

	public String getOwn_status() {
		return own_status;
	}

	public void setOwn_status(String own_status) {
		this.own_status = own_status;
	}

	
    
    

}

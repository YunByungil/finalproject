package joa.mypage.model;

import java.util.*;

public class JoaMypageProfileDTO {
	public JoaMypageProfileDTO() {
		// TODO Auto-generated constructor stub
	}
	private int pro_idx;
	private String pro_id; 
	private String pro_nickname; 
    private String pro_image; 
    private Date pro_createdate;
	public int getPro_idx() {
		return pro_idx;
	}
	public void setPro_idx(int pro_idx) {
		this.pro_idx = pro_idx;
	}
	public String getPro_id() {
		return pro_id;
	}
	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}
	public String getPro_nickname() {
		return pro_nickname;
	}
	public void setPro_nickname(String pro_nickname) {
		this.pro_nickname = pro_nickname;
	}
	public String getPro_image() {
		return pro_image;
	}
	public void setPro_image(String pro_image) {
		this.pro_image = pro_image;
	}
	public Date getPro_createdate() {
		return pro_createdate;
	}
	public void setPro_createdate(Date pro_createdate) {
		this.pro_createdate = pro_createdate;
	}
	public JoaMypageProfileDTO(int pro_idx, String pro_id, String pro_nickname, String pro_image, Date pro_createdate) {
		super();
		this.pro_idx = pro_idx;
		this.pro_id = pro_id;
		this.pro_nickname = pro_nickname;
		this.pro_image = pro_image;
		this.pro_createdate = pro_createdate;
	}
}

package joa.mypage.model;

public class JoaMypageEventDTO {
	
	 int app_idx;
	 int app_event_code;
	 String app_event_subject;
	 String app_member_id;
	 String app_apply_date;
	 int eve_idx;
	 String eve_category;
	 String eve_subject;
	 String eve_main_img;
	 String eve_thumb_img;
	 String eve_start_date;
	 String eve_end_date;
	 
	 public int getEve_idx() {
		return eve_idx;
	}

	public void setEve_idx(int eve_idx) {
		this.eve_idx = eve_idx;
	}

	public String getEve_category() {
		return eve_category;
	}

	public void setEve_category(String eve_category) {
		this.eve_category = eve_category;
	}

	public String getEve_subject() {
		return eve_subject;
	}

	public void setEve_subject(String eve_subject) {
		this.eve_subject = eve_subject;
	}

	public String getEve_main_img() {
		return eve_main_img;
	}

	public void setEve_main_img(String eve_main_img) {
		this.eve_main_img = eve_main_img;
	}

	public String getEve_thumb_img() {
		return eve_thumb_img;
	}

	public void setEve_thumb_img(String eve_thumb_img) {
		this.eve_thumb_img = eve_thumb_img;
	}

	public String getEve_start_date() {
		return eve_start_date;
	}

	public void setEve_start_date(String eve_start_date) {
		this.eve_start_date = eve_start_date;
	}

	public String getEve_end_date() {
		return eve_end_date;
	}

	public void setEve_end_date(String eve_end_date) {
		this.eve_end_date = eve_end_date;
	}

	public JoaMypageEventDTO(int app_idx, int app_event_code, String app_event_subject, String app_member_id,
			String app_apply_date, int eve_idx, String eve_category, String eve_subject, String eve_main_img,
			String eve_thumb_img, String eve_start_date, String eve_end_date) {
		super();
		this.app_idx = app_idx;
		this.app_event_code = app_event_code;
		this.app_event_subject = app_event_subject;
		this.app_member_id = app_member_id;
		this.app_apply_date = app_apply_date;
		this.eve_idx = eve_idx;
		this.eve_category = eve_category;
		this.eve_subject = eve_subject;
		this.eve_main_img = eve_main_img;
		this.eve_thumb_img = eve_thumb_img;
		this.eve_start_date = eve_start_date;
		this.eve_end_date = eve_end_date;
	}

	public JoaMypageEventDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JoaMypageEventDTO(int app_idx, int app_event_code, String app_event_subject, String app_member_id,
			String app_apply_date) {
		super();
		this.app_idx = app_idx;
		this.app_event_code = app_event_code;
		this.app_event_subject = app_event_subject;
		this.app_member_id = app_member_id;
		this.app_apply_date = app_apply_date.substring(0,10);
	}

	public int getApp_idx() {
		return app_idx;
	}

	public void setApp_idx(int app_idx) {
		this.app_idx = app_idx;
	}

	public int getApp_event_code() {
		return app_event_code;
	}

	public void setApp_event_code(int app_event_code) {
		this.app_event_code = app_event_code;
	}

	public String getApp_event_subject() {
		return app_event_subject;
	}

	public void setApp_event_subject(String app_event_subject) {
		this.app_event_subject = app_event_subject;
	}

	public String getApp_member_id() {
		return app_member_id;
	}

	public void setApp_member_id(String app_member_id) {
		this.app_member_id = app_member_id;
	}

	public String getApp_apply_date() {
		return app_apply_date.substring(0,10);
	}

	public void setApp_apply_date(String app_apply_date) {
		this.app_apply_date = app_apply_date;
	}
	 
	 

}

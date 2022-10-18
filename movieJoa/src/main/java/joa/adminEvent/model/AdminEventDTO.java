package joa.adminEvent.model;

public class AdminEventDTO {
	
	 int eve_idx;
	 String eve_category;
	 String eve_subject;
	 String eve_main_img;
	 String eve_thumb_img;
	 String eve_start_date;
	 String eve_end_date;
	 String eve_status;
	
	public AdminEventDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminEventDTO(int eve_idx, String eve_category, String eve_subject, String eve_main_img,
			String eve_thumb_img, String eve_start_date, String eve_end_date, String eve_status) {
		super();
		this.eve_idx = eve_idx;
		this.eve_category = eve_category;
		this.eve_subject = eve_subject;
		this.eve_main_img = eve_main_img;
		this.eve_thumb_img = eve_thumb_img;
		this.eve_start_date = eve_start_date;
		this.eve_end_date = eve_end_date;
		this.eve_status = eve_status;
	}

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

	public String getEve_status() {
		return eve_status;
	}

	public void setEve_status(String eve_status) {
		this.eve_status = eve_status;
	}

	

	

}

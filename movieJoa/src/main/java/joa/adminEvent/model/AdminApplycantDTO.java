package joa.adminEvent.model;

public class AdminApplycantDTO {
	
	 int app_idx;
	 int app_event_code;
	 String app_event_subject;
	 String app_member_id;
	 String app_apply_date;
	 
	 public AdminApplycantDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminApplycantDTO(int app_idx, int app_event_code, String app_event_subject, String app_member_id,
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

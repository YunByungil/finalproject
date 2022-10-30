package joa.adminEvent.model;

public class AdminEventLuckBoardDTO {
	public AdminEventLuckBoardDTO() {
		// TODO Auto-generated constructor stub
	}
	private int e_b_idx;
	private String e_b_subject;
	private String e_b_members;
	private String e_b_content;
	private int e_b_eventcode;
	public int getE_b_idx() {
		return e_b_idx;
	}
	public void setE_b_idx(int e_b_idx) {
		this.e_b_idx = e_b_idx;
	}
	public String getE_b_subject() {
		return e_b_subject;
	}
	public void setE_b_subject(String e_b_subject) {
		this.e_b_subject = e_b_subject;
	}
	public String getE_b_members() {
		return e_b_members;
	}
	public void setE_b_members(String e_b_members) {
		this.e_b_members = e_b_members;
	}
	public String getE_b_content() {
		return e_b_content;
	}
	public void setE_b_content(String e_b_content) {
		this.e_b_content = e_b_content;
	}
	public int getE_b_eventcode() {
		return e_b_eventcode;
	}
	public void setE_b_eventcode(int e_b_eventcode) {
		this.e_b_eventcode = e_b_eventcode;
	}
	public AdminEventLuckBoardDTO(int e_b_idx, String e_b_subject, String e_b_members, String e_b_content,
			int e_b_eventcode) {
		super();
		this.e_b_idx = e_b_idx;
		this.e_b_subject = e_b_subject;
		this.e_b_members = e_b_members;
		this.e_b_content = e_b_content;
		this.e_b_eventcode = e_b_eventcode;
	}
}

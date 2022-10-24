package joa.mypage.model;

import java.sql.Date;

public class JoaMypageMemberDTO {
	
	int MpMember_idx;
	String MpMember_id;
	String MpMember_name;
	String MpMember_pwd;
	String MpMember_age;
	String MpMember_tel;
	String MpMember_email;
	int MpMember_grade;
	int MpMember_point;
	Date MpMember_date;
	
	public JoaMypageMemberDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public int getMpMember_idx() {
		return MpMember_idx;
	}
	public void setMpMember_idx(int mpMember_idx) {
		MpMember_idx = mpMember_idx;
	}
	public String getMpMember_id() {
		return MpMember_id;
	}
	public void setMpMember_id(String mpMember_id) {
		MpMember_id = mpMember_id;
	}
	public String getMpMember_name() {
		return MpMember_name;
	}
	public void setMpMember_name(String mpMember_name) {
		MpMember_name = mpMember_name;
	}
	public String getMpMember_pwd() {
		return MpMember_pwd;
	}
	public void setMpMember_pwd(String mpMember_pwd) {
		MpMember_pwd = mpMember_pwd;
	}
	public String getMpMember_age() {
		return MpMember_age;
	}
	public void setMpMember_age(String mpMember_age) {
		MpMember_age = mpMember_age;
	}
	public String getMpMember_tel() {
		return MpMember_tel;
	}
	public void setMpMember_tel(String mpMember_tel) {
		MpMember_tel = mpMember_tel;
	}
	public String getMpMember_email() {
		return MpMember_email;
	}
	public void setMpMember_email(String mpMember_email) {
		MpMember_email = mpMember_email;
	}
	public int getMpMember_grade() {
		return MpMember_grade;
	}
	public void setMpMember_grade(int mpMember_grade) {
		MpMember_grade = mpMember_grade;
	}
	public int getMpMember_point() {
		return MpMember_point;
	}
	public void setMpMember_point(int mpMember_point) {
		MpMember_point = mpMember_point;
	}
	public Date getMpMember_date() {
		return MpMember_date;
	}
	public void setMpMember_date(Date mpMember_date) {
		MpMember_date = mpMember_date;
	}
	public JoaMypageMemberDTO(int mpMember_idx, String mpMember_id, String mpMember_name, String mpMember_pwd,
			String mpMember_age, String mpMember_tel, String mpMember_email, int mpMember_grade, int mpMember_point,
			Date mpMember_date) {
		super();
		MpMember_idx = mpMember_idx;
		MpMember_id = mpMember_id;
		MpMember_name = mpMember_name;
		MpMember_pwd = mpMember_pwd;
		MpMember_age = mpMember_age;
		MpMember_tel = mpMember_tel;
		MpMember_email = mpMember_email;
		MpMember_grade = mpMember_grade;
		MpMember_point = mpMember_point;
		MpMember_date = mpMember_date;
	}
}

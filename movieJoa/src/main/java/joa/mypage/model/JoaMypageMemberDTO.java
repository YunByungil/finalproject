package joa.mypage.model;

import java.sql.Date;

public class JoaMypageMemberDTO {

	private int mem_idx;
	private String mem_id;
	private String mem_name;
	private String mem_pwd;
	private String mem_age;
	private String mem_gender;
	private String mem_tel;
	private String mem_email;
	private String mem_grade;
	private int mem_point;
	private Date mem_joindate;
	
	public JoaMypageMemberDTO() {
		// TODO Auto-generated constructor stub
	}
	public JoaMypageMemberDTO(int mem_idx, String mem_id, String mem_name, String mem_pwd, String mem_age, String mem_gender,
			String mem_tel, String mem_email, String mem_grade, int mem_point, Date mem_joindate) {
		super();
		this.mem_idx = mem_idx;
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.mem_pwd = mem_pwd;
		this.mem_age = mem_age;
		this.mem_gender = mem_gender;
		this.mem_tel = mem_tel;
		this.mem_email = mem_email;
		this.mem_grade = mem_grade;
		this.mem_point = mem_point;
		this.mem_joindate = mem_joindate;
	}
	public int getMem_idx() {
		return mem_idx;
	}
	public void setMem_idx(int mem_idx) {
		this.mem_idx = mem_idx;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_pwd() {
		return mem_pwd;
	}
	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}
	public String getMem_age() {
		return mem_age;
	}
	public void setMem_age(String mem_age) {
		this.mem_age = mem_age;
	}
	public String getMem_gender() {
		return mem_gender;
	}
	public void setMem_gender(String mem_gender) {
		this.mem_gender = mem_gender;
	}
	public String getMem_tel() {
		return mem_tel;
	}
	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public String getMem_grade() {
		return mem_grade;
	}
	public void setMem_grade(String mem_grade) {
		this.mem_grade = mem_grade;
	}
	public int getMem_point() {
		return mem_point;
	}
	public void setMem_point(int mem_point) {
		this.mem_point = mem_point;
	}
	public Date getMem_joindate() {
		return mem_joindate;
	}
	public void setMem_joindate(Date mem_joindate) {
		this.mem_joindate = mem_joindate;
	}
	
}

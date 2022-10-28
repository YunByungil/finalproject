package joa.mypage.model;

import java.sql.*;

public class JoaMypageServiceDTO {
	
	int hqt_idx;
	String hqt_type;
	String hqt_region;
	String hqt_cinema;
	String hqt_id;
	String hqt_email;
	String hqt_subject;
	String hqt_content;
	Date hqt_writedate;
	String hqt_state;
	String hqt_answerwrite;
	String hqt_answercontent;
	String hqt_answerrank;
	Date hqt_answerdate;
	Date hqt_reanswerdate;

	
	public int getHqt_idx() {
		return hqt_idx;
	}


	public void setHqt_idx(int hqt_idx) {
		this.hqt_idx = hqt_idx;
	}


	public String getHqt_type() {
		return hqt_type;
	}


	public void setHqt_type(String hqt_type) {
		this.hqt_type = hqt_type;
	}


	public String getHqt_region() {
		return hqt_region;
	}


	public void setHqt_region(String hqt_region) {
		this.hqt_region = hqt_region;
	}


	public String getHqt_cinema() {
		return hqt_cinema;
	}


	public void setHqt_cinema(String hqt_cinema) {
		this.hqt_cinema = hqt_cinema;
	}


	public String getHqt_id() {
		return hqt_id;
	}


	public void setHqt_id(String hqt_id) {
		this.hqt_id = hqt_id;
	}


	public String getHqt_email() {
		return hqt_email;
	}


	public void setHqt_email(String hqt_email) {
		this.hqt_email = hqt_email;
	}


	public String getHqt_subject() {
		return hqt_subject;
	}


	public void setHqt_subject(String hqt_subject) {
		this.hqt_subject = hqt_subject;
	}


	public String getHqt_content() {
		return hqt_content;
	}


	public void setHqt_content(String hqt_content) {
		this.hqt_content = hqt_content;
	}


	public Date getHqt_writedate() {
		return hqt_writedate;
	}


	public void setHqt_writedate(Date hqt_writedate) {
		this.hqt_writedate = hqt_writedate;
	}


	public String getHqt_state() {
		return hqt_state;
	}


	public void setHqt_state(String hqt_state) {
		this.hqt_state = hqt_state;
	}


	public String getHqt_answerwrite() {
		return hqt_answerwrite;
	}


	public void setHqt_answerwrite(String hqt_answerwrite) {
		this.hqt_answerwrite = hqt_answerwrite;
	}


	public String getHqt_answercontent() {
		return hqt_answercontent;
	}


	public void setHqt_answercontent(String hqt_answercontent) {
		this.hqt_answercontent = hqt_answercontent;
	}


	public String getHqt_answerrank() {
		return hqt_answerrank;
	}


	public void setHqt_answerrank(String hqt_answerrank) {
		this.hqt_answerrank = hqt_answerrank;
	}


	public Date getHqt_answerdate() {
		return hqt_answerdate;
	}


	public void setHqt_answerdate(Date hqt_answerdate) {
		this.hqt_answerdate = hqt_answerdate;
	}


	public Date getHqt_reanswerdate() {
		return hqt_reanswerdate;
	}


	public void setHqt_reanswerdate(Date hqt_reanswerdate) {
		this.hqt_reanswerdate = hqt_reanswerdate;
	}


	public JoaMypageServiceDTO(int hqt_idx, String hqt_type, String hqt_region, String hqt_cinema, String hqt_id,
			String hqt_email, String hqt_subject, String hqt_content, Date hqt_writedate, String hqt_state,
			String hqt_answerwrite, String hqt_answercontent, String hqt_answerrank, Date hqt_answerdate,
			Date hqt_reanswerdate) {
		super();
		this.hqt_idx = hqt_idx;
		this.hqt_type = hqt_type;
		this.hqt_region = hqt_region;
		this.hqt_cinema = hqt_cinema;
		this.hqt_id = hqt_id;
		this.hqt_email = hqt_email;
		this.hqt_subject = hqt_subject;
		this.hqt_content = hqt_content;
		this.hqt_writedate = hqt_writedate;
		this.hqt_state = hqt_state;
		this.hqt_answerwrite = hqt_answerwrite;
		this.hqt_answercontent = hqt_answercontent;
		this.hqt_answerrank = hqt_answerrank;
		this.hqt_answerdate = hqt_answerdate;
		this.hqt_reanswerdate = hqt_reanswerdate;
	}


	public JoaMypageServiceDTO() {
		// TODO Auto-generated constructor stub
	}
}

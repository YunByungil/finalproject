package joa.helpdesk.model;

import java.sql.*;

public class JoaNoticeDTO {
	int ntc_idx;
	String ntc_type;
	String ntc_subject;
	String ntc_content;
	String ntc_file;
	int ntc_readnum;
	Date ntc_writedate;
	Date ntc_rewritedate;
	
	public JoaNoticeDTO() {
		// TODO Auto-generated constructor stub
	}

	public JoaNoticeDTO(int ntc_idx, String ntc_type, String ntc_subject, String ntc_content, String ntc_file,
			int ntc_readnum, Date ntc_writedate, Date ntc_rewritedate) {
		super();
		this.ntc_idx = ntc_idx;
		this.ntc_type = ntc_type;
		this.ntc_subject = ntc_subject;
		this.ntc_content = ntc_content;
		this.ntc_file = ntc_file;
		this.ntc_readnum = ntc_readnum;
		this.ntc_writedate = ntc_writedate;
		this.ntc_rewritedate = ntc_rewritedate;
	}

	public int getNtc_idx() {
		return ntc_idx;
	}

	public void setNtc_idx(int ntc_idx) {
		this.ntc_idx = ntc_idx;
	}

	public String getNtc_type() {
		return ntc_type;
	}

	public void setNtc_type(String ntc_type) {
		this.ntc_type = ntc_type;
	}

	public String getNtc_subject() {
		return ntc_subject;
	}

	public void setNtc_subject(String ntc_subject) {
		this.ntc_subject = ntc_subject;
	}

	public String getNtc_content() {
		return ntc_content;
	}

	public void setNtc_content(String ntc_content) {
		this.ntc_content = ntc_content;
	}

	public String getNtc_file() {
		return ntc_file;
	}

	public void setNtc_file(String ntc_file) {
		this.ntc_file = ntc_file;
	}

	public int getNtc_readnum() {
		return ntc_readnum;
	}

	public void setNtc_readnum(int ntc_readnum) {
		this.ntc_readnum = ntc_readnum;
	}

	public Date getNtc_writedate() {
		return ntc_writedate;
	}

	public void setNtc_writedate(Date ntc_writedate) {
		this.ntc_writedate = ntc_writedate;
	}

	public Date getNtc_rewritedate() {
		return ntc_rewritedate;
	}

	public void setNtc_rewritedate(Date ntc_rewritedate) {
		this.ntc_rewritedate = ntc_rewritedate;
	}
	
}

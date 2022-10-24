package joa.helpdesk.model;

import java.sql.*;

public class JoaManyHelpDTO {
	
	int lfq_idx;
	String lfq_type;
	String lfq_subject;
	String lfq_content;
	int lfq_readnum;
	Date lfq_writedate;
	Date lfq_rewritedate;
	
	public JoaManyHelpDTO() {
		// TODO Auto-generated constructor stub
	}

	public JoaManyHelpDTO(int lfq_idx, String lfq_type, String lfq_subject, String lfq_content, int lfq_readnum,
			Date lfq_writedate, Date lfq_rewritedate) {
		super();
		this.lfq_idx = lfq_idx;
		this.lfq_type = lfq_type;
		this.lfq_subject = lfq_subject;
		this.lfq_content = lfq_content;
		this.lfq_readnum = lfq_readnum;
		this.lfq_writedate = lfq_writedate;
		this.lfq_rewritedate = lfq_rewritedate;
	}

	public int getLfq_idx() {
		return lfq_idx;
	}

	public void setLfq_idx(int lfq_idx) {
		this.lfq_idx = lfq_idx;
	}

	public String getLfq_type() {
		return lfq_type;
	}

	public void setLfq_type(String lfq_type) {
		this.lfq_type = lfq_type;
	}

	public String getLfq_subject() {
		return lfq_subject;
	}

	public void setLfq_subject(String lfq_subject) {
		this.lfq_subject = lfq_subject;
	}

	public String getLfq_content() {
		return lfq_content;
	}

	public void setLfq_content(String lfq_content) {
		this.lfq_content = lfq_content;
	}

	public int getLfq_readnum() {
		return lfq_readnum;
	}

	public void setLfq_readnum(int lfq_readnum) {
		this.lfq_readnum = lfq_readnum;
	}

	public Date getLfq_writedate() {
		return lfq_writedate;
	}

	public void setLfq_writedate(Date lfq_writedate) {
		this.lfq_writedate = lfq_writedate;
	}

	public Date getLfq_rewritedate() {
		return lfq_rewritedate;
	}

	public void setLfq_rewritedate(Date lfq_rewritedate) {
		this.lfq_rewritedate = lfq_rewritedate;
	}
	
	
}

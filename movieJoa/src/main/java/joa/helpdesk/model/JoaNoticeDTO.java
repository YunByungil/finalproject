package joa.helpdesk.model;

import java.sql.*;

public class JoaNoticeDTO {
	int idx;
	String type;
	String subject;
	String content;
	String file;
	int readnum;
	Date writedate;
	Date rewritedate;
	
	public JoaNoticeDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public int getReadnum() {
		return readnum;
	}

	public void setReadnum(int readnum) {
		this.readnum = readnum;
	}

	public Date getWritedate() {
		return writedate;
	}

	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}

	public Date getRewritedate() {
		return rewritedate;
	}

	public void setRewritedate(Date rewritedate) {
		this.rewritedate = rewritedate;
	}

	public JoaNoticeDTO(int idx, String type, String subject, String content, String file, int readnum, Date writedate,
			Date rewritedate) {
		super();
		this.idx = idx;
		this.type = type;
		this.subject = subject;
		this.content = content;
		this.file = file;
		this.readnum = readnum;
		this.writedate = writedate;
		this.rewritedate = rewritedate;
	}
}

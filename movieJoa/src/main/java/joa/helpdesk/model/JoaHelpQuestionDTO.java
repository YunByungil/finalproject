package joa.helpdesk.model;

import java.sql.*;

public class JoaHelpQuestionDTO {
	
	int idx;
	String type;
	String region;
	String cinema;
	String id;
	String email;
	String subject;
	String content;
	Date writedate;
	String state;
	String answerwrite;
	String answercontent;
	String answerrank;
	Date answerdate;
	Date reanswerdate;

	
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


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getCinema() {
		return cinema;
	}


	public void setCinema(String cinema) {
		this.cinema = cinema;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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


	public Date getWritedate() {
		return writedate;
	}


	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getAnswerwrite() {
		return answerwrite;
	}


	public void setAnswerwrite(String answerwrite) {
		this.answerwrite = answerwrite;
	}


	public String getAnswercontent() {
		return answercontent;
	}


	public void setAnswercontent(String answercontent) {
		this.answercontent = answercontent;
	}


	public String getAnswerrank() {
		return answerrank;
	}


	public void setAnswerrank(String answerrank) {
		this.answerrank = answerrank;
	}


	public Date getAnswerdate() {
		return answerdate;
	}


	public void setAnswerdate(Date answerdate) {
		this.answerdate = answerdate;
	}


	public Date getReanswerdate() {
		return reanswerdate;
	}


	public void setReanswerdate(Date reanswerdate) {
		this.reanswerdate = reanswerdate;
	}


	public JoaHelpQuestionDTO(int idx, String type, String region, String cinema, String id, String email,
			String subject, String content, Date writedate, String state, String answerwrite, String answercontent,
			String answerrank, Date answerdate, Date reanswerdate) {
		super();
		this.idx = idx;
		this.type = type;
		this.region = region;
		this.cinema = cinema;
		this.id = id;
		this.email = email;
		this.subject = subject;
		this.content = content;
		this.writedate = writedate;
		this.state = state;
		this.answerwrite = answerwrite;
		this.answercontent = answercontent;
		this.answerrank = answerrank;
		this.answerdate = answerdate;
		this.reanswerdate = reanswerdate;
	}


	public JoaHelpQuestionDTO() {
		// TODO Auto-generated constructor stub
	}
}

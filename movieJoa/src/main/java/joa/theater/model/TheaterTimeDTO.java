package joa.theater.model;

public class TheaterTimeDTO {
	
	private String rate;
	private String subject;
	private String genre;
	private String runningtime;
	private String sdate;
	
	public TheaterTimeDTO() {
		// TODO Auto-generated constructor stub
	}

	public TheaterTimeDTO(String rate, String subject, String genre, String runningtime, String sdate) {
		super();
		this.rate = rate;
		this.subject = subject;
		this.genre = genre;
		this.runningtime = runningtime;
		this.sdate = sdate;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getRunningtime() {
		return runningtime;
	}

	public void setRunningtime(String runningtime) {
		this.runningtime = runningtime;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

}

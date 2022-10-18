package joa.adminSchedule.model;

public class ScheduleDTO {

	private int idx;
	private String mov_title;
	private String city;
	private String branch;
	private String theater;
	private String seat;
	private String day;
	private String start_time;
	private String end_time;
	
	public ScheduleDTO() {
		// TODO Auto-generated constructor stub
	}

	public ScheduleDTO(int idx, String mov_title, String city, String branch, String theater, String seat, String day,
			String start_time, String end_time) {
		super();
		this.idx = idx;
		this.mov_title = mov_title;
		this.city = city;
		this.branch = branch;
		this.theater = theater;
		this.seat = seat;
		this.day = day;
		this.start_time = start_time;
		this.end_time = end_time;
	}

	

	public String getMov_title() {
		return mov_title;
	}



	public void setMov_title(String mov_title) {
		this.mov_title = mov_title;
	}



	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getTheater() {
		return theater;
	}

	public void setTheater(String theater) {
		this.theater = theater;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	
}

package joa.book.model;

public class JoaBookDTO {

	private int sch_idx;
	private String sch_mov_title;
	private String sch_city;
	private String sch_branch;
	private String sch_theater;
	private String sch_seat;
	private String sch_day;
	private String sch_start_hour;
	private String sch_start_min;
	private String sch_end_hour;
	private String sch_end_min;
	
	public JoaBookDTO() {
		// TODO Auto-generated constructor stub
	}

	public JoaBookDTO(int sch_idx, String sch_mov_title, String sch_city, String sch_branch, String sch_theater,
			String sch_seat, String sch_day, String sch_start_hour, String sch_start_min, String sch_end_hour,
			String sch_end_min) {
		super();
		this.sch_idx = sch_idx;
		this.sch_mov_title = sch_mov_title;
		this.sch_city = sch_city;
		this.sch_branch = sch_branch;
		this.sch_theater = sch_theater;
		this.sch_seat = sch_seat;
		this.sch_day = sch_day;
		this.sch_start_hour = sch_start_hour;
		this.sch_start_min = sch_start_min;
		this.sch_end_hour = sch_end_hour;
		this.sch_end_min = sch_end_min;
	}

	public int getSch_idx() {
		return sch_idx;
	}

	public void setSch_idx(int sch_idx) {
		this.sch_idx = sch_idx;
	}

	public String getSch_mov_title() {
		return sch_mov_title;
	}

	public void setSch_mov_title(String sch_mov_title) {
		this.sch_mov_title = sch_mov_title;
	}

	public String getSch_city() {
		return sch_city;
	}

	public void setSch_city(String sch_city) {
		this.sch_city = sch_city;
	}

	public String getSch_branch() {
		return sch_branch;
	}

	public void setSch_branch(String sch_branch) {
		this.sch_branch = sch_branch;
	}

	public String getSch_theater() {
		return sch_theater;
	}

	public void setSch_theater(String sch_theater) {
		this.sch_theater = sch_theater;
	}

	public String getSch_seat() {
		return sch_seat;
	}

	public void setSch_seat(String sch_seat) {
		this.sch_seat = sch_seat;
	}

	public String getSch_day() {
		return sch_day;
	}

	public void setSch_day(String sch_day) {
		this.sch_day = sch_day;
	}

	public String getSch_start_hour() {
		return sch_start_hour;
	}

	public void setSch_start_hour(String sch_start_hour) {
		this.sch_start_hour = sch_start_hour;
	}

	public String getSch_start_min() {
		return sch_start_min;
	}

	public void setSch_start_min(String sch_start_min) {
		this.sch_start_min = sch_start_min;
	}

	public String getSch_end_hour() {
		return sch_end_hour;
	}

	public void setSch_end_hour(String sch_end_hour) {
		this.sch_end_hour = sch_end_hour;
	}

	public String getSch_end_min() {
		return sch_end_min;
	}

	public void setSch_end_min(String sch_end_min) {
		this.sch_end_min = sch_end_min;
	}
	
}

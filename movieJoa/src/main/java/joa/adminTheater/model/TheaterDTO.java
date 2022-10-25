package joa.adminTheater.model;

public class TheaterDTO {

	private int the_idx;
	private String the_city;
	private String the_branch;
	private String the_theater;
	private String the_seat;
	private int the_width;
	private int the_height;
	
	public TheaterDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getThe_idx() {
		return the_idx;
	}

	public void setThe_idx(int the_idx) {
		this.the_idx = the_idx;
	}

	public String getThe_city() {
		return the_city;
	}

	public void setThe_city(String the_city) {
		this.the_city = the_city;
	}

	public String getThe_branch() {
		return the_branch;
	}

	public void setThe_branch(String the_branch) {
		this.the_branch = the_branch;
	}

	public String getThe_theater() {
		return the_theater;
	}

	public void setThe_theater(String the_theater) {
		this.the_theater = the_theater;
	}

	public String getThe_seat() {
		return the_seat;
	}

	public void setThe_seat(String the_seat) {
		this.the_seat = the_seat;
	}

	public int getThe_width() {
		return the_width;
	}

	public void setThe_width(int the_width) {
		this.the_width = the_width;
	}

	public int getThe_height() {
		return the_height;
	}

	public void setThe_height(int the_height) {
		this.the_height = the_height;
	}

	public TheaterDTO(int the_idx, String the_city, String the_branch, String the_theater, String the_seat,
			int the_width, int the_height) {
		super();
		this.the_idx = the_idx;
		this.the_city = the_city;
		this.the_branch = the_branch;
		this.the_theater = the_theater;
		this.the_seat = the_seat;
		this.the_width = the_width;
		this.the_height = the_height;
	}
	
}

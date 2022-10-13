package joa.adminTheater.model;

public class TheaterDTO {

	private int idx;
	private String city;
	private String branch;
	private String seat;
	private int width;
	private int height;
	
	public TheaterDTO() {
		// TODO Auto-generated constructor stub
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

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public TheaterDTO(int idx, String city, String branch, String seat, int width, int height) {
		super();
		this.idx = idx;
		this.city = city;
		this.branch = branch;
		this.seat = seat;
		this.width = width;
		this.height = height;
	}
	
}

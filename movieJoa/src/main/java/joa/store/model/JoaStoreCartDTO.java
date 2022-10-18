package joa.store.model;

import java.util.*;

public class JoaStoreCartDTO {
	
	private int car_idx;
	private String car_mem_id;
	private int car_pro_idx;
	private int car_count;
	private Date car_joindate;
	
	public JoaStoreCartDTO() {
		// TODO Auto-generated constructor stub
	}

	public JoaStoreCartDTO(int car_idx, String car_mem_id, int car_pro_idx, int car_count, Date car_joindate) {
		super();
		this.car_idx = car_idx;
		this.car_mem_id = car_mem_id;
		this.car_pro_idx = car_pro_idx;
		this.car_count = car_count;
		this.car_joindate = car_joindate;
	}

	public int getCar_idx() {
		return car_idx;
	}

	public void setCar_idx(int car_idx) {
		this.car_idx = car_idx;
	}

	public String getCar_mem_id() {
		return car_mem_id;
	}

	public void setCar_mem_id(String car_mem_id) {
		this.car_mem_id = car_mem_id;
	}

	public int getCar_pro_idx() {
		return car_pro_idx;
	}

	public void setCar_pro_idx(int car_pro_idx) {
		this.car_pro_idx = car_pro_idx;
	}

	public int getCar_count() {
		return car_count;
	}

	public void setCar_count(int car_count) {
		this.car_count = car_count;
	}

	public Date getCar_joindate() {
		return car_joindate;
	}

	public void setCar_joindate(Date car_joindate) {
		this.car_joindate = car_joindate;
	}
	
	

}
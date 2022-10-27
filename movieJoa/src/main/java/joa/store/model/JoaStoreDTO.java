package joa.store.model;

public class JoaStoreDTO {
	
	private String pro_name;
	private int pro_price;
	private int car_count;
	private String car_mem_id;
	private int car_pro_idx;
	private int car_idx;
	private String pro_filename;
	private String mem_name;
	private String mem_tel;
	
	public JoaStoreDTO() {
		// TODO Auto-generated constructor stub
	}

	public JoaStoreDTO(String pro_name, int pro_price, int car_count, String car_mem_id, int car_pro_idx, int car_idx,
			String pro_filename, String mem_name, String mem_tel) {
		super();
		this.pro_name = pro_name;
		this.pro_price = pro_price;
		this.car_count = car_count;
		this.car_mem_id = car_mem_id;
		this.car_pro_idx = car_pro_idx;
		this.car_idx = car_idx;
		this.pro_filename = pro_filename;
		this.mem_name = mem_name;
		this.mem_tel = mem_tel;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public int getPro_price() {
		return pro_price;
	}

	public void setPro_price(int pro_price) {
		this.pro_price = pro_price;
	}

	public int getCar_count() {
		return car_count;
	}

	public void setCar_count(int car_count) {
		this.car_count = car_count;
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

	public int getCar_idx() {
		return car_idx;
	}

	public void setCar_idx(int car_idx) {
		this.car_idx = car_idx;
	}

	public String getPro_filename() {
		return pro_filename;
	}

	public void setPro_filename(String pro_filename) {
		this.pro_filename = pro_filename;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_tel() {
		return mem_tel;
	}

	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}
	
	
	
	
	
	
	

}

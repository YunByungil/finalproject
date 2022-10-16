package joa.store.model;

public class JoaStoreDTO {
	
	private String pro_name;
	private int pro_price;
	private int car_count;
	
	public JoaStoreDTO() {
		// TODO Auto-generated constructor stub
	}

	public JoaStoreDTO(String pro_name, int pro_price, int car_count) {
		super();
		this.pro_name = pro_name;
		this.pro_price = pro_price;
		this.car_count = car_count;
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
	
	

}

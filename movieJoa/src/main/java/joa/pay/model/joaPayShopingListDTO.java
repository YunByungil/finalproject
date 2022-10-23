package joa.pay.model;

public class joaPayShopingListDTO {
	
	private String car_pro_filename;
	private String car_pro_name;
	private String car_mem_id;
	private int car_pro_idx;
	private int car_pro_price;
	private int car_count;
	private int total_price;
	private int pay_price_sum;
	private int pay_discount;
	private int pay_total_sum;
	
	
	public joaPayShopingListDTO() {
		
	}
	

	public joaPayShopingListDTO(String car_pro_filename, String car_pro_name, String car_mem_id, int car_pro_idx,
			int car_pro_price, int car_count, int total_price, int pay_price_sum, int pay_discount, int pay_total_sum) {
		
		super();
		this.car_pro_filename = car_pro_filename;
		this.car_pro_name = car_pro_name;
		this.car_mem_id = car_mem_id;
		this.car_pro_idx = car_pro_idx;
		this.car_pro_price = car_pro_price;
		this.car_count = car_count;
		this.total_price = total_price;
		this.pay_price_sum = pay_price_sum;
		this.pay_discount = pay_discount;
		this.pay_total_sum = pay_total_sum;
	}
	

	public String getCar_pro_filename() {
		return car_pro_filename;
	}
	

	public void setCar_pro_filename(String car_pro_filename) {
		this.car_pro_filename = car_pro_filename;
	}
	

	public String getCar_pro_name() {
		return car_pro_name;
	}
	

	public void setCar_pro_name(String car_pro_name) {
		this.car_pro_name = car_pro_name;
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

	
	public int getCar_pro_price() {
		return car_pro_price;
	}

	
	public void setCar_pro_price(int car_pro_price) {
		this.car_pro_price = car_pro_price;
	}

	
	public int getCar_count() {
		return car_count;
	}

	
	public void setCar_count(int car_count) {
		this.car_count = car_count;
	}

	
	public int getTotal_price() {
		return total_price;
	}

	
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	
	public int getPay_price_sum() {
		return pay_price_sum;
	}

	
	public void setPay_price_sum(int pay_price_sum) {
		this.pay_price_sum = pay_price_sum;
	}

	
	public int getPay_discount() {
		return pay_discount;
	}

	
	public void setPay_discount(int pay_discount) {
		this.pay_discount = pay_discount;
	}

	
	public int getPay_total_sum() {
		return pay_total_sum;
	}

	
	public void setPay_total_sum(int pay_total_sum) {
		this.pay_total_sum = pay_total_sum;
	}

	
	
	
	
}

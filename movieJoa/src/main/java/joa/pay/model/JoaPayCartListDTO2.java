package joa.pay.model;

public class JoaPayCartListDTO2 {
	
	private String pro_filename;
	private String pro_name;
	private int pro_price;
	private int car_count;
	private int car_price_sum;
	private int pay_price_sum;
	private int pay_discount;
	private int pay_total_sum;
	private String car_mem_name;
	private String mem_tel;
	
	public JoaPayCartListDTO2() {
		// TODO Auto-generated constructor stub
	}

	public JoaPayCartListDTO2(String pro_filename, String pro_name, int pro_price, int car_count, int car_price_sum,
			int pay_price_sum, int pay_discount, int pay_total_sum, String car_mem_name, String mem_tel) {
		super();
		this.pro_filename = pro_filename;
		this.pro_name = pro_name;
		this.pro_price = pro_price;
		this.car_count = car_count;
		this.car_price_sum = car_price_sum;
		this.pay_price_sum = pay_price_sum;
		this.pay_discount = pay_discount;
		this.pay_total_sum = pay_total_sum;
		this.car_mem_name = car_mem_name;
		this.mem_tel = mem_tel;
	}

	public String getPro_filename() {
		return pro_filename;
	}

	public void setPro_filename(String pro_filename) {
		this.pro_filename = pro_filename;
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

	public int getCar_price_sum() {
		return car_price_sum;
	}

	public void setCar_price_sum(int car_price_sum) {
		this.car_price_sum = car_price_sum;
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

	public String getCar_mem_name() {
		return car_mem_name;
	}

	public void setCar_mem_name(String car_mem_name) {
		this.car_mem_name = car_mem_name;
	}

	public String getMem_tel() {
		return mem_tel;
	}

	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}	

	
	
}

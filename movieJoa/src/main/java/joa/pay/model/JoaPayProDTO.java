package joa.pay.model;

public class JoaPayProDTO {
	
	
	private String  payPro_mem_id;	
	private String  payPro_mem_name;
	private String  payPro_mem_email;
	private int 	payPro_mem_tel;
	private String  payPro_pg;	
	private String  payPro_method;
	private String  payPro_pro_name;
	private int 	payPro_price_sum;
	private int 	payPro_discount;
	private int 	payPro_total_price;
	private String  payPro_merchant_uid;	
	
	public JoaPayProDTO() {
		// TODO Auto-generated constructor stub
	}

	public JoaPayProDTO(String payPro_mem_id, String payPro_mem_name, String payPro_mem_email,
			int payPro_mem_tel, String payPro_pro_name, String payPro_pg, String payPro_method, int payPro_price_sum,
			int payPro_discount, int payPro_total_price, String payPro_merchant_uid) {
		super();
		this.payPro_mem_id = payPro_mem_id;
		this.payPro_mem_name = payPro_mem_name;
		this.payPro_mem_email = payPro_mem_email;
		this.payPro_mem_tel = payPro_mem_tel;
		this.payPro_pro_name = payPro_pro_name;
		this.payPro_pg = payPro_pg;
		this.payPro_method = payPro_method;
		this.payPro_price_sum = payPro_price_sum;
		this.payPro_discount = payPro_discount;
		this.payPro_total_price = payPro_total_price;
		this.payPro_merchant_uid = payPro_merchant_uid;
	}

	public String getPayPro_mem_id() {
		return payPro_mem_id;
	}

	public void setPayPro_mem_id(String payPro_mem_id) {
		this.payPro_mem_id = payPro_mem_id;
	}

	public String getPayPro_mem_name() {
		return payPro_mem_name;
	}

	public void setPayPro_mem_name(String payPro_mem_name) {
		this.payPro_mem_name = payPro_mem_name;
	}

	public String getPayPro_mem_email() {
		return payPro_mem_email;
	}

	public void setPayPro_mem_email(String payPro_mem_email) {
		this.payPro_mem_email = payPro_mem_email;
	}

	public int getPayPro_mem_tel() {
		return payPro_mem_tel;
	}

	public void setPayPro_mem_tel(int payPro_mem_tel) {
		this.payPro_mem_tel = payPro_mem_tel;
	}

	public String getPayPro_pro_name() {
		return payPro_pro_name;
	}

	public void setPayPro_pro_name(String payPro_pro_name) {
		this.payPro_pro_name = payPro_pro_name;
	}

	public String getPayPro_pg() {
		return payPro_pg;
	}

	public void setPayPro_pg(String payPro_pg) {
		this.payPro_pg = payPro_pg;
	}

	public String getPayPro_method() {
		return payPro_method;
	}

	public void setPayPro_method(String payPro_method) {
		this.payPro_method = payPro_method;
	}

	public int getPayPro_price_sum() {
		return payPro_price_sum;
	}

	public void setPayPro_price_sum(int payPro_price_sum) {
		this.payPro_price_sum = payPro_price_sum;
	}

	public int getPayPro_discount() {
		return payPro_discount;
	}

	public void setPayPro_discount(int payPro_discount) {
		this.payPro_discount = payPro_discount;
	}

	public int getPayPro_total_price() {
		return payPro_total_price;
	}

	public void setPayPro_total_price(int payPro_total_price) {
		this.payPro_total_price = payPro_total_price;
	}

	public String getPayPro_merchant_uid() {
		return payPro_merchant_uid;
	}

	public void setPayPro_merchant_uid(String payPro_merchant_uid) {
		this.payPro_merchant_uid = payPro_merchant_uid;
	}
	
	
	
}

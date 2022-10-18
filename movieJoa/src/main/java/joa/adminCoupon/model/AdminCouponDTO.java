package joa.adminCoupon.model;

public class AdminCouponDTO {
	
	private int cou_idx;
	private String cou_name;
	private int cou_discount;
	
	public AdminCouponDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AdminCouponDTO(int cou_idx, String cou_name, int cou_discount) {
		super();
		this.cou_idx = cou_idx;
		this.cou_name = cou_name;
		this.cou_discount = cou_discount;
	}

	public int getCou_idx() {
		return cou_idx;
	}

	public void setCou_idx(int cou_idx) {
		this.cou_idx = cou_idx;
	}

	public String getCou_name() {
		return cou_name;
	}

	public void setCou_name(String cou_name) {
		this.cou_name = cou_name;
	}

	public int getCou_discount() {
		return cou_discount;
	}

	public void setCou_discount(int cou_discount) {
		this.cou_discount = cou_discount;
	}


}

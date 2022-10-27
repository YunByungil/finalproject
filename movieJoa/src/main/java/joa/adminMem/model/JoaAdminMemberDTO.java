package joa.adminMem.model;

public class JoaAdminMemberDTO {

	private int admin_idx;
	private String admin_id;
	private String admin_pwd;
	private String admin_name;
	private String admin_area;
	private String admin_shop;
	private String admin_position;
	
	public JoaAdminMemberDTO() {
		// TODO Auto-generated constructor stub
	}

	public JoaAdminMemberDTO(int admin_idx, String admin_id, String admin_pwd, String admin_name, String admin_area,
			String admin_shop, String admin_position) {
		super();
		this.admin_idx = admin_idx;
		this.admin_id = admin_id;
		this.admin_pwd = admin_pwd;
		this.admin_name = admin_name;
		this.admin_area = admin_area;
		this.admin_shop = admin_shop;
		this.admin_position = admin_position;
	}

	public int getAdmin_idx() {
		return admin_idx;
	}

	public void setAdmin_idx(int admin_idx) {
		this.admin_idx = admin_idx;
	}

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_pwd() {
		return admin_pwd;
	}

	public void setAdmin_pwd(String admin_pwd) {
		this.admin_pwd = admin_pwd;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getAdmin_area() {
		return admin_area;
	}

	public void setAdmin_area(String admin_area) {
		this.admin_area = admin_area;
	}

	public String getAdmin_shop() {
		return admin_shop;
	}

	public void setAdmin_shop(String admin_shop) {
		this.admin_shop = admin_shop;
	}

	public String getAdmin_position() {
		return admin_position;
	}

	public void setAdmin_position(String admin_position) {
		this.admin_position = admin_position;
	}
	
}
	
package joa.adminCoupon.model;

import java.util.*;

public interface AdminCouponDAO {
	
	public int addCoupon(AdminCouponDTO dto);
	public int adminCouponTotalCnt(Map map);
	public List<AdminCouponDTO> listCoupon(Map map);
	public int deleteCoupon(int cou_idx);
	
	

}

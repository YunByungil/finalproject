package joa.adminCoupon.model;

import java.util.*;


public interface AdminCouponService {
	
	public int addCoupon(AdminCouponDTO dto);
	public int adminCouponTotalCnt();
	public List<AdminCouponDTO> listCoupon(int cp, int ls);
	public int deleteCoupon(int cou_idx);

}

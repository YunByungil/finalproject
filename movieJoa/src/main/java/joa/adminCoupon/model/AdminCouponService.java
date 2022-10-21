package joa.adminCoupon.model;

import java.util.*;


public interface AdminCouponService {
	
	public int addCoupon(AdminCouponDTO dto);
	public int adminCouponTotalCnt(String s_k, String s_v);
	public List<AdminCouponDTO> listCoupon(int cp, int ls, String s_k, String s_v);
	public int deleteCoupon(int cou_idx);

}

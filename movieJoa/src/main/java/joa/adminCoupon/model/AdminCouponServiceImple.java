package joa.adminCoupon.model;

import java.util.*;


public class AdminCouponServiceImple implements AdminCouponService{
	
	private AdminCouponDAO adminCouponDao;

	public AdminCouponServiceImple(AdminCouponDAO adminCouponDao) {
		super();
		this.adminCouponDao = adminCouponDao;
	}

	@Override
	public int addCoupon(AdminCouponDTO dto) {
		int result=adminCouponDao.addCoupon(dto);
		return result;
	}
	
	@Override
	public int adminCouponTotalCnt(String s_k, String s_v) {
		Map map=new HashMap();
		map.put("s_k", s_k);
		map.put("s_v", s_v);
		int result=adminCouponDao.adminCouponTotalCnt(map);
		return result;
	}

	@Override
	public List<AdminCouponDTO> listCoupon(int cp, int ls, String s_k, String s_v) {
		// TODO Auto-generated method stub
		int start=(cp-1)*ls+1;
		int end=cp*ls;
		Map map=new HashMap();
		map.put("start", start);
		map.put("end",end);
		map.put("s_k", s_k);
		map.put("s_v", s_v);
		List list=adminCouponDao.listCoupon(map);
		return list;
		
	}
	
	
	@Override
	public int deleteCoupon(int cou_idx) {
		// TODO Auto-generated method stub
		int result=adminCouponDao.deleteCoupon(cou_idx);
		return result;
	}

}

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
	public int adminCouponTotalCnt() {
		int result=adminCouponDao.adminCouponTotalCnt();
		return result;
	}

	@Override
	public List<AdminCouponDTO> listCoupon(int cp, int ls) {
		// TODO Auto-generated method stub
		int start=(cp-1)*ls+1;
		int end=cp*ls;
		Map map=new HashMap();
		map.put("start", start);
		map.put("end",end);
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

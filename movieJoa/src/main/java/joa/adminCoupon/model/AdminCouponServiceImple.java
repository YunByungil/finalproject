package joa.adminCoupon.model;

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

}

package joa.adminCoupon.model;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

public class AdminCouponDAOImple implements AdminCouponDAO {
	
	private SqlSessionTemplate sqlMap;

	public AdminCouponDAOImple(SqlSessionTemplate sqlMap) {
		super();
		this.sqlMap = sqlMap;
	}

	@Override
	public int addCoupon(AdminCouponDTO dto) {
		int result=sqlMap.insert("addCoupon",dto);
		return result;
	}
	

}

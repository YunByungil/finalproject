package joa.adminCoupon.model;

import java.util.*;

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

	@Override
	public int adminCouponTotalCnt(Map map) {
		int count=sqlMap.selectOne("adminCouponTotalCnt", map);
		return count;
	}
	

	@Override
	public List<AdminCouponDTO> listCoupon(Map map) {
		List<AdminCouponDTO> list=sqlMap.selectList("listCoupon",map);
		return list;
	}

	
	@Override
	public int deleteCoupon(int cou_idx) {
		int result=sqlMap.delete("deleteCoupon",cou_idx);
		return result;
	}



}
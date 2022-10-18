package joa.event.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import joa.adminCoupon.model.AdminCouponDTO;
import joa.adminEvent.model.AdminEventDTO;

public class Joa_EventDAOImple implements Joa_EventDAO {
	
	private SqlSessionTemplate sqlMap;

	public Joa_EventDAOImple(SqlSessionTemplate sqlMap) {
		super();
		this.sqlMap = sqlMap;
	}
	
	@Override
	public AdminEventDTO infoEvent(int eve_idx) {
		AdminEventDTO dto=sqlMap.selectOne("infoUserEvent",eve_idx);
		return dto;
	}

	@Override
	public List<AdminEventDTO> listEvent() {
		List<AdminEventDTO> list=sqlMap.selectList("listUserEvent");
		return list;
	}
	
	@Override
	public AdminCouponDTO couponInfo(int cou_idx) {
		AdminCouponDTO dto=sqlMap.selectOne("couponInfo",cou_idx);
		return dto;
	}

	@Override
	public int addCoupon(Map map) {
		int result=sqlMap.insert("addUserCoupon",map);
		return result;
	}
	
	@Override
	public int addApply(Map map) {
		int result=sqlMap.insert("addUserApply",map);
		return result;
	}
	
	
	
	@Override
	public int getPoint(Map map) {
		int result=sqlMap.update("getPoint",map);
		return result;
	}

	@Override
	public int checkApply(Map map) {
		int result=sqlMap.selectOne("checkApply",map);
		return result;
	}

	@Override
	public int userPoint(String member_id) {
		 int userPoint=sqlMap.selectOne("userPoint",member_id);
		 return userPoint;
	}
	
	

}

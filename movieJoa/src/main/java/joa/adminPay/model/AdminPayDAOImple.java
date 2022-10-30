package joa.adminPay.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import joa.pay.model.JoaPayMovDTO;
import joa.review.model.JoaReviewDTO;

public class AdminPayDAOImple implements AdminPayDAO {
	
	
	private SqlSessionTemplate sqlMap;

	public AdminPayDAOImple(SqlSessionTemplate sqlMap) {
		super();
		this.sqlMap = sqlMap;
	}

	@Override
	public int adminPayTotalCnt(Map map) {
		int count=sqlMap.selectOne("adminPayTotalCnt", map);
		return count;
	}
	@Override
	public List<JoaPayMovDTO> listAdminPay(Map map) {
		List<JoaPayMovDTO> list=sqlMap.selectList("listAdminPay",map);
		return list;
	}
	@Override
	public int deleteAdminPay(int payMov_idx) {
		int result=sqlMap.delete("deleteAdminPay",payMov_idx);
		return result;
	}
	
	@Override
	public JoaPayMovDTO detailAdminPay(int payMov_idx) {
		// TODO Auto-generated method stub
		JoaPayMovDTO dto=sqlMap.selectOne("detailAdminPay",payMov_idx);
		return dto;
	}

}

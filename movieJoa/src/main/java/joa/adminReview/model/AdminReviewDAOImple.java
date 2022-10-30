package joa.adminReview.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import joa.review.model.JoaReviewDTO;


public class AdminReviewDAOImple implements AdminReviewDAO {
	
	private SqlSessionTemplate sqlMap;

	public AdminReviewDAOImple(SqlSessionTemplate sqlMap) {
		super();
		this.sqlMap = sqlMap;
	}
	
	@Override
	public int adminReviewTotalCnt(Map map) {
		int count=sqlMap.selectOne("adminReviewTotalCnt", map);
		return count;
	}
	

	@Override
	public List<JoaReviewDTO> listReview(Map map) {
		List<JoaReviewDTO> list=sqlMap.selectList("listReview",map);
		return list;
	}

	
	@Override
	public int deleteReview(int rev_idx) {
		int result=sqlMap.delete("deleteReview",rev_idx);
		return result;
	}
	
	@Override
	public JoaReviewDTO detailReview(int rev_idx) {
		// TODO Auto-generated method stub
		JoaReviewDTO dto=sqlMap.selectOne("detailReview",rev_idx);
		return dto;
	}



}

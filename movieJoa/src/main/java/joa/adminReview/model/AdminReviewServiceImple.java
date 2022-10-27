package joa.adminReview.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import joa.review.model.JoaReviewDTO;

public class AdminReviewServiceImple implements AdminReviewService{
	
	private AdminReviewDAO adminReviewDao;

	public AdminReviewServiceImple(AdminReviewDAO adminReviewDao) {
		super();
		this.adminReviewDao = adminReviewDao;
	}

	
	@Override
	public int adminReviewTotalCnt(String s_k, String s_v) {
		Map map=new HashMap();
		map.put("s_k", s_k);
		map.put("s_v", s_v);
		int result=adminReviewDao.adminReviewTotalCnt(map);
		return result;
	}

	@Override
	public List<JoaReviewDTO> listReview(int cp, int ls, String s_k, String s_v) {
		// TODO Auto-generated method stub
		int start=(cp-1)*ls+1;
		int end=cp*ls;
		Map map=new HashMap();
		map.put("start", start);
		map.put("end",end);
		map.put("s_k", s_k);
		map.put("s_v", s_v);
		List list=adminReviewDao.listReview(map);
		return list;
		
	}
	
	
	@Override
	public int deleteReview(int rev_idx) {
		// TODO Auto-generated method stub
		int result=adminReviewDao.deleteReview(rev_idx);
		return result;
	}
	
	@Override
	public JoaReviewDTO detailReview(int rev_idx) {
		JoaReviewDTO dto=adminReviewDao.detailReview(rev_idx);
		return dto;
	}
	
	
}

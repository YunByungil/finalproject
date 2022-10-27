package joa.adminReview.model;

import java.util.List;
import java.util.Map;

import joa.review.model.JoaReviewDTO;

public interface AdminReviewDAO {
	
	public int adminReviewTotalCnt(Map map);
	public List<JoaReviewDTO> listReview(Map map);
	public int deleteReview(int rev_idx);
	public JoaReviewDTO detailReview(int rev_idx);

}

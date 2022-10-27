package joa.adminReview.model;

import java.util.List;

import joa.review.model.JoaReviewDTO;

public interface AdminReviewService {
	
	public int adminReviewTotalCnt(String s_k, String s_v);
	public List<JoaReviewDTO> listReview(int cp, int ls, String s_k, String s_v);
	public int deleteReview(int rev_idx);
	public JoaReviewDTO detailReview(int rev_idx);

}

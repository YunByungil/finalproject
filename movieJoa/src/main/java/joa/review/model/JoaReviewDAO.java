package joa.review.model;

import java.util.*;

import joa.movie.model.JoaMovieDTO;

public interface JoaReviewDAO {

	public int commentWrite(JoaReviewDTO dto);
	public List<JoaReviewDTO> commentList(int ot, Map map);
	public List<JoaReviewDTO> updateList(Map map);
	public int commentUpdate(JoaReviewDTO dto);
	public int commentDelete(Map map);
	public int totalCnt(int mov_idx);
	public void updateScore(String rev_movie_title);
	public int addLike(int rev_idx, Map map);
	public List<JoaLikeDTO> likes(Map map);
	public int checkId(Map map);
}

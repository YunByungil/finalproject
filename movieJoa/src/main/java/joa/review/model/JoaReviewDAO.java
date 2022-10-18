package joa.review.model;

import java.util.*;

import joa.movie.model.JoaMovieDTO;

public interface JoaReviewDAO {

	public int commentWrite(JoaReviewDTO dto);
	public List<JoaReviewDTO> commentList(int ot);
	public List<JoaReviewDTO> updateList(Map map);
	public int commentDelete(Map map);
}

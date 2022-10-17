package joa.review.model;

import java.util.*;

import joa.movie.model.JoaMovieDTO;

public interface JoaReviewDAO {

	public int commentWrite(JoaReviewDTO dto);
	public List<JoaReviewDTO> commentList();
}

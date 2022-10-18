package joa.adminMovie.model;

import java.util.*;

public interface AdminMovieService {
	
	public int addMovie(AdminMovieDTO dto);
	public int updateMovie(AdminMovieDTO dto);
	public AdminMovieDTO detailMovie(int mov_idx);
	public List<AdminMovieDTO> listMovie(int cp, int ls);
	public int adminMovieTotalCnt();
	public int deleteMovie(int mov_idx);
	public List searchMovie(String sc_t, String sc_k);
	
}

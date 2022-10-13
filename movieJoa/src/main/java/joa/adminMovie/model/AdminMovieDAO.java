package joa.adminMovie.model;

import java.util.*;

public interface AdminMovieDAO {
	
	public int addMovie(Map map);
	public int updateMovie(Map map);
	public AdminMovieDTO detailMovie(int mov_idx);
	public List<AdminMovieDTO> listMovie(Map map);
	public int adminMovieTotalCnt();
	public int deteleMovie(int mov_idx);
	public List searchMovie(Map map);

}

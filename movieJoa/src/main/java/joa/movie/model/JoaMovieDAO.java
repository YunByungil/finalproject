package joa.movie.model;

import java.util.*;

public interface JoaMovieDAO {

	public List<JoaMovieDTO> movieList(int ot);
	public List<JoaMovieDTO> preMovieDate();
	public List<JoaMovieDTO> preMovieList();
	public List<JoaMovieDTO> detailView(int mov_idx);
	//junsung writed
	public double allMovCnt();
	public double selMovCnt(String buy_title);
	public int updateBookPer(Map map);
	public double allBookCnt(String buy_title);
	public double manBookCnt(String buy_title);
	public double womanBookCnt(String buy_title);
	public int updateGenderPer(Map map);
	public double oneBookPer(String buy_title);
	public double twoBookPer(String buy_title);
	public double threeBookPer(String buy_title);
	public double fourBookPer(String buy_title);
	public double fiveBookPer(String buy_title);
	public int updateAgePer(Map map);
	
}

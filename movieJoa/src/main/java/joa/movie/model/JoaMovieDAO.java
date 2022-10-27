package joa.movie.model;

import java.util.*;

public interface JoaMovieDAO {

	public List<JoaMovieDTO> movieList(int ot);
	public List<JoaMovieDTO> preMovieDate();
	public List<JoaMovieDTO> preMovieList();
	public List<JoaMovieDTO> detailView(int mov_idx);
	//junsung writed
	public double allMovCnt();
	public double selMovCnt(String payMov_mov_title);
	public int updateBookPer(Map map);
	public double allBookCnt(String payMov_mov_title);
	public double manBookCnt(String payMov_mov_title);
	public double womanBookCnt(String payMov_mov_title);
	public int updateGenderPer(Map map);
	public double oneBookPer(String payMov_mov_title);
	public double twoBookPer(String payMov_mov_title);
	public double threeBookPer(String payMov_mov_title);
	public double fourBookPer(String payMov_mov_title);
	public double fiveBookPer(String payMov_mov_title);
	public int updateAgePer(Map map);
	public List<JoaMovieDTO> allMovieList();
	
}

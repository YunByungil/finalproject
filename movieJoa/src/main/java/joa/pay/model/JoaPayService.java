package joa.pay.model;

import java.util.List;
import java.util.Map;

import joa.movie.model.JoaMovieDTO;

public interface JoaPayService {
	
	public JoaPayCartListDTO storePayCartList(int car_pro_idx, String mem_id);
	public int payProductResultAdd(JoaPayProDTO dto);
	public int joaBookPayAdd(JoaPayMovDTO dto);
	public int payProductResultList(JoaPayProResultDTO dto);
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

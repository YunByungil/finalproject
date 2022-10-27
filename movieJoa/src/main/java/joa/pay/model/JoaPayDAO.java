package joa.pay.model;

import java.util.*;
import joa.movie.model.*;

import joa.adminStore.model.AdminStoreDTO;
import joa.pay.model.*;
import joa.store.model.JoaStoreCartDTO;

public interface JoaPayDAO {	

	public JoaPayCartListDTO storePayCartList(Map map);
	public int payProductResultAdd(JoaPayProDTO dto);
	public int joaBookPayAdd(JoaPayMovDTO dto);
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

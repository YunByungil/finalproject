package joa.pay.model;

import java.util.*;

import joa.adminStore.model.AdminStoreDAO;
import joa.movie.model.JoaMovieDTO;
import joa.pay.model.*;
import joa.pay.model.JoaPayMovDTO;

public class JoaPayServiceImple implements JoaPayService {
	
	private JoaPayDAO joaPayDao;
	
	public JoaPayServiceImple(JoaPayDAO joaPayDao) {
		super();
		this.joaPayDao = joaPayDao;
	}
	
	@Override
	public JoaPayCartListDTO storePayCartList(int car_pro_idx, String mem_id) {
		System.out.println("joaPayService:"+mem_id);
		Map map=new HashMap();
		map.put("mem_id",mem_id);
		map.put("car_pro_idx",car_pro_idx);
		JoaPayCartListDTO dto=joaPayDao.storePayCartList(map);
		return dto;
	}
	
	@Override
	public int payProductResultAdd(JoaPayProDTO dto) {
		int result=joaPayDao.payProductResultAdd(dto);
		return result;
	}

	@Override
	public int joaBookPayAdd(JoaPayMovDTO dto) {
		int result=joaPayDao.joaBookPayAdd(dto);
		return result;
	}
	   //junsung writed
	   @Override
	   public double allMovCnt() {
	      double result=joaPayDao.allMovCnt();
	      return result;
	   }
	   @Override
	   public double selMovCnt(String payMov_mov_title) {
	      double result=joaPayDao.selMovCnt(payMov_mov_title);
	      return result;
	   }
	   @Override
	   public int updateBookPer(Map map) {
	      int result=joaPayDao.updateBookPer(map);
	      return result;
	   }
	   @Override
	   public double allBookCnt(String payMov_mov_title) {
	      double result=joaPayDao.allBookCnt(payMov_mov_title);
	      return result;
	   }
	   @Override
	   public double manBookCnt(String payMov_mov_title) {
	      double result=joaPayDao.manBookCnt(payMov_mov_title);
	      return result;
	   }
	   @Override
	   public double womanBookCnt(String payMov_mov_title) {
	      double result=joaPayDao.womanBookCnt(payMov_mov_title);
	      return result;
	   }
	   @Override
	   public int updateGenderPer(Map map) {
	      int result=joaPayDao.updateGenderPer(map);
	      return result;
	   }
	   @Override
	   public double oneBookPer(String payMov_mov_title) {
	      double result=joaPayDao.oneBookPer(payMov_mov_title);
	      return result;
	   }
	   @Override
	   public double twoBookPer(String payMov_mov_title) {
	      double result=joaPayDao.twoBookPer(payMov_mov_title);
	      return result;
	   }
	   @Override
	   public double threeBookPer(String payMov_mov_title) {
	      double result=joaPayDao.threeBookPer(payMov_mov_title);
	      return result;
	   }
	   @Override
	   public double fourBookPer(String payMov_mov_title) {
	      double result=joaPayDao.fourBookPer(payMov_mov_title);
	      return result;
	   }
	   @Override
	   public double fiveBookPer(String payMov_mov_title) {
	      double result=joaPayDao.fiveBookPer(payMov_mov_title);
	      return result;
	   }
	   @Override
	   public int updateAgePer(Map map) {
	      int result=joaPayDao.updateAgePer(map);
	      return result;
	   }
	   @Override
	   public List<JoaMovieDTO> allMovieList() {
	      List<JoaMovieDTO> aml=joaPayDao.allMovieList();
	      return aml;
	   }
	
}

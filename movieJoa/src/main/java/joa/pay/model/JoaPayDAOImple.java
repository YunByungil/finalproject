package joa.pay.model;

import java.util.*;
import joa.movie.model.*;

import org.mybatis.spring.SqlSessionTemplate;

import joa.adminStore.model.AdminStoreDTO;
import joa.pay.model.*;

public class JoaPayDAOImple implements JoaPayDAO {

	private SqlSessionTemplate sqlMap;

	public JoaPayDAOImple (SqlSessionTemplate sqlMap) {
		super();
		this.sqlMap = sqlMap;
	}
	
	@Override
	public JoaPayCartListDTO storePayCartList(Map map) {
		JoaPayCartListDTO dto=sqlMap.selectOne("storePayCartList",map);
		return dto;
	}
	
	@Override
	public int payProductResultAdd(JoaPayProDTO dto) {
		int result=sqlMap.insert("payProductResultAdd",dto);
		return result;
	}
	
	@Override
	public int joaBookPayAdd(JoaPayMovDTO dto) {
		int result=sqlMap.insert("joaBookPayAdd",dto);
		return result;
	}
	
	@Override
	public double allMovCnt() {
		int result=sqlMap.selectOne("allMovCnt");
		return result;
	}
	@Override
	public double selMovCnt(String payMov_mov_title) {
		int result=sqlMap.selectOne("selMovCnt", payMov_mov_title);
		return result;
	}
	@Override
	public int updateBookPer(Map map) {
		int result=sqlMap.update("updateBookPer", map);
		return result;
	}
	@Override
	public double allBookCnt(String payMov_mov_title) {
		int result=sqlMap.selectOne("allBookCnt", payMov_mov_title);
		return result;
	}
	@Override
	public double manBookCnt(String payMov_mov_title) {
		int result=sqlMap.selectOne("manBookCnt", payMov_mov_title);
		return result;
	}
	@Override
	public double womanBookCnt(String payMov_mov_title) {
		int result=sqlMap.selectOne("womanBookCnt", payMov_mov_title);
		return result;
	}
	@Override
	public int updateGenderPer(Map map) {
		int result=sqlMap.update("updateGenderPer", map);
		return result;
	}
	@Override
	public double oneBookPer(String payMov_mov_title) {
		int result=sqlMap.selectOne("oneBookCnt", payMov_mov_title);
		return result;
	}
	@Override
	public double twoBookPer(String payMov_mov_title) {
		int result=sqlMap.selectOne("twoBookCnt", payMov_mov_title);
		return result;
	}
	@Override
	public double threeBookPer(String payMov_mov_title) {
		int result=sqlMap.selectOne("threeBookCnt", payMov_mov_title);
		return result;
	}
	@Override
	public double fourBookPer(String payMov_mov_title) {
		int result=sqlMap.selectOne("fourBookCnt", payMov_mov_title);
		return result;
	}
	@Override
	public double fiveBookPer(String payMov_mov_title) {
		int result=sqlMap.selectOne("fiveBookCnt", payMov_mov_title);
		return result;
	}
	@Override
	public int updateAgePer(Map map) {
		int result=sqlMap.update("updateAgePer", map);
		return result;
	}
	@Override
	public List<JoaMovieDTO> allMovieList() {
		List<JoaMovieDTO> aml=sqlMap.selectList("allMovieList");
		return aml;
	}
}

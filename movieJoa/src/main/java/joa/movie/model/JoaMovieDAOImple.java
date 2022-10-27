package joa.movie.model;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;

public class JoaMovieDAOImple implements JoaMovieDAO {

	private SqlSessionTemplate sqlMap;

	public JoaMovieDAOImple(SqlSessionTemplate sqlMap) {
		super();
		this.sqlMap = sqlMap;
	}
	
	@Override
	public List<JoaMovieDTO> movieList(int ot) {
		List<JoaMovieDTO> list=null;
		switch(ot) {
		case 0:list=sqlMap.selectList("movieList0");break;
		case 1:list=sqlMap.selectList("movieList1");break;
		case 2:list=sqlMap.selectList("movieList2");break;
		}
		return list;
	}
	@Override
	public List<JoaMovieDTO> preMovieDate() {
		List<JoaMovieDTO> date=sqlMap.selectList("preMovieDate");
		return date;
	}
	@Override
	public List<JoaMovieDTO> preMovieList() {
		List<JoaMovieDTO> list=sqlMap.selectList("preMovieList");
		return list;
	}
	@Override
	public List<JoaMovieDTO> detailView(int mov_idx) {
		List<JoaMovieDTO> list=sqlMap.selectList("detailView", mov_idx);
		return list;
	}
	//junsung writed
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

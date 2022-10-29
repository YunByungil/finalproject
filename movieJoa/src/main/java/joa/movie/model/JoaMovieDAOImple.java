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
	public List<JoaMovieDTO> indexList0() {
		List<JoaMovieDTO> list=sqlMap.selectList("indexList0");
		return list;
	}
	@Override
	public List<JoaMovieDTO> indexList1() {
		List<JoaMovieDTO> list=sqlMap.selectList("indexList1");
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
}

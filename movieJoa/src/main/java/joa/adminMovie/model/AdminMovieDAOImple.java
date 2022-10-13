package joa.adminMovie.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

public class AdminMovieDAOImple implements AdminMovieDAO {
	
	private SqlSessionTemplate sqlMap;

	public AdminMovieDAOImple(SqlSessionTemplate sqlMap) {
		super();
		this.sqlMap = sqlMap;
	}

	@Override
	public int addMovie(Map map) {
		int result=sqlMap.insert("addMovie",map);
		return result;
	}

	@Override
	public int updateMovie(Map map) {
		// TODO Auto-generated method stub
		int result=sqlMap.update("updateMovie",map);
		System.out.println("daoImple단 result:"+result);
		return result;
	}

	@Override
	public AdminMovieDTO detailMovie(int mov_idx) {
		// TODO Auto-generated method stub
		AdminMovieDTO dto=sqlMap.selectOne("detailMovie",mov_idx);
		return dto;
	}

	@Override
	public List<AdminMovieDTO> listMovie(Map map) {
		List<AdminMovieDTO> list=sqlMap.selectList("listMovie", map);
		return list;
	}

	@Override
	public int adminMovieTotalCnt() {
		int count=sqlMap.selectOne("adminMovieTotalCnt");
		return count;
	}

	@Override
	public int deteleMovie(int mov_idx) {
		// TODO Auto-generated method stub
		int result=sqlMap.delete("deleteMovie",mov_idx);
		return result;
	}

	@Override
	public List searchMovie(Map map) {
		List list=sqlMap.selectList("searchMovie", map);
		return list;
	}
	

}

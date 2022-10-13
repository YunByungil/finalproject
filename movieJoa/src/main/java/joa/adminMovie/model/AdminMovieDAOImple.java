package joa.adminMovie.model;

import org.mybatis.spring.SqlSessionTemplate;

public class AdminMovieDAOImple implements AdminMovieDAO {
	
	private SqlSessionTemplate sqlMap;

	public AdminMovieDAOImple(SqlSessionTemplate sqlMap) {
		super();
		this.sqlMap = sqlMap;
	}

	@Override
	public int addMovie(AdminMovieDTO dto) {
		int result=sqlMap.insert("addMovie",dto);
		return result;
	}
	
	

}

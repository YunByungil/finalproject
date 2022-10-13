package joa.adminTheater.model;

import org.mybatis.spring.SqlSessionTemplate;

public class TheaterDAOImple implements TheaterDAO {

	private SqlSessionTemplate sqlMap;
	
	public TheaterDAOImple(SqlSessionTemplate sqlMap) {
		super();
		this.sqlMap = sqlMap;
	}

	@Override
	public int theaterAdd(TheaterDTO dto) {
		int result=sqlMap.insert("theaterAdd",dto);
		return result;
	}

}

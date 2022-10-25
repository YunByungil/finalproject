package joa.theater.model;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class TheaterTimeDAOImple implements TheaterTimeDAO {

	private SqlSessionTemplate sqlMap;

	public TheaterTimeDAOImple(SqlSessionTemplate sqlMap) {
		super();
		this.sqlMap = sqlMap;
	}
	
	@Override
	public List<TheaterTimeDTO> timeList(HashMap map) {
		List<TheaterTimeDTO> list = sqlMap.selectList("theaterTimeList", map);
		return list;
	}
}

package joa.adminTheater.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import joa.adminMember.model.JoaAdminMemberDTO;

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

	@Override
	public List theaterCheck(Map timap) {
		List list=sqlMap.selectList("theaterCheck",timap);
		return list;
	}
	
	@Override
	public JoaAdminMemberDTO adminIdSearch(String sid) {
		JoaAdminMemberDTO dto=sqlMap.selectOne("adminIdSearch",sid);
		return dto;
	}
	
	@Override
	public List theaterList(Map map) {
		List list=sqlMap.selectList("theaterList",map);
		return list;
	}
}

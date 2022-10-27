package joa.adminTheater.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import joa.adminMem.model.JoaAdminMemberDTO;

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
	public List<TheaterDTO> theaterListView(Map map) {
		List<TheaterDTO> list=sqlMap.selectList("theaterListView",map);
		return list;
	}
	
	@Override
	public int theaterDelete(int idx) {
		int result=sqlMap.delete("theaterDelete",idx);
		return result;
	}
}

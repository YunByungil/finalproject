package joa.adminOwncou.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;


public class AdminOwncouDAOImple implements AdminOwncouDAO{
	
	private SqlSessionTemplate sqlMap;

	public AdminOwncouDAOImple(SqlSessionTemplate sqlMap) {
		super();
		this.sqlMap = sqlMap;
	}

	@Override
	public int adminOwncouTotalCnt() {
		int count=sqlMap.selectOne("adminOwncouTotalCnt");
		return count;
	}
	@Override
	public List<AdminOwncouDTO> listOwncou(Map map) {
		List<AdminOwncouDTO> list=sqlMap.selectList("listOwncou",map);
		return list;
	}
	
	@Override
	public int deleteOwncou(int own_idx) {
		// TODO Auto-generated method stub
		int result=sqlMap.delete("deleteOwncou",own_idx);
		return result;
	}
	
}

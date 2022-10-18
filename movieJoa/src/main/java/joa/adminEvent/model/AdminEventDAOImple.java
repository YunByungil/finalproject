package joa.adminEvent.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

public class AdminEventDAOImple implements AdminEventDAO {
	
	private SqlSessionTemplate sqlMap;

	public AdminEventDAOImple(SqlSessionTemplate sqlMap) {
		super();
		this.sqlMap = sqlMap;
	}

	@Override
	public int addEvent(Map map) {
		int result=sqlMap.insert("addEvent",map);
		return result;
	}

	@Override
	public int updateEvent(Map map) {
		// TODO Auto-generated method stub
		int result=sqlMap.update("updateEvent",map);
		return result;
	}

	@Override
	public AdminEventDTO detailEvent(int eve_idx) {
		AdminEventDTO dto=sqlMap.selectOne("detailEvent",eve_idx);
		return dto;
	}

	@Override
	public List<AdminEventDTO> listEvent(Map map) {
		List<AdminEventDTO> list=sqlMap.selectList("listEvent", map);
		return list;
	}

	@Override
	public int adminEventTotalCnt() {
		int count=sqlMap.selectOne("adminEventTotalCnt");
		return count;
	}

	@Override
	public int deleteEvent(int eve_idx) {
		// TODO Auto-generated method stub
		int result=sqlMap.delete("deleteEvent",eve_idx);
		return result;
	}

	@Override
	public List searchEvent(Map map) {
		List list=sqlMap.selectList("searchEvent", map);
		return list;
	}
	
	@Override
	public int adminApplycantTotalCnt() {
		int count=sqlMap.selectOne("adminApplycantTotalCnt");
		return count;
	}

	@Override
	public List<AdminApplycantDTO> listApplycant(Map map) {
		List<AdminApplycantDTO> list=sqlMap.selectList("listApplycant", map);
		System.out.println("DAOIMPLE단의 list adminApplycant DTO 반환값");
		return list;
	}
	
	@Override
	public int deleteApplycant(int app_idx) {
		// TODO Auto-generated method stub
		int result=sqlMap.delete("deleteApplycant",app_idx);
		return result;
	}
	
	

}

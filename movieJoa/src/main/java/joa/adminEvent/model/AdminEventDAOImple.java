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
	public int e_b_table_insert(AdminEventLuckBoardDTO dto) {
		int result = sqlMap.insert("e_b_table_insert",dto);
		return result;
	}
	
	@Override
	public List<AdminApplycantDTO> listLuck_mem_extraction(int app_event_code) {
		List<AdminApplycantDTO>list = sqlMap.selectList("luck_mem_extraction",app_event_code);
		return list;
	}

	@Override
	public int addEvent(Map map) {
		int result=sqlMap.insert("addEvent",map);
		return result;
	}
	
	@Override
	public int addSysEve(Map map) {
		int result=sqlMap.insert("addSysEve",map);
		return result;
	}
	
	@Override
	public int addSysCou(Map map) {
		int result=sqlMap.insert("addSysCou",map);
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
	public int adminEventTotalCnt(Map map) {
		int count=sqlMap.selectOne("adminEventTotalCnt", map);
		return count;
	}
	
	@Override
	public int systemEventTotalCnt(Map map) {
		int count=sqlMap.selectOne("systemEventTotalCnt", map);
		return count;
	}

	@Override
	public int deleteEvent(int eve_idx) {
		// TODO Auto-generated method stub
		int result=sqlMap.delete("deleteEvent",eve_idx);
		return result;
	}
	
	@Override
	public int delSysCou(int eve_idx) {
		// TODO Auto-generated method stub
		int result=sqlMap.delete("delSysCou",eve_idx);
		return result;
	}
	
	@Override
	public int adminApplycantTotalCnt(Map map) {
		int count=sqlMap.selectOne("adminApplycantTotalCnt", map);
		return count;
	}

	@Override
	public List<AdminApplycantDTO> listApplycant(Map map) {
		List<AdminApplycantDTO> list=sqlMap.selectList("listApplycant", map);
		return list;
	}
	
	@Override
	public int deleteApplycant(int app_idx) {
		// TODO Auto-generated method stub
		int result=sqlMap.delete("deleteApplycant",app_idx);
		return result;
	}
	
	

}

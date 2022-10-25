package joa.adminSchedule.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import joa.adminTheater.model.TheaterDTO;

public class ScheduleDAOImple implements ScheduleDAO {
	
	private SqlSessionTemplate sqlMap;
	
	public ScheduleDAOImple(SqlSessionTemplate sqlMap) {
		super();
		this.sqlMap = sqlMap;
	}

	@Override
	public List checkSchedule(Map map) {
		List list=sqlMap.selectList("checkSchedule",map);
		return list;
	}
	
	@Override
	public List dayChoice(String day) {
		List list=sqlMap.selectList("dayChoice",day);
		return list;
	}
	
	@Override
	public List theaterChoice(Map ad) {
		List list=sqlMap.selectList("theaterChoice",ad);
		return list;
	}
	
	@Override
	public TheaterDTO seatSearch(Map seatInfo) {
		TheaterDTO dto=sqlMap.selectOne("seatSearch",seatInfo);
		return dto;
	}
	
	@Override
	public int scheduleInsert(ScheduleDTO dto) {
		int result=sqlMap.insert("scheduleInsert",dto);
		return result;
	}
	
	@Override
	public int scheduleCount(String day) {
		int count=sqlMap.selectOne("scheduleCount",day);
		return count;
	}
	
	@Override
	public List<ScheduleDTO> scheduleList(int cp, int ls,String day) {
		int start=(cp-1)*ls+1;
		int end=cp*ls;
		Map map=new HashMap();
		map.put("start",start);
		map.put("end",end);
		map.put("day",day);
		List<ScheduleDTO> list=sqlMap.selectList("scheduleList",map);
		return list;
	}
}

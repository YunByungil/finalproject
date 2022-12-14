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
	public int scheduleCount(String day,String city,String branch) {
		Map map=new HashMap();
		map.put("day",day);
		map.put("city",city);
		map.put("branch",branch);
		int count=sqlMap.selectOne("scheduleCount",map);
		return count;
	}
	
	@Override
	public List<ScheduleDTO> scheduleList(int cp, int ls,String day,String city,String branch) {
		int start=(cp-1)*ls+1;
		int end=cp*ls;
		Map map=new HashMap();
		map.put("start",start);
		map.put("end",end);
		map.put("day",day);
		map.put("city",city);
		map.put("branch",branch);
		List<ScheduleDTO> list=sqlMap.selectList("scheduleList",map);
		return list;
	}
	@Override
	public List<ScheduleDTO> branchCheck(Map map) {
		List list=sqlMap.selectList("branchCheck",map);
		return list;
	}
	
	@Override
	public int runtimeCheck(String title) {
		int run=sqlMap.selectOne("runtimeCheck",title);
		return run;
	}
	
	@Override
	public int scheduleDelete(int idx) {
		int result=sqlMap.delete("scheduleDelete",idx);
		return result;
	}
}

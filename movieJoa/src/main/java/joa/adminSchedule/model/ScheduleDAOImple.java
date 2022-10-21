package joa.adminSchedule.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

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
}

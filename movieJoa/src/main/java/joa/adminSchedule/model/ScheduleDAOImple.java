package joa.adminSchedule.model;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;

public class ScheduleDAOImple implements ScheduleDAO {
	
	private SqlSessionTemplate sqlMap;
	
	public ScheduleDAOImple(SqlSessionTemplate sqlMap) {
		super();
		this.sqlMap = sqlMap;
	}

	@Override
	public List checkSchedule(ScheduleDTO dto) {
		List list=sqlMap.selectList("checkSchedule",dto);
		return list;
	}
}

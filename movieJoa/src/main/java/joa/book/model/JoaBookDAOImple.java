package joa.book.model;
import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;
public class JoaBookDAOImple implements JoaBookDAO {
	
	private SqlSessionTemplate sqlMap;

	public JoaBookDAOImple(SqlSessionTemplate sqlMap) {
		super();
		this.sqlMap = sqlMap;
	}
	
	@Override
	public List<JoaBookDTO> moviesSubjectList() {
		List<JoaBookDTO> list = sqlMap.selectList("moviesSubjectList");
		System.out.println("dao : " +list.size());
		return list;
	}
	
	@Override
	public List<JoaBookDTO> moviesBranchList(String sch_mov_title) {
		List<JoaBookDTO> list = sqlMap.selectList("moviesBranchList", sch_mov_title);
		return list;
	}
	
	@Override
	public List<JoaBookDTO> moveisDateList(HashMap map) {
		List<JoaBookDTO> list = sqlMap.selectList("moviesDateList", map);
		return list;
	}
	
	@Override
	public List<JoaBookDTO> moveisTimeList(HashMap map) {
		List<JoaBookDTO> list = sqlMap.selectList("moviesTimeList", map);
		return list;
	}
	
	///////////////////////////////////////////////////////
	@Override
	public List<JoaBookDTO> theaterBranchList(String sch_city) {
		List<JoaBookDTO> list = sqlMap.selectList("theaterBranchList",sch_city);
		return list;
	}
	
	//theaterDay
	@Override
	public List<JoaBookDTO> theaterDay(HashMap map) {
		List<JoaBookDTO> list = sqlMap.selectList("theaterDayList", map);
		return list;
	}

}

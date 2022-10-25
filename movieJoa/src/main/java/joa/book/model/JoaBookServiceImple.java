package joa.book.model;
import java.util.*;
public class JoaBookServiceImple implements JoaBookService {
	
	private JoaBookDAO joaBookDao;
	
	public JoaBookServiceImple(JoaBookDAO joaBookDao) {
		super();
		this.joaBookDao = joaBookDao;
	}

	@Override
	public List<JoaBookDTO> moviesSubjectList() {
		List<JoaBookDTO> list = joaBookDao.moviesSubjectList();
		System.out.println("service : "+list.size());
		return list;
	}
	
	@Override
	public List<JoaBookDTO> moviesBranchList(String sch_mov_title) {
		List<JoaBookDTO> list = joaBookDao.moviesBranchList(sch_mov_title);
		return list;
	}
	
	@Override
	public List<JoaBookDTO> moveisDateList(String sch_mov_title, String sch_branch) {
		HashMap map = new HashMap();
		map.put("sch_mov_title", sch_mov_title);
		map.put("sch_branch", sch_branch);
		List<JoaBookDTO> list = joaBookDao.moveisDateList(map);
		return list;
	}
	
	@Override
	public List<JoaBookDTO> moveisTimeList(String sch_mov_title, String sch_branch, String sch_day) {
		HashMap map = new HashMap();
		map.put("sch_mov_title", sch_mov_title);
		map.put("sch_branch", sch_branch);
		map.put("sch_day", sch_day);
		List<JoaBookDTO> list = joaBookDao.moveisTimeList(map);
		return list;
	}
	
	///////////////////////////////////////////////////////
	@Override
	public List<JoaBookDTO> theaterBranchList(String sch_city) {
		List<JoaBookDTO> list = joaBookDao.theaterBranchList(sch_city);
		return list;
	}
	//theaterDay
	@Override
	public List<JoaBookDTO> theaterDay(String sch_city, String sch_branch) {
		HashMap map = new HashMap();
		map.put("sch_city", sch_city);
		map.put("sch_branch", sch_branch);
		List<JoaBookDTO> list = joaBookDao.theaterDay(map);
		return list;
	}

}

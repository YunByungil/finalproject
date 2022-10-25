package joa.theater.model;

import java.util.HashMap;
import java.util.List;

public class TheaterTimeServiceImple implements TheaterTimeService {

	private TheaterTimeDAO theaterTimeDao;

	public TheaterTimeServiceImple(TheaterTimeDAO theaterTimeDao) {
		super();
		this.theaterTimeDao = theaterTimeDao;
	}
	
	@Override
	public List<TheaterTimeDTO> timeList(String sch_dayd, String sch_branch) {
		HashMap map = new HashMap();
		map.put("sch_dayd", sch_dayd);
		map.put("sch_branch", sch_branch);
		List<TheaterTimeDTO> list = theaterTimeDao.timeList(map);
		return list;
	}
}

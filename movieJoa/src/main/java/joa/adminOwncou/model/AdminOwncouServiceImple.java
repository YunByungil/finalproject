package joa.adminOwncou.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AdminOwncouServiceImple implements AdminOwncouService {

	private AdminOwncouDAO adminOwncouDao;

	public AdminOwncouServiceImple(AdminOwncouDAO adminOwncouDao) {
		super();
		this.adminOwncouDao = adminOwncouDao;
	}
	
	@Override
	public int adminOwncouTotalCnt() {
		int result=adminOwncouDao.adminOwncouTotalCnt();
		System.out.println("service단 결과 TOTALCNT:"+result);
		return result;
	}
	
	@Override
	public List<AdminOwncouDTO> listOwncou(int cp, int ls) {
		// TODO Auto-generated method stub
		int start=(cp-1)*ls+1;
		int end=cp*ls;
		Map map=new HashMap();
		map.put("start", start);
		map.put("end",end);
		List list=adminOwncouDao.listOwncou(map);
		return list;
		
	}
	@Override
	public int deleteOwncou(int own_idx) {
		// TODO Auto-generated method stub
		int result=adminOwncouDao.deleteOwncou(own_idx);
		return result;
	}
	

}

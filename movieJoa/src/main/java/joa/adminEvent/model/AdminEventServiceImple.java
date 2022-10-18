package joa.adminEvent.model;

import java.sql.Date;
import java.text.*;
import java.util.*;

public class AdminEventServiceImple implements AdminEventService {
	
	private AdminEventDAO adminEventDao;

	public AdminEventServiceImple(AdminEventDAO adminEventDao) {
		super();
		this.adminEventDao = adminEventDao;
	}
	
	Date start_date;
	Date today;

		
	@Override
	public int addEvent(AdminEventDTO dto) {
		// TODO Auto-generated method stub
		
		Map map=new HashMap();
		
		map.put("category", dto.getEve_category());
		map.put("subject", dto.getEve_subject());
		map.put("main_img", dto.getEve_main_img());
		map.put("thumb_img", dto.getEve_thumb_img());
		map.put("start_date", dto.getEve_start_date());
		map.put("end_date", dto.getEve_end_date());
		String todayfm = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
		String s_d = dto.getEve_start_date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			start_date = new Date(dateFormat.parse(s_d).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		try {
			today = new Date(dateFormat.parse(todayfm).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String status="";
		int compare = start_date.compareTo(today); 
		if(compare > 0) {
			  System.out.println("이벤트 시작일이 오늘 이후");
			  status="진행 전 이벤트";
			}else if(compare < 0) {
			  System.out.println("이벤트 시작일이 오늘 이전");
			  status="진행중 이벤트";
			}else {
			  System.out.println("이벤트 시작일이 오늘");
			  status="종료된 이벤트";
			}
		map.put("status",status);
		int result=adminEventDao.addEvent(map);
		return result;
	}

	@Override
	public int updateEvent(AdminEventDTO dto) {
		// TODO Auto-generated method stub
		Map map=new HashMap();
		
		map.put("idx", dto.getEve_idx());
		map.put("category", dto.getEve_category());
		map.put("subject", dto.getEve_subject());
		map.put("main_img", dto.getEve_main_img());
		map.put("thumb_img", dto.getEve_thumb_img());
		map.put("start_date", dto.getEve_start_date());
		map.put("end_date", dto.getEve_end_date());
		
		String todayfm = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
		String s_d = dto.getEve_start_date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			start_date = new Date(dateFormat.parse(s_d).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		try {
			today = new Date(dateFormat.parse(todayfm).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String status="";
		int compare = start_date.compareTo(today); 
		if(compare > 0) {
			  System.out.println("이벤트 시작일이 오늘 이후");
			  status="진행 전 이벤트";
			}else if(compare < 0) {
			  System.out.println("이벤트 시작일이 오늘 이전");
			  status="진행중 이벤트";
			}else {
			  System.out.println("이벤트 시작일이 오늘");
			  status="종료된 이벤트";
			}
		map.put("status",status);
		int result=adminEventDao.updateEvent(map);
		return result;
	}

	@Override
	public AdminEventDTO detailEvent(int eve_idx) {
		AdminEventDTO dto=adminEventDao.detailEvent(eve_idx);
		return dto;
	}

	@Override
	public List listEvent(int cp, int ls) {
		int start=(cp-1)*ls+1;
		int end=cp*ls;
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		List list=adminEventDao.listEvent(map);
		return list;
	}

	@Override
	public int adminEventTotalCnt() {
		int result=adminEventDao.adminEventTotalCnt();
		return result;
	}

	@Override
	public int deleteEvent(int eve_idx) {
		// TODO Auto-generated method stub
		int result=adminEventDao.deleteEvent(eve_idx);
		return result;
	}

	@Override
	public List searchEvent(String sc_t, String sc_k) {
		// TODO Auto-generated method stub
		Map map=new HashMap();
		map.put("sc_t", sc_t);
		map.put("sc_k", sc_k);
		List list=adminEventDao.searchEvent(map);
		return list;
	}
	
	@Override
	public List listApplycant(int cp, int ls) {
		int start=(cp-1)*ls+1;
		int end=cp*ls;
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		List list=adminEventDao.listApplycant(map);
		System.out.println("서비스 단의 list"+list);
		return list;
	}

	@Override
	public int adminApplycantTotalCnt() {
		int result=adminEventDao.adminApplycantTotalCnt();
		System.out.println("서비스단의 total cnt"+result);
		return result;
	}
	
	@Override
	public int deleteApplycant(int app_idx) {
		// TODO Auto-generated method stub
		int result=adminEventDao.deleteApplycant(app_idx);
		return result;
	}


}

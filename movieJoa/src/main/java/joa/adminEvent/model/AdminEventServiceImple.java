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
	
	/*
	 * Date end_date; Date today;
	 */
	
	@Override
	public int e_b_table_insert(AdminEventLuckBoardDTO dto) {
		int result = adminEventDao.e_b_table_insert(dto);
		return result;
	}
	
	@Override
	public String listLuck_mem_extraction(int app_event_code, int member_count) {
		List<AdminApplycantDTO>list = (ArrayList<AdminApplycantDTO>) adminEventDao.listLuck_mem_extraction(app_event_code);
		AdminApplycantDTO howhow_min;
		AdminApplycantDTO howhow_max;
		howhow_min = list.get(0);
		howhow_max = list.get(list.size()- 1);
		
		int min = howhow_min.getApp_idx();
		int max = howhow_max.getApp_idx();
		int random = 0;
		int count = 0;
		String member = "";
		int[] randomCH = new int[member_count];
		AdminApplycantDTO howhow;
		for(int i=0; i<=member_count;i++) {
			random = 0;
			howhow = null;
			random = (int) ((Math.random() * (max - min)) + min);
			howhow = list.get(i);
			System.out.println(random);
			System.out.println(howhow.getApp_idx());
			System.out.println(member);
			System.out.println(member_count);
			if(random==(int)howhow.getApp_idx()) {
				
				String e= (howhow.getApp_member_id()+",");
				if(count!=member_count) {
				for(int h=0; h<randomCH.length;h++) {
					if(randomCH[h]!=random) {
						member+=e;
						count++;
						randomCH[i]=random;
						break;
					}
				}
				}
				System.out.println(e);
				System.out.println(member);
				
				
			}
			if(count!=member_count && i==(member_count-1)) {
				i=-1;
			}
		}
		return member;
	}
	
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
		/*
		 * String todayfm = new SimpleDateFormat("yyyy-MM-dd").format(new
		 * Date(System.currentTimeMillis())); String s_d = dto.getEve_start_date();
		 * SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); try {
		 * start_date = new Date(dateFormat.parse(s_d).getTime()); } catch
		 * (ParseException e) { e.printStackTrace(); } try { today = new
		 * Date(dateFormat.parse(todayfm).getTime()); } catch (ParseException e) {
		 * e.printStackTrace(); } String status=""; int compare =
		 * start_date.compareTo(today); if(compare > 0) {
		 * System.out.println("이벤트 시작일이 오늘 이후"); status="진행 전 이벤트"; }else if(compare <
		 * 0) { System.out.println("이벤트 시작일이 오늘 이전"); status="진행중 이벤트"; }else {
		 * System.out.println("이벤트 시작일이 오늘"); status="종료된 이벤트"; }
		 */
		int result=adminEventDao.addEvent(map);
		return result;
	}
	
	@Override
	public int addSysEve(int eidx) {
		
		Map eve=new HashMap();
		Map cou=new HashMap();
		int totalResult=0;
		System.out.println("serviceImple eidx:"+eidx);
		
		if(eidx==111) {
			eve.put("idx", eidx);
			eve.put("category", "즉시발급형");
			eve.put("subject", "신규 고객 감사 할인쿠폰 증정 이벤트");
			eve.put("main_img", "join_main.jpg");
			eve.put("thumb_img", "join_thumb.png");
			eve.put("start_date", "2022-10-01");
			eve.put("end_date", "2022-12-13");
			
			cou.put("idx", eidx);
			cou.put("cou_name", "신규 고객 감사 할인쿠폰");
			cou.put("cou_discount", 2000);

			
			int couResult=adminEventDao.addSysCou(cou);
			int eveResult=adminEventDao.addSysEve(eve);
			totalResult=couResult+eveResult;
			
			
		}else if(eidx==222) {
			eve.put("idx", eidx);
			eve.put("category", "즉시발급형");
			eve.put("subject", "MJOA 랜덤 선물 응모 이벤트");
			eve.put("main_img", "coupon_main.jpg");
			eve.put("thumb_img", "coupon_thumb.jpg");
			eve.put("start_date", "2022-10-15");
			eve.put("end_date", "2022-12-25");
			
			int eveResult=adminEventDao.addSysEve(eve);
			totalResult=eveResult+1;
			
			
			
		}else if(eidx==333) {
			eve.put("idx", eidx);
			eve.put("category", "즉시발급형");
			eve.put("subject", "401호의 탐정 개봉 기념 시사회 응모 이벤트");
			eve.put("main_img", "apply_main.jpg");
			eve.put("thumb_img", "apply_thumb.jpg");
			eve.put("start_date", "2022-10-15");
			eve.put("end_date", "2022-12-15");
			int eveResult=adminEventDao.addSysEve(eve);
			totalResult=eveResult+1;
		}
		
		return totalResult;
		
		
	}
	
	@Override
	public int delSysEve(int eve_idx) {
		
		int totalResult=0;
		System.out.println("DelSys들어온 idx값:"+eve_idx);
		if(eve_idx==111) {
			int eveResult=adminEventDao.deleteEvent(eve_idx);
			int couResult=adminEventDao.delSysCou(eve_idx);
			totalResult=eveResult+couResult;
			System.out.println("111비활성화 경우 delete Event:"+eveResult+"couResult:"+couResult);
		}else {
			int eveResult=adminEventDao.deleteEvent(eve_idx);
			totalResult=eveResult+1;
		}
		return totalResult;
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
		
		/*
		 * String todayfm = new SimpleDateFormat("yyyy-MM-dd").format(new
		 * Date(System.currentTimeMillis())); String e_d = dto.getEve_end_date();
		 * SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); try {
		 * end_date = new Date(dateFormat.parse(e_d).getTime()); } catch (ParseException
		 * e) { e.printStackTrace(); } try { today = new
		 * Date(dateFormat.parse(todayfm).getTime()); } catch (ParseException e) {
		 * e.printStackTrace(); } String status=""; int compare =
		 * start_date.compareTo(today); if(compare > 0) {
		 * System.out.println("이벤트 죵료일이 오늘 이후"); status="진행 전 이벤트"; }else if(compare <
		 * 0) { System.out.println("이벤트 죵료일이 오늘 이전"); status="진행중 이벤트"; }else {
		 * System.out.println("이벤트 종료일이 오늘"); status="종료된 이벤트"; }
		 * map.put("status",status);
		 */
		int result=adminEventDao.updateEvent(map);
		return result;
	}

	@Override
	public AdminEventDTO detailEvent(int eve_idx) {
		AdminEventDTO dto=adminEventDao.detailEvent(eve_idx);
		return dto;
	}

	@Override
	public List listEvent(int cp, int ls, String s_k, String s_v ) {
		int start=(cp-1)*ls+1;
		int end=cp*ls;
		Map map=new HashMap();
		map.put("s_k", s_k);
		map.put("s_v", s_v);
		map.put("start", start);
		map.put("end", end);
		List list=adminEventDao.listEvent(map);
		return list;
	}
	
	@Override
	public int systemEventTotalCnt(int eidx) {
		Map map=new HashMap();
		map.put("eidx", eidx);
		int result=adminEventDao.systemEventTotalCnt(map);
		return result;
	}

	@Override
	public int adminEventTotalCnt(String s_k, String s_v) {
		Map map=new HashMap();
		map.put("s_k", s_k);
		map.put("s_v", s_v);
		int result=adminEventDao.adminEventTotalCnt(map);
		return result;
	}

	@Override
	public int deleteEvent(int eve_idx) {
		int result=adminEventDao.deleteEvent(eve_idx);
		return result;
	}

	
	@Override
	public List listApplycant(int cp, int ls, String s_k, String s_v) {
		int start=(cp-1)*ls+1;
		int end=cp*ls;
		Map map=new HashMap();
		map.put("s_k", s_k);
		map.put("s_v", s_v);
		map.put("start", start);
		map.put("end", end);
		List list=adminEventDao.listApplycant(map);
		return list;
	}

	@Override
	public int adminApplycantTotalCnt(String s_k, String s_v) {
		Map map=new HashMap();
		map.put("s_k", s_k);
		map.put("s_v", s_v);
		int result=adminEventDao.adminApplycantTotalCnt(map);
		return result;
	}
	
	@Override
	public int deleteApplycant(int app_idx) {
		int result=adminEventDao.deleteApplycant(app_idx);
		return result;
	}


}

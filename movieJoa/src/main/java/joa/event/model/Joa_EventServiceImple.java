package joa.event.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import joa.adminCoupon.model.AdminCouponDTO;
import joa.adminEvent.model.AdminApplycantDTO;
import joa.adminEvent.model.AdminEventDTO;
import joa.adminMovie.model.AdminMovieDTO;
import joa.adminOwncou.model.AdminOwncouDTO;

public class Joa_EventServiceImple implements Joa_EventService{
	
	private Joa_EventDAO joa_EventDao;

	public Joa_EventServiceImple(Joa_EventDAO joa_EventDao) {
		super();
		this.joa_EventDao = joa_EventDao;
	}
	
	@Override
	public AdminEventDTO infoEvent(int eve_idx) {
		AdminEventDTO dto=joa_EventDao.infoEvent(eve_idx);
		return dto;
	}

	@Override
	public List listEvent() {
		List list=joa_EventDao.listEvent();
		return list;
	}
	
	@Override
	public List listSystemEvent() {
		List list=joa_EventDao.listSystemEvent();
		return list;
	}
	
	@Override
	public int endedEventTotalCnt() {
		int result=joa_EventDao.endedEventTotalCnt();
		return result;
	}
	
	@Override
	public List endedEvent() {
		List list=joa_EventDao.endedEvent();
		return list;
	}
	
	public AdminCouponDTO couponInfo(int cou_idx) {
		AdminCouponDTO couponInfo=joa_EventDao.couponInfo(cou_idx);
		return couponInfo;
	}

	@Override
	public int addCoupon(String sid, int cou_idx, String event_subject, int event_code) {
		
		Calendar now = Calendar.getInstance();
		int y=now.get(Calendar.YEAR);
		int m=now.get(Calendar.MONTH)+1;
		int d=now.get(Calendar.DATE);
		String today="";
		if(m<=9){
		      today=y+"-0"+m;
		   }else{
		      today=y+"-"+m;
		   }
		if(d<=9){
		      today=today+"-0"+d;
		   }else{
		      today=today+"-"+d;
		   }
		Calendar future = Calendar.getInstance();
		int y2=future.get(Calendar.YEAR);
		int m2=future.get(Calendar.MONTH)+2;
		int d2=future.get(Calendar.DATE);
		String limit_date="";
		if(m2<=9){
			limit_date=y2+"-0"+m2;
		   }else{
			   limit_date=y2+"-"+m2;
		   }
		if(d2<=9){
			limit_date=limit_date+"-0"+d2;
		   }else{
			   limit_date=limit_date+"-"+d2;
		   }
		
		AdminCouponDTO couponInfo=joa_EventDao.couponInfo(cou_idx);
		
		String couponName= couponInfo.getCou_name(); int discount=couponInfo.getCou_discount(); // ?????? ?????? ?????? ?????????(2)

		Map map=new HashMap();
		map.put("name", couponName); //- > ????????? ?????? ??????, ??? ?????? ????????? ???????????? ?????? ?????? ????????????
		map.put("member_id", sid);
		map.put("discount", discount); //- > ????????? ??????
		map.put("issue_date", today);  // ?????? ?????????
		map.put("limit_date", limit_date); // ?????? ????????????
		map.put("event_code", event_code);
		map.put("event_subject", event_subject);
		
		 int getCouponResult=joa_EventDao.addCoupon(map); // ?????? ????????? ?????? ?????????
		 System.out.println("getCouponResult:"+getCouponResult);
		 int addApplyResult=joa_EventDao.addApply(map); // ????????? ?????? ?????? ?????? ?????????
		 System.out.println("addApplyResult:"+addApplyResult);
		 int totalResult = getCouponResult + addApplyResult;
		 System.out.println("totalResult:"+totalResult);
		return totalResult;
		
	}

	@Override
	public int getPoint(String sid, String event_subject, int event_code ) {
		Map map = new HashMap();
		
		 
		map.put("event_code", event_code);
		map.put("event_subject", event_subject);
		map.put("member_id", sid);

		int userPoint=joa_EventDao.userPoint(sid);
		System.out.println("?????? userPoint:"+userPoint);
		
		int eventPoint=2000;
		int totalPoint = userPoint + eventPoint ; // ?????? ???????????? ????????? ???????????? ?????????
		
		map.put("totalPoint", totalPoint);
		
		 int getPointResult=joa_EventDao.getPoint(map);
		 System.out.println("getPoint ?????? ?????? ??????:"+getPointResult);
		 int applyResult=joa_EventDao.addApply(map);
		 System.out.println("applyResult ?????? ?????? ??????:"+applyResult);
		 
		 int totalResult=applyResult+getPointResult;// ?????? ?????? ?????? ?????? ??? ????????? 2?????? ????????? ????????????.
		 System.out.println("totalResult:???, ????????? ?????? ?????? ?????? (?????????)"+totalResult);
		return totalResult;
	}
	
	@Override
	public int addApply(String sid, int event_code, String event_subject) {
		
		Map map=new HashMap();
		
		map.put("event_code", event_code);// ???????????? ????????? ????????? ???????????? ???????????? ????????? ????????? ????????? ??????.
		map.put("event_subject", event_subject);
		map.put("member_id", sid);
		
		int result=joa_EventDao.addApply(map);
		return result;
	}

	@Override
	public int checkApply(String sid, int event_code) {
		Map map=new HashMap();

		map.put("member_id", sid);
		map.put("event_code", event_code);
		int result=joa_EventDao.checkApply(map);
		return result;
	}

	@Override
	public int userPoint(String member_id) {
		// TODO Auto-generated method stub
		int userPoint=joa_EventDao.userPoint(member_id);
		return userPoint;
	}
	
	/*
	 * @Override public int getPoint(JOA_MemberDTO dto) { // TODO Auto-generated
	 * method stub Map map=new HashMap();
	 * 
	 * ////???????????? ?????? ?????? ?????? map.put("idx", dto.getMov_idx()); map.put("title",
	 * dto.getMov_title()); map.put("director", dto.getMov_director());
	 * map.put("cast", dto.getMov_cast()); map.put("start_date",
	 * dto.getMov_start_date()); map.put("end_date", dto.getMov_end_date());
	 * map.put("country", dto.getMov_country()); map.put("genre",
	 * dto.getMov_genre()); map.put("running_time", dto.getMov_running_time());
	 * map.put("rate", dto.getMov_rate()); map.put("info", dto.getMov_info());
	 * map.put("poster", dto.getMov_poster());
	 * 
	 * int result=adminMovieDao.updateMovie(map);
	 * 
	 * System.out.println("service??? result:"+result); return result; }
	 */

}

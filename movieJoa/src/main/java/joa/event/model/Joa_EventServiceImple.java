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
		
		String couponName= couponInfo.getCou_name(); int discount=couponInfo.getCou_discount(); // 쿠폰 정보 호출 메서드(2)

		Map map=new HashMap();
		map.put("name", couponName); //- > 테이블 조인 또는, 또 다른 메서드 처리하여 나온 결과 보여주기
		map.put("member_id", sid);
		map.put("discount", discount); //- > 테이블 조인
		map.put("issue_date", today);  // 쿠폰 발급일
		map.put("limit_date", limit_date); // 쿠폰 유효기간
		map.put("event_code", event_code);
		map.put("event_subject", event_subject);
		
		 int getCouponResult=joa_EventDao.addCoupon(map); // 쿠폰 테이블 등록 메서드
		 System.out.println("getCouponResult:"+getCouponResult);
		 int addApplyResult=joa_EventDao.addApply(map); // 이벤트 참여 기록 갱신 메서드
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
		System.out.println("기존 userPoint:"+userPoint);
		
		int eventPoint=2000;
		int totalPoint = userPoint + eventPoint ; // 기존 포인트에 부여할 포인트를 더해줌
		
		map.put("totalPoint", totalPoint);
		
		 int getPointResult=joa_EventDao.getPoint(map);
		 System.out.println("getPoint 쿼리 실행 결과:"+getPointResult);
		 int applyResult=joa_EventDao.addApply(map);
		 System.out.println("applyResult 쿼리 실행 결과:"+applyResult);
		 
		 int totalResult=applyResult+getPointResult;// 두번 모두 정상 실행 된 결과를 2라는 결과로 반환한다.
		 System.out.println("totalResult:즉, 메서드 전체 실행 결과 (반환값)"+totalResult);
		return totalResult;
	}
	
	@Override
	public int addApply(String sid, int event_code, String event_subject) {
		
		Map map=new HashMap();
		
		map.put("event_code", event_code);// 관리자가 등록한 이벤트 테이블에 존재하지 않으니 조회에 의미가 없다.
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
	 * ////여기부터 멤버 컬럼 수정 map.put("idx", dto.getMov_idx()); map.put("title",
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
	 * System.out.println("service단 result:"+result); return result; }
	 */

}

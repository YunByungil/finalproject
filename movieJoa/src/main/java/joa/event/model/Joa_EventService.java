package joa.event.model;

import java.util.List;

import joa.adminCoupon.model.AdminCouponDTO;
import joa.adminEvent.model.AdminEventDTO;
import joa.adminMovie.model.AdminMovieDTO;
import joa.adminOwncou.model.AdminOwncouDTO;

public interface Joa_EventService {
	
	public AdminEventDTO infoEvent(int eve_idx);
	public List<AdminEventDTO> listEvent();
	public int endedEventTotalCnt();
	public List<AdminEventDTO> endedEvent();
	public AdminCouponDTO couponInfo(int cou_idx);
	public int addCoupon(String sid, int cou_idx, String event_subject, int event_code);
	public int getPoint(String sid,  String event_subject, int event_code);
	public int addApply(String sid, int event_code, String event_subject);
	public int checkApply(String sid, int event_code);
	public int userPoint(String sid);
	
	
	

}

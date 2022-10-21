package joa.event.model;

import java.util.List;
import java.util.Map;

import joa.adminCoupon.model.AdminCouponDTO;
import joa.adminEvent.model.AdminEventDTO;

public interface Joa_EventDAO {
	

	public AdminEventDTO infoEvent(int eve_idx);
	public List<AdminEventDTO> listEvent();
	public int endedEventTotalCnt();
	public List<AdminEventDTO> endedEvent();
	public AdminCouponDTO couponInfo(int cou_idx);
	public int addCoupon(Map map);
	public int getPoint(Map map);
	public int addApply(Map map);
	public int userPoint (String member_id);
	public int checkApply(Map map);

}

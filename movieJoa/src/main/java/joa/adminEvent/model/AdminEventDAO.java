package joa.adminEvent.model;

import java.util.List;
import java.util.Map;

public interface AdminEventDAO {
	
	public int addEvent(Map map);
	public int updateEvent(Map map);
	public AdminEventDTO detailEvent(int eve_idx);
	public List<AdminEventDTO> listEvent(Map map);
	public int adminEventTotalCnt();
	public int deleteEvent(int eve_idx);
	public List searchEvent(Map map);
	
	public int adminApplycantTotalCnt();
	public List<AdminApplycantDTO> listApplycant(Map map);
	public int deleteApplycant(int app_idx);
	

}

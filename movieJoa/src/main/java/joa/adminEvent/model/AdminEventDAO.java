package joa.adminEvent.model;

import java.util.List;
import java.util.Map;

public interface AdminEventDAO {
	
	public int addEvent(Map map);
	public int addSysEve(Map map);
	public int addSysCou(Map map);
	public int updateEvent(Map map);
	public AdminEventDTO detailEvent(int eve_idx);
	public List<AdminEventDTO> listEvent(Map map);
	public int adminEventTotalCnt(Map map);
	public int systemEventTotalCnt(Map map);
	public int deleteEvent(int eve_idx);
	public int delSysCou(int eve_idx);
	public int adminApplycantTotalCnt(Map map);
	public List<AdminApplycantDTO> listApplycant(Map map);
	public int deleteApplycant(int app_idx);
	

}

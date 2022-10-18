package joa.adminEvent.model;

import java.util.*;

public interface AdminEventService {
	
	public int addEvent(AdminEventDTO dto);
	public int updateEvent(AdminEventDTO dto);
	public AdminEventDTO detailEvent(int eve_idx);
	public List<AdminEventDTO> listEvent(int cp, int ls);
	public int adminEventTotalCnt();
	public int deleteEvent(int eve_idx);
	public List searchEvent(String sc_t, String sc_k);
	
	public int adminApplycantTotalCnt();
	public List<AdminApplycantDTO> listApplycant(int cp, int ls);
	public int deleteApplycant(int app_idx);
	
}

package joa.adminEvent.model;

import java.util.*;

public interface AdminEventService {
	
	public int addEvent(AdminEventDTO dto);
	public int updateEvent(AdminEventDTO dto);
	public AdminEventDTO detailEvent(int eve_idx);
	public List<AdminEventDTO> listEvent(int cp, int ls, String s_k, String s_v);
	public int adminEventTotalCnt(String s_k, String s_v);
	public int deleteEvent(int eve_idx);
	
	public int adminApplycantTotalCnt(String s_k, String s_v);
	public List<AdminApplycantDTO> listApplycant(int cp, int ls, String s_k, String s_v);
	public int deleteApplycant(int app_idx);
	
}

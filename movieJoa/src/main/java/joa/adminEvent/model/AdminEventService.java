package joa.adminEvent.model;

import java.util.*;

public interface AdminEventService {
	
	public int addEvent(AdminEventDTO dto);
	public int addSysEve(int eidx);
	public int delSysEve(int eve_idx);
	public int updateEvent(AdminEventDTO dto);
	public AdminEventDTO detailEvent(int eve_idx);
	public List<AdminEventDTO> listEvent(int cp, int ls, String s_k, String s_v);
	public int adminEventTotalCnt(String s_k, String s_v);
	public int systemEventTotalCnt(int eidx);
	public int deleteEvent(int eve_idx);
	public int adminApplycantTotalCnt(String s_k, String s_v);
	public List<AdminApplycantDTO> listApplycant(int cp, int ls, String s_k, String s_v);
	public int deleteApplycant(int app_idx);
	public List listLuck_mem_extraction(int app_event_code, int member_count);
	public int e_b_table_insert(AdminEventLuckBoardDTO dto);
	
}

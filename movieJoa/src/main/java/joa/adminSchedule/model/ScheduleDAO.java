package joa.adminSchedule.model;

import java.util.*;

import joa.adminTheater.model.TheaterDTO;
import joa.adminMem.model.JoaAdminMemberDTO;

public interface ScheduleDAO {
	public List checkSchedule(Map map);
	public List dayChoice(String day);
	public List theaterChoice(Map ad);
	public TheaterDTO seatSearch(Map seatInfo);
	public int scheduleInsert(ScheduleDTO dto);
	public int scheduleCount(String day,String city,String branch);
	public List<ScheduleDTO> scheduleList(int cp,int ls,String day,String city,String branch);
	public List<ScheduleDTO> branchCheck(Map map);
	public int runtimeCheck(String title);
	public int scheduleDelete(int idx);
	
}
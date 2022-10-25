package joa.adminSchedule.model;

import java.util.*;

import joa.adminMember.model.JoaAdminMemberDTO;
import joa.adminTheater.model.TheaterDTO;

public interface ScheduleDAO {
	public List checkSchedule(Map map);
	public List dayChoice(String day);
	public List theaterChoice(Map ad);
	public TheaterDTO seatSearch(Map seatInfo);
	public int scheduleInsert(ScheduleDTO dto);
	public int scheduleCount(String day);
	public List<ScheduleDTO> scheduleList(int cp,int ls,String day);
	
}
package joa.adminSchedule.model;

import java.util.*;

public interface ScheduleDAO {
	public List checkSchedule(Map map);
	public List dayChoice(String day);
	public List theaterChoice(Map ad);
}
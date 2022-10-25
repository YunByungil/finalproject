package joa.book.model;
import java.util.*;
public interface JoaBookDAO {
	
	public List<JoaBookDTO> moviesSubjectList();
	public List<JoaBookDTO> moviesBranchList(String sch_mov_title);
	public List<JoaBookDTO> moveisDateList(HashMap map);
	public List<JoaBookDTO> moveisTimeList(HashMap map);
	///////////////////////////////////////////////////////
	public List<JoaBookDTO> theaterBranchList(String sch_city);
	public List<JoaBookDTO> theaterDay(HashMap map);
}

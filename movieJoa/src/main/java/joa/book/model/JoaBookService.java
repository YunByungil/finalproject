package joa.book.model;
import java.util.*;
public interface JoaBookService {

	public List<JoaBookDTO> moviesSubjectList();
	public List<JoaBookDTO> moviesBranchList(String sch_mov_title);
	public List<JoaBookDTO> moveisDateList(String sch_mov_title,String sch_branch);
	public List<JoaBookDTO> moveisTimeList(String sch_mov_title,String sch_branch,String sch_day);
	///////////////////////////////////////////////////////theaterSQL
	public List<JoaBookDTO> theaterBranchList(String sch_city);
	public List<JoaBookDTO> theaterDay(String sch_city, String sch_branch);
}

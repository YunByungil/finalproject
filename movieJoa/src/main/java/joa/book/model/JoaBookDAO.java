package joa.book.model;
import java.util.*;

import joa.adminMovie.model.AdminMovieDTO;
import joa.pay.model.*;
import joa.theater.model.TheaterTimeDTO;
public interface JoaBookDAO {
	
	public AdminMovieDTO moivePoster(String sch_mov_title);
	
	public List<JoaBookDTO> moviesSubjectList();
	public List<JoaBookDTO> moviesBranchList(String sch_mov_title);
	public List<JoaBookDTO> moveisDateList(HashMap map);
	public List<JoaBookDTO> moveisTimeList(HashMap map);
	///////////////////////////////////////////////////////
	public List<JoaBookDTO> theaterBranchList(String sch_city);
	public List<JoaBookDTO> theaterDay(HashMap map);
	
	/////seat 불러오기(JoaBookController)
	public List<JoaBookDTO> seatList(HashMap map);
	
	/////////////////realtime
	public List<JoaBookDTO> realTimeList(HashMap map);
	
	public List<JoaPayMovDTO> seatBook(JoaBookDTO dto);
}

package joa.adminTheater.model;

import java.util.List;
import java.util.Map;

import joa.adminMember.model.JoaAdminMemberDTO;

public interface TheaterDAO {

	  public int theaterAdd(TheaterDTO dto);
	  public List theaterCheck(Map timap);
	  public JoaAdminMemberDTO adminIdSearch(String sid);
	  public List<TheaterDTO> theaterListView(Map map);
	  public int theaterDelete(int idx);
}

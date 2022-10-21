package joa.adminOwncou.model;

import java.util.List;
import java.util.Map;

public interface AdminOwncouDAO {
	public int adminOwncouTotalCnt(Map map);
	public List<AdminOwncouDTO> listOwncou(Map map);
	public int deleteOwncou(int own_idx);
}

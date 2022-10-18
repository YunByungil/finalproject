package joa.adminOwncou.model;

import java.util.List;

public interface AdminOwncouService {
	public int adminOwncouTotalCnt();
	public List<AdminOwncouDTO> listOwncou(int cp, int ls);
	public int deleteOwncou(int own_idx);

}

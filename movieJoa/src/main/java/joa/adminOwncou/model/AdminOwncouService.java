package joa.adminOwncou.model;

import java.util.List;

public interface AdminOwncouService {
	public int adminOwncouTotalCnt(String s_k, String s_v);
	public List<AdminOwncouDTO> listOwncou(int cp, int ls,  String s_k, String s_v);
	public int deleteOwncou(int own_idx);

}

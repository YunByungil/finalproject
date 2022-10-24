package joa.helpdesk.model;

import java.util.*;

public interface JoaNTService {
	
   public int addNotice(JoaNoticeDTO dto);
	
	public int deleteNotice(int idx);
	
	public int rewriteNotice(JoaNoticeDTO dto);
	
	public List<JoaNoticeDTO> NoticeList(int cp, int ls);
	
	public List<JoaNoticeDTO> noticeType(String type,int cp, int ls);
	
	public List<JoaNoticeDTO> serchNoticeList(String keyword,int cp, int ls);
	
	public JoaNoticeDTO noticeBorder(int idx);
	
	public int noticeTotalCnt();
	
	public int serchNoticeTotalCnt(String type);
	
	public int noticeTypeTotalCnt(String keyword);
}

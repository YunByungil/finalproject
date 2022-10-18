package joa.helpdesk.model;

import java.util.*;

public interface JoaNoticeDAO {
	
	public int addNotice(JoaNoticeDTO dto);
	
	public int deleteNotice(int idx);
	
	public int rewriteNotice(JoaNoticeDTO dto);
	
	public List<JoaNoticeDTO> NoticeList();
	
	public List<JoaNoticeDTO> serchNoticeList(String type);
	
	public JoaNoticeDTO noticeBorder(int idx);
}

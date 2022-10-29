package joa.helpdesk.model;

import java.util.*;

public class JoaNTServiceImple implements JoaNTService {
	
	private JoaNoticeDAO JoaNoticeDao;
	
	public JoaNTServiceImple(JoaNoticeDAO joaNoticeDao) {
		super();
		JoaNoticeDao = joaNoticeDao;
	}
	
	@Override
	public void upDateReadNum(int idx) {
	
		JoaNoticeDao.upDateReadNum(idx);
	}

	@Override
	public int addNotice(JoaNoticeDTO dto) {
		int result = JoaNoticeDao.addNotice(dto);
		return result;
	}

	@Override
	public int deleteNotice(int idx) {
		int result = JoaNoticeDao.deleteNotice(idx);
		return result;
	}

	@Override
	public int rewriteNotice(JoaNoticeDTO dto) {
		int result = JoaNoticeDao.rewriteNotice(dto);
		return result;
	}

	@Override
	public List<JoaNoticeDTO> NoticeList(int cp, int ls) {
		int start = (cp-1)*ls+1;
		int end = cp*ls;
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		List<JoaNoticeDTO> list = JoaNoticeDao.NoticeList(map);
		return list;
	}

	@Override
	public List<JoaNoticeDTO> serchNoticeList(String keyword, int cp, int ls) {
		int start = (cp-1)*ls+1;
		int end = cp*ls;
		Map map = new HashMap();
		map.put("keyword", keyword);
		map.put("start", start);
		map.put("end", end);
		List<JoaNoticeDTO> list = JoaNoticeDao.serchNoticeList(map);
		return list;
	}

	@Override
	public JoaNoticeDTO noticeBorder(int idx) {
		JoaNoticeDTO dto = JoaNoticeDao.noticeBorder(idx);
		return dto;
	}
	
	@Override
	public List<JoaNoticeDTO> noticeType(String type, int cp, int ls) {
		int start = (cp-1)*ls+1;
		int end = cp*ls;
		Map map = new HashMap();
		map.put("type", type);
		map.put("start", start);
		map.put("end", end);
		List<JoaNoticeDTO> list = JoaNoticeDao.noticeType(map);
		return list;
	}
	
	@Override
	public int noticeTotalCnt() {
		int count = JoaNoticeDao.noticeTotalCnt();
		return count;
	}
	@Override
	public int serchNoticeTotalCnt(String keyword) {
		Map map = new HashMap();
		map.put("keyword", keyword);
		int count = JoaNoticeDao.serchNoticeTotalCnt(map);
		return count;
	}
	@Override
	public int noticeTypeTotalCnt(String type) {
		Map map = new HashMap();
		map.put("type", type);
		int count = JoaNoticeDao.noticeTypeTotalCnt(map);
		return count;
	}
}

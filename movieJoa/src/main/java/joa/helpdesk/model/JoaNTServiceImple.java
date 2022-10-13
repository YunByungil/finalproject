package joa.helpdesk.model;

import java.util.*;

public class JoaNTServiceImple implements JoaNTService {
	
	private JoaNoticeDAO JoaNoticeDao;
	
	public JoaNTServiceImple(JoaNoticeDAO joaNoticeDao) {
		super();
		JoaNoticeDao = joaNoticeDao;
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
	public List<JoaNoticeDTO> NoticeList() {
		List<JoaNoticeDTO> list = JoaNoticeDao.NoticeList();
		return list;
	}

	@Override
	public List<JoaNoticeDTO> serchNoticeList(String type) {
		List<JoaNoticeDTO> list = JoaNoticeDao.serchNoticeList(type);
		return list;
	}

	@Override
	public JoaNoticeDTO noticeBorder(int idx) {
		JoaNoticeDTO dto = JoaNoticeDao.noticeBorder(idx);
		return dto;
	}

}

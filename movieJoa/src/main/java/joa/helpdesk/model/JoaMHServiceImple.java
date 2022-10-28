package joa.helpdesk.model;

import java.util.*;

public class JoaMHServiceImple implements JoaMHService {
	
	private JoaManyHelpDAO JoaManyHelpDao;
	
	public JoaMHServiceImple(JoaManyHelpDAO joaManyHelpDao) {
		super();
		JoaManyHelpDao = joaManyHelpDao;
	}
	
	@Override
	public void upDateReadNum(int idx) {
		JoaManyHelpDao.upDateReadNum(idx);
	}
	
	@Override
	public int addManyHelp(JoaManyHelpDTO dto) {
		int result = JoaManyHelpDao.addManyHelp(dto);
		return result;
	}

	@Override
	public int deleteManyHelp(int idx) {
		int result = JoaManyHelpDao.deleteManyHelp(idx);
		return result;
	}

	@Override
	public int rewriteManyHelp(JoaManyHelpDTO dto) {
		int result = JoaManyHelpDao.rewriteManyHelp(dto);
		return result;
	}

	@Override
	public List<JoaManyHelpDTO> ManyHelpList(int cp, int ls) {
		int start = (cp-1)*ls+1;
		int end = cp*ls;
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		List<JoaManyHelpDTO> list = JoaManyHelpDao.ManyHelpList(map);
		return list;
	}

	@Override
	public List<JoaManyHelpDTO> manyHelpType(String type,int cp, int ls) {
		int start = (cp-1)*ls+1;
		int end = cp*ls;
		Map map = new HashMap();
		map.put("type", type);
		map.put("start", start);
		map.put("end", end);
		
		List<JoaManyHelpDTO> list = JoaManyHelpDao.manyHelpType(map);
		return list;
	}

	@Override
	public JoaManyHelpDTO ManyHelpBorder(int idx) {
		JoaManyHelpDTO dto = JoaManyHelpDao.ManyHelpBorder(idx);
		return dto;
	}
	
	@Override
	public List<JoaManyHelpDTO> serchManyHelpList(String keyword,int cp, int ls) {
		int start = (cp-1)*ls+1;
		int end = cp*ls;
		Map map = new HashMap();
		map.put("keyword", keyword);
		map.put("start", start);
		map.put("end", end);
		List<JoaManyHelpDTO> list = JoaManyHelpDao.serchManyHelpList(map);
		return list;
	}
	
	@Override
	public int manyHelpListTotalCnt() {
		int count = JoaManyHelpDao.manyHelpListTotalCnt();
		return 0;
	}
	@Override
	public int serchManyHelpListTotalCnt(String keyword) {
		Map map = new HashMap();
		map.put("keyword", keyword);
		int count = JoaManyHelpDao.serchManyHelpListTotalCnt(map);
		return count;
	}
	@Override
	public int manyHelpTypeTotalCnt(String type) {
		Map map = new HashMap();
		map.put("type", type);
		int count = JoaManyHelpDao.manyHelpTypeTotalCnt(map);
		return count;
	}

}

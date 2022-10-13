package joa.helpdesk.model;

import java.util.*;

public class JoaMHServiceImple implements JoaMHService {
	
	private JoaManyHelpDAO JoaManyHelpDao;
	
	public JoaMHServiceImple(JoaManyHelpDAO joaManyHelpDao) {
		super();
		JoaManyHelpDao = joaManyHelpDao;
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
	public List<JoaManyHelpDTO> ManyHelpList() {
		List<JoaManyHelpDTO> list = JoaManyHelpDao.ManyHelpList();
		return list;
	}

	@Override
	public List<JoaManyHelpDTO> serchManyHelpList(String type) {
		List<JoaManyHelpDTO> list = JoaManyHelpDao.serchManyHelpList(type);
		return list;
	}

	@Override
	public JoaManyHelpDTO ManyHelpBorder(int idx) {
		JoaManyHelpDTO dto = JoaManyHelpDao.ManyHelpBorder(idx);
		return dto;
	}

}

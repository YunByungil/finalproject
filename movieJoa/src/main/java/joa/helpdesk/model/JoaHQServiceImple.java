package joa.helpdesk.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JoaHQServiceImple implements JoaHQService {
	
	private JoaHelpQuestionDAO JoaHelpQuestionDao;
	
	
	public JoaHQServiceImple(JoaHelpQuestionDAO joaHelpQuestionDao) {
		super();
		JoaHelpQuestionDao = joaHelpQuestionDao;
	}
	
	public JoaHQServiceImple() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addQuestion(JoaHelpQuestionDTO dto) {
		int result = JoaHelpQuestionDao.addQuestion(dto);
		
		return result;
	}


	@Override
	public int addEmailQuestion(JoaHelpQuestionDTO dto) {
		int result = JoaHelpQuestionDao.addEmailQuestion(dto);
		return result;
	}

	@Override
	public List<JoaHelpQuestionDTO> topQuestionList(int cp, int ls) {
		int start = (cp-1)*ls+1;
		int end = cp*ls;
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		List<JoaHelpQuestionDTO> list = JoaHelpQuestionDao.topQuestionList(map);
		return list;
	}
	
	@Override
	public int topQuestionTotalCnt() {
		int count = JoaHelpQuestionDao.topQuestionTotalCnt();
		return count;
	}
	
	@Override
	public List<JoaHelpQuestionDTO> questionList(String state, int cp, int ls) {
		int start = (cp-1)*ls+1;
		int end = cp*ls;
		Map<String, Object> map = new HashMap<>();
		map.put("state", state);
		map.put("start", start);
		map.put("end", end);
		List<JoaHelpQuestionDTO> list = JoaHelpQuestionDao.questionList(map);
		return list;
	}
	
	@Override
	public int questionTotalCnt(String state) {
		int count = JoaHelpQuestionDao.questionTotalCnt(state);
		return count;
	}
	
	@Override
	public List<JoaHelpQuestionDTO> questionTypeList(String state, String hqt_type, int cp, int ls) {
		int start = (cp-1)*ls+1;
		int end = cp*ls;
		Map<String, Object> map = new HashMap<>();
		map.put("state", state);
		map.put("hqt_type", hqt_type);
		map.put("start", start);
		map.put("end", end);
		List<JoaHelpQuestionDTO> list = JoaHelpQuestionDao.questionTypeList(map);
		return list;
	}
	
	@Override
	public int questionTypeTotalCnt(String hqt_type, String state) {
		Map<String, Object> map = new HashMap<>();
		map.put("state", state);
		map.put("hqt_type", hqt_type);
		int count = JoaHelpQuestionDao.questionTypeTotalCnt(map);
		return count;
	}

	@Override
	public List<JoaHelpQuestionDTO> serchQuestionList(String state, String hqt_type, String hqt_region, String hqt_cinema,int cp, int ls) {
		int start = (cp-1)*ls+1;
		int end = cp*ls;
		Map<String, Object> map = new HashMap<>();
		map.put("state", state);
		map.put("hqt_type", hqt_type);
		map.put("hqt_region", hqt_region);
		map.put("hqt_cinema", hqt_cinema);
		map.put("start", start);
		map.put("end", end);
		List<JoaHelpQuestionDTO> list = JoaHelpQuestionDao.serchQuestionList(map);
		return list;
	}
	
	@Override
	public int serchQuestionTotalCnt(String state, String hqt_type, String hqt_region, String hqt_cinema) {
		Map map = new HashMap();
		map.put("hqt_type", hqt_type);
		map.put("state", state);
		map.put("hqt_region", hqt_region);
		map.put("hqt_cinema", hqt_cinema);
		int count = JoaHelpQuestionDao.serchQuestionTotalCnt(map);
		return count;
	}


	@Override
	public int answerQuestion(JoaHelpQuestionDTO dto) {
		int result = JoaHelpQuestionDao.answerQuestion(dto);
		return result;
	}

	@Override
	public int reanswerQuestion(JoaHelpQuestionDTO dto) {
		int result = JoaHelpQuestionDao.reanswerQuestion(dto);
		return result;
	}

	@Override
	public JoaHelpQuestionDTO questionBorder(int idx) {
		JoaHelpQuestionDTO dto = JoaHelpQuestionDao.questionBorder(idx);
		return dto;
	}
	
	@Override
	public List<JoaHelpQuestionDTO> emailList(String state, int cp, int ls) {
		
		int start = (cp-1)*ls+1;
		int end = cp*ls;
		Map<String, Object> map = new HashMap<>();
		map.put("state", state);
		map.put("start", start);
		map.put("end", end);
		List<JoaHelpQuestionDTO> list = JoaHelpQuestionDao.emailList(map);
		return list;
	}
	
	@Override
	public int emailTotalCnt(String state) {
		int count = JoaHelpQuestionDao.emailTotalCnt(state);
		return count;
	}
	
	@Override
	public List<JoaHelpQuestionDTO> emailTypeList(String state, String hqt_type, int cp, int ls) {
		int start = (cp-1)*ls+1;
		int end = cp*ls;
		Map<String, Object> map = new HashMap<>();
		map.put("state", state);
		map.put("hqt_type", hqt_type);
		map.put("start", start);
		map.put("end", end);
		List<JoaHelpQuestionDTO> list = JoaHelpQuestionDao.emailTypeList(map);
		return list;
	}
	
	@Override
	public int emailTypeTotalCnt(String hqt_type, String state) {
		Map<String, Object> map = new HashMap<>();
		map.put("state", state);
		map.put("hqt_type", hqt_type);
		int count = JoaHelpQuestionDao.emailTypeTotalCnt(map);
		return count;
	}
	
	@Override
	public List<JoaHelpQuestionDTO> emailSerchList(String state, String hqt_type, String hqt_region, String hqt_cinema,
			int cp, int ls) {
		int start = (cp-1)*ls+1;
		int end = cp*ls;
		Map<String, Object> map = new HashMap<>();
		map.put("state", state);
		map.put("hqt_type", hqt_type);
		map.put("hqt_region", hqt_region);
		map.put("hqt_cinema", hqt_cinema);
		map.put("start", start);
		map.put("end", end);
		List<JoaHelpQuestionDTO> list = JoaHelpQuestionDao.emailSerchList(map);
		return list;
	}
	
	@Override
	public int emailSerchTotalCnt(String state, String hqt_type, String hqt_region, String hqt_cinema) {
		Map<String, Object> map = new HashMap<>();
		map.put("state", state);
		map.put("hqt_type", hqt_type);
		map.put("hqt_region", hqt_region);
		map.put("hqt_cinema", hqt_cinema);
		int count = JoaHelpQuestionDao.emailSerchTotalCnt(map);
		return count;
	}
	
	@Override
	public List<JoaHelpQuestionDTO> topQuestionTypeList(String hqt_type, int cp, int ls) {
		int start = (cp-1)*ls+1;
		int end = cp*ls;
		Map<String, Object> map = new HashMap<>();
		map.put("hqt_type", hqt_type);
		map.put("start", start);
		map.put("end", end);
		List<JoaHelpQuestionDTO> list = JoaHelpQuestionDao.topQuestionTypeList(map);
		return list;
	}
	
	@Override
	public int topQuestionTypeTotalCnt(String hqt_type) {
		int count = JoaHelpQuestionDao.topQuestionTypeTotalCnt(hqt_type);
		return count;
	}
	
	@Override
	public List<JoaHelpQuestionDTO> topSerchQuestionList(String hqt_type, String hqt_region, String hqt_cinema,
			String hqt_state, int cp, int ls) {
		int start = (cp-1)*ls+1;
		int end = cp*ls;
		Map<String, Object> map = new HashMap<>();
		map.put("hqt_type", hqt_type);
		map.put("hqt_region", hqt_region);
		map.put("hqt_cinema", hqt_cinema);
		map.put("hqt_state", hqt_state);
		map.put("start", start);
		map.put("end", end);
		List<JoaHelpQuestionDTO> list = JoaHelpQuestionDao.topSerchQuestionList(map);
		return list;
	}
	
	@Override
	public int topSerchQuestionTotalCnt(String hqt_type, String hqt_region, String hqt_cinema, String hqt_state) {
		Map map = new HashMap();
		map.put("hqt_type", hqt_type);
		map.put("hqt_region", hqt_region);
		map.put("hqt_cinema", hqt_cinema);
		map.put("hqt_state", hqt_state);
		int count = JoaHelpQuestionDao.topSerchQuestionTotalCnt(map);
		return count;
	}
}

package joa.helpdesk.model;

import java.util.List;

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
	public List<JoaHelpQuestionDTO> QuestionList() {
		List<JoaHelpQuestionDTO> list = JoaHelpQuestionDao.QuestionList();
		return list;
	}

	@Override
	public List<JoaHelpQuestionDTO> serchQuestionList(String type, String state, String region, String cinema) {
		List<JoaHelpQuestionDTO> list = JoaHelpQuestionDao.serchQuestionList(type, state, region, cinema);
		return list;
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
	public JoaHelpQuestionDTO QuestionBorder(int idx) {
		JoaHelpQuestionDTO dto = JoaHelpQuestionDao.QuestionBorder(idx);
		return dto;
	}


}

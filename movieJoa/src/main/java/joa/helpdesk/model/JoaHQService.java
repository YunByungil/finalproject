package joa.helpdesk.model;

import java.util.List;

public interface JoaHQService {
	
	public int addQuestion(JoaHelpQuestionDTO dto);
	
	public int addEmailQuestion(JoaHelpQuestionDTO dto);
	
	public List<JoaHelpQuestionDTO> QuestionList();
	
	public List<JoaHelpQuestionDTO> serchQuestionList(String type,String state, String region, String cinema);
	
	public JoaHelpQuestionDTO QuestionBorder(int idx);
	
	public int answerQuestion(JoaHelpQuestionDTO dto);
	
	public int reanswerQuestion(JoaHelpQuestionDTO dto);
	
}

package joa.helpdesk.model;

import java.util.*;

public interface JoaHelpQuestionDAO {
	
	public int addQuestion(JoaHelpQuestionDTO dto);
	
	public int addEmailQuestion(JoaHelpQuestionDTO dto);
	
	public List<JoaHelpQuestionDTO> topQuestionList(Map map);
	
	public int topQuestionTotalCnt();
	
	public List<JoaHelpQuestionDTO> emailList(Map map);
	
	public int emailTotalCnt(String state);
	
	public List<JoaHelpQuestionDTO> emailTypeList(Map map);
	
	public int emailTypeTotalCnt(Map map);
	
	public List<JoaHelpQuestionDTO> emailSerchList(Map map);
	
	public int emailSerchTotalCnt(Map map);
	
	public JoaHelpQuestionDTO questionBorder(int idx);
	
	public int answerQuestion(JoaHelpQuestionDTO dto);
	
	public int reanswerQuestion(JoaHelpQuestionDTO dto);
	
	public List<JoaHelpQuestionDTO> questionList(Map map);
	
	public int questionTotalCnt(String state);
	
	public List<JoaHelpQuestionDTO> questionTypeList(Map map);
	
	public int questionTypeTotalCnt(Map map);
	
	public List<JoaHelpQuestionDTO> serchQuestionList(Map map);
	
	public int serchQuestionTotalCnt(Map map);
	
	public List<JoaHelpQuestionDTO> topQuestionTypeList(Map map);
	
	public int topQuestionTypeTotalCnt(String hqt_type);
	
	public List<JoaHelpQuestionDTO> topSerchQuestionList(Map map);
	
	public int topSerchQuestionTotalCnt(Map map);
	
}

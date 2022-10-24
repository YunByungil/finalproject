package joa.helpdesk.model;

import java.util.List;
import java.util.Map;

public interface JoaHQService {
	
	public int addQuestion(JoaHelpQuestionDTO dto);
	
	public int addEmailQuestion(JoaHelpQuestionDTO dto);
	
	public List<JoaHelpQuestionDTO> topQuestionList(int cp, int ls);
	
	public int topQuestionTotalCnt();
	
	public JoaHelpQuestionDTO questionBorder(int idx);
	
	public int answerQuestion(JoaHelpQuestionDTO dto);
	
	public int reanswerQuestion(JoaHelpQuestionDTO dto);
	
	public List<JoaHelpQuestionDTO> emailList(String state,int cp, int ls);
	
	public int emailTotalCnt(String state);
	
	public List<JoaHelpQuestionDTO> emailTypeList(String state, String hqt_type,int cp, int ls);
	
	public int emailTypeTotalCnt(String hqt_type, String state);
	
	public List<JoaHelpQuestionDTO> emailSerchList(String state, String hqt_type, String hqt_region, String hqt_cinema,int cp, int ls);
	
	public int emailSerchTotalCnt(String state, String hqt_type, String hqt_region, String hqt_cinema);
	
	public List<JoaHelpQuestionDTO> questionList(String state,int cp, int ls);
	
	public int questionTotalCnt(String state);
	
	public List<JoaHelpQuestionDTO> questionTypeList(String state, String hqt_type,int cp, int ls);
	
	public int questionTypeTotalCnt(String hqt_type, String state);
	
	public List<JoaHelpQuestionDTO> serchQuestionList(String state, String hqt_type, String hqt_region, String hqt_cinema,int cp, int ls);
	
	public int serchQuestionTotalCnt(String state, String hqt_type, String hqt_region, String hqt_cinema);
	
	public List<JoaHelpQuestionDTO> topQuestionTypeList(String hqt_type,int cp, int ls);
	
	public int topQuestionTypeTotalCnt(String hqt_type);
	
	public List<JoaHelpQuestionDTO> topSerchQuestionList(String hqt_type, String hqt_region, String hqt_cinema, String hqt_state, int cp, int ls);
	
	public int topSerchQuestionTotalCnt(String hqt_type, String hqt_region, String hqt_cinema, String hqt_state);
}

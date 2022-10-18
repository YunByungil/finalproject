package joa.helpdesk.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import java.sql.*;

public class JoaHelpQuestionDAOImple implements JoaHelpQuestionDAO {
	
	private SqlSessionTemplate sqlMap;
	
	public JoaHelpQuestionDAOImple(SqlSessionTemplate sqlMap) {
		super();
		this.sqlMap = sqlMap;
	}

	public JoaHelpQuestionDAOImple() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int addQuestion(JoaHelpQuestionDTO dto) {
		// TODO Auto-generated method stub
		int result = sqlMap.insert("QuestionInsert", dto);
		
		return result;
	}
	
	@Override
	public int addEmailQuestion(JoaHelpQuestionDTO dto) {
		int result = sqlMap.insert("QuestionInsert", dto);
		
		return result;
	}


	@Override
	public List<JoaHelpQuestionDTO> QuestionList() {
		// TODO Auto-generated method stub
		List<JoaHelpQuestionDTO> list = sqlMap.selectList("QuestionList");
		return list;
	}

	@Override
	public List<JoaHelpQuestionDTO> serchQuestionList(String type, String state, String region, String cinema) {
		List<JoaHelpQuestionDTO> list = sqlMap.selectList("SerchQuestionList");
		return list;
	}

	@Override
	public JoaHelpQuestionDTO QuestionBorder(int idx) {
		JoaHelpQuestionDTO dto = sqlMap.selectOne("QuestionBorder");
		return dto;
	}
	
	@Override
	public int answerQuestion(JoaHelpQuestionDTO dto) {
		int result = sqlMap.insert("QuestionAnswer", dto);
		
		return result;
	
	}
	
	@Override
	public int reanswerQuestion(JoaHelpQuestionDTO dto) {
		int result = sqlMap.insert("QuestionReAnswer", dto);
		
		return result;
	}

}

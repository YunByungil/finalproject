package joa.helpdesk.model;



import java.util.*;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;

public class JoaHelpQuestionDAOImple implements JoaHelpQuestionDAO {
	
	@Autowired
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
		int result = sqlMap.insert("questionInsert", dto);
		
		return result;
	}
	
	@Override
	public int addEmailQuestion(JoaHelpQuestionDTO dto) {
		int result = sqlMap.insert("questionInsert", dto);
		
		return result;
	}

	@Override
	public JoaHelpQuestionDTO questionBorder(int idx) {
		JoaHelpQuestionDTO dto = sqlMap.selectOne("questionBorder", idx);
		return dto;
	}
	
	@Override
	public int answerQuestion(JoaHelpQuestionDTO dto) {
		int result = sqlMap.insert("questionAnswer", dto);
		
		return result;
	
	}
	
	@Override
	public int reanswerQuestion(JoaHelpQuestionDTO dto) {
		int result = sqlMap.insert("questionReAnswer", dto);
		
		return result;
	}
	
	@Override
	public List<JoaHelpQuestionDTO> emailList(Map map) {
		List<JoaHelpQuestionDTO> list = sqlMap.selectList("emailList",map);
		return list;
	}
	
	@Override
	public int emailTotalCnt(String state) {
		int count = sqlMap.selectOne("emailTotalCnt", state);
		return count;
	}
	
	@Override
	public List<JoaHelpQuestionDTO> emailTypeList(Map map) {
		List<JoaHelpQuestionDTO> list = sqlMap.selectList("emailTypeList",map);
		return list;
	}
	
	@Override
	public int emailTypeTotalCnt(Map map) {
		int count = sqlMap.selectOne("emailTypeTotalCnt", map);
		return count;
	}
	
	@Override
	public List<JoaHelpQuestionDTO> emailSerchList(Map map) {
		List<JoaHelpQuestionDTO> list = sqlMap.selectList("emailSerchList",map);
		return list;
	}
	
	@Override
	public int emailSerchTotalCnt(Map map) {
		int count = sqlMap.selectOne("emailSerchTotalCnt", map);
		return count;
	}
	
	@Override
	public List<JoaHelpQuestionDTO> questionList(Map map) {
		List<JoaHelpQuestionDTO> list = sqlMap.selectList("questionList",map);
		return list;
	}
	
	@Override
	public int questionTotalCnt(String state) {
		int count = sqlMap.selectOne("questionTotalCnt", state);
		return count;
	}
	
	@Override
	public List<JoaHelpQuestionDTO> questionTypeList(Map map) {
		List<JoaHelpQuestionDTO> list = sqlMap.selectList("questionTypeList",map);
		return list;
	}
	@Override
	public int questionTypeTotalCnt(Map map) {
		int count = sqlMap.selectOne("questionTypeTotalCnt", map);
		return count;
	}
	
	@Override
	public List<JoaHelpQuestionDTO> serchQuestionList(Map map) {
		List<JoaHelpQuestionDTO> list = sqlMap.selectList("questionSerchList",map);
		return list;
	}
	
	@Override
	public int serchQuestionTotalCnt(Map map) {
		int count = sqlMap.selectOne("questionSerchTotalCnt", map);
		return count;
	}
	
	@Override
	public List<JoaHelpQuestionDTO> topQuestionList(Map map) {
		List<JoaHelpQuestionDTO> list = sqlMap.selectList("topQuestionList",map);
		return list;
	}
	
	@Override
	public int topQuestionTotalCnt() {
		int count = sqlMap.selectOne("topQuestionTotalCnt");
		return count;
	}
	
	@Override
	public List<JoaHelpQuestionDTO> topQuestionTypeList(Map map) {
		List<JoaHelpQuestionDTO> list = sqlMap.selectList("topQuestionTypeList",map);
		return list;
	}
	
	@Override
	public int topQuestionTypeTotalCnt(String hqt_type) {
		int count = sqlMap.selectOne("topQuestionTypeTotalCnt",hqt_type);
		return count;
	}
	
	@Override
	public List<JoaHelpQuestionDTO> topSerchQuestionList(Map map) {
		List<JoaHelpQuestionDTO> list = sqlMap.selectList("topQuestionSerchList",map);
		return list;
	}
	
	@Override
	public int topSerchQuestionTotalCnt(Map map) {
		int count = sqlMap.selectOne("topQuestionSerchTotalCnt",map);
		return count;
	}
}

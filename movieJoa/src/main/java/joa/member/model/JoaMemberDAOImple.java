package joa.member.model;

import org.mybatis.spring.SqlSessionTemplate;


public class JoaMemberDAOImple implements JoaMemberDAO {

	private SqlSessionTemplate sqlMap;
	public JoaMemberDAOImple(SqlSessionTemplate sqlMap) {
		// TODO Auto-generated constructor stub
		super();
		this.sqlMap=sqlMap;
	}
	@Override
	public int MemberJoin(JoaMemberDTO dto) {
		
		int result=sqlMap.insert("memberInsert",dto);
		return result;
	}
	@Override
	public JoaMemberDTO memberLogin(JoaMemberDTO dto) {
		
		return sqlMap.selectOne("memberLogin", dto);
	}
	@Override
	public int memberIdCheck(String id) {
		int result=sqlMap.selectOne("memberIdCheckQuery",id);
		return result;
	}


}

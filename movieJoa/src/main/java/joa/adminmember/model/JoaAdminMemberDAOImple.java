package joa.adminmember.model;

import java.util.*;
import org.mybatis.spring.SqlSessionTemplate;
import joa.member.model.JoaMemberDTO;

public class JoaAdminMemberDAOImple implements JoaAdminMemberDAO {

	private SqlSessionTemplate sqlMap;

	public JoaAdminMemberDAOImple(SqlSessionTemplate sqlMap) {
		super();
		this.sqlMap = sqlMap;
	}
	public List<JoaMemberDTO> adminMemberList(JoaMemberDTO dto){
		List<JoaMemberDTO> list;
		if(dto.getMem_id()==null) {
			list=sqlMap.selectList("adminMemberName",dto);
		}else {
			list=sqlMap.selectList("adminMemberId",dto);
		}
		return list;
	}
	
}

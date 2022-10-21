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
	@Override
	public JoaMemberDTO adminMemberUpdate(String id) {
		JoaMemberDTO dto=sqlMap.selectOne("adminMemberId2",id);
		return dto;
	}
	@Override
	public int adminMemberUpdateGo(JoaMemberDTO dto) {
		int result=sqlMap.update("adminMemberUpdateQuery", dto);
		return result;
	}
	@Override
	public int adminMemberDelete(String id) {
		int result=sqlMap.delete("adminMemberDeleteQuery", id);
		return result;
	}
	@Override
	public int adminRegisterInsert(JoaAdminMemberDTO dto) {
		int result=sqlMap.insert("adminRegisterInsertQuery",dto);
		return result;
	}
	@Override
	public JoaAdminMemberDTO adminMemberLogin(JoaAdminMemberDTO dto) {
		JoaAdminMemberDTO login_dto=sqlMap.selectOne("adminMemberLoginQuery",dto);
		return login_dto;
	}
	@Override
	public List<JoaMemberDTO> adminMemberAll() {
		List<JoaMemberDTO> list=sqlMap.selectList("adminMemberAll");
		return list;
	}
	@Override
	public List<JoaMemberDTO> adminMeberList(int ls, int cp) {
		int start=(cp-1)*ls+1;
		int end=cp*ls;
		Map<String, Integer> map=new HashMap<>();
		map.put("start",start);
		map.put("end",end);
		List<JoaMemberDTO> list=sqlMap.selectList("adminMemberListQuery",map);
		return list;
	}
	@Override
	public int adminMemberTotalCnt() {
		int count=sqlMap.selectOne("adminMemberTotalCnt");
		return count;
	}
	@Override
	public List<JoaAdminMemberDTO> adminList(int ls, int cp) {
		int start=(cp-1)*ls+1;
		int end=cp*ls;
		Map<String, Integer> map=new HashMap<>();
		map.put("start",start);
		map.put("end",end);
		List<JoaAdminMemberDTO> list=sqlMap.selectList("adminListQuery",map);
		return list;
	}
	@Override
	public int adminTotalCnt() {
		int count=sqlMap.selectOne("adminTotalCnt");
		return count;
	}
	@Override
	public List<JoaAdminMemberDTO> adminList(JoaAdminMemberDTO dto) {
		List<JoaAdminMemberDTO> list;
		if(dto.getAdmin_id()==null) {
			list=sqlMap.selectList("adminName",dto);
		}else {
			list=sqlMap.selectList("adminId",dto);
		}
		return list;
	}
	@Override
	public JoaAdminMemberDTO adminUpdate(String id) {
		JoaAdminMemberDTO dto=sqlMap.selectOne("adminId2",id);
		return dto;
	}
	@Override
	public int adminUpdateGo(JoaAdminMemberDTO dto) {
		int result=sqlMap.update("adminUpdateQuery", dto);
		return result;
	}
	@Override
	public int adminDelete(String id) {
		int result=sqlMap.delete("adminDeleteQuery",id);
		return result;
	}
	@Override
	public int memberAllCount() {
		int result=sqlMap.selectOne("memberAllCountQuery");
		return result;
	}
	@Override
	public int currentMemberJoin() {
		int result=sqlMap.selectOne("currentMemberJoinQuery");
		return result;
	}
	@Override
	public int adminAllCount() {
		int result=sqlMap.selectOne("adminAllCountQuery");
		return result;
	}
	@Override
	public int memberGenderCount() {
		int result=sqlMap.selectOne("memberGenderCountQuery");
		return result;
	}
	@Override
	public int[] memberAgeCount() {
		int arr[]=new int[5];
		for(int i=0; i<5; i++) {
			int result=sqlMap.selectOne("memberAgeCountQuery"+(i+1));
			arr[i]=result;
		}
		return arr;
	}
}

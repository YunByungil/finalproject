package joa.adminMem.model;

import java.util.List;

import joa.adminMem.model.*;
import joa.member.model.JoaMemberDTO;

public interface JoaAdminMemberDAO {

	public List<JoaMemberDTO> adminMemberList(JoaMemberDTO dto);
	public JoaMemberDTO adminMemberUpdate(String id);
	public int adminMemberUpdateGo(JoaMemberDTO dto);
	public int adminMemberDelete(String id);
	public int adminRegisterInsert(JoaAdminMemberDTO dto);
	public JoaAdminMemberDTO adminMemberLogin(JoaAdminMemberDTO dto);
	public List<JoaMemberDTO> adminMemberAll();
	public List<JoaMemberDTO> adminMeberList(int ls,int cp);
	public int adminMemberTotalCnt();
	public List<JoaAdminMemberDTO> adminList(int ls, int cp);
	public int adminTotalCnt();
	public List<JoaAdminMemberDTO> adminList(JoaAdminMemberDTO dto);
	public JoaAdminMemberDTO adminUpdate(String id);
	public int adminUpdateGo(JoaAdminMemberDTO dto);
	public int adminDelete(String id);
	public int memberAllCount();
	public int currentMemberJoin();
	public int adminAllCount();
	public int memberGenderCount();
	public int[] memberAgeCount();
	public int memberGradeCount();
	public List<JoaMemberDTO> memberGenderSelect(String mem_gender,int ls,int cp);
	public int memberGradeGeneral();
	public int memberGradeVip();
	public int memberGradeSvip();
	public int memberGradeVvip();
	public int pagingGenderCount(String mem_gender);
}

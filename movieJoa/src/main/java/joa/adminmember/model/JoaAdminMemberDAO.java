package joa.adminmember.model;

import java.util.List;
import joa.member.model.JoaMemberDTO;

public interface JoaAdminMemberDAO {

	public List<JoaMemberDTO> adminMemberList(JoaMemberDTO dto);
}

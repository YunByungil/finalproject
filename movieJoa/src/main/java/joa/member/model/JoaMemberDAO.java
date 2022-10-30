package joa.member.model;

public interface JoaMemberDAO {

	public int MemberJoin(JoaMemberDTO dto);
	public JoaMemberDTO memberLogin(JoaMemberDTO dto);
	public int memberIdCheck(String mem_id);

}

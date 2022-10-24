package joa.mypage.model;

public interface JoaMypageDAO {
	
	
	public JoaMypageMemberDTO memberInpo(String sid);
	
	public int salePrice(int price,int grade);
	
	public int getPlusGrade(int price,int grade);
	
}

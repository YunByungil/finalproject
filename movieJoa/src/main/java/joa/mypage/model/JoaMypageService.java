package joa.mypage.model;

public interface JoaMypageService {

	public JoaMypageMemberDTO memberInpo(String sid);
	
	public int salePrice(int price,int grade);
	
	public int getPlusGrade(int price,int grade);
}

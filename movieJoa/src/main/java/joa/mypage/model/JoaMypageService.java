package joa.mypage.model;

import java.util.List;
import java.util.Map;

public interface JoaMypageService {

	public JoaMypageMemberDTO memberInpo(String sid);
	
	public int salePrice(int price,int grade);
	
	public int getPlusGrade(int price,int grade);
	
	public List<JoaMypageOwnCouDTO> memberCoupon(String sid);
	
	public List<JoaMypageOwnCouDTO> memberCouponDate(String sid);
	
	public int memberCouponCnt(String sid);
	
	public int deleteCoupon(String sid, int idx);
	
	public List<JoaMypageOwnCouDTO> memberUsedCoupon(String sid);

	public List<JoaMypageServiceDTO> memberService(String sid);
	
	public List<JoaMypageEventDTO> memberEventList(String sid);
	
	public List<JoaMypageEventDTO> endEventList();
	
	public List<JoaMypagePayProDTO> memberStore(String sid);
	
	public List<JoaMypagePayProDTO> memberPrice(String sid);
	
	public int memberDelete(String sid);
	
	public int memberProfile(JoaMypageProfileDTO dto);
	
	public List<JoaMypageRivewDTO> memberReview(String sid);
	
	public List<JoaMyPagePayMovieDTO> memberPayMovie(String sid);
}

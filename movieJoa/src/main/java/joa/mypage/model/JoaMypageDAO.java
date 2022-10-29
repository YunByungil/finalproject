package joa.mypage.model;

import java.util.List;
import java.util.Map;

import joa.adminEvent.model.AdminEventLuckBoardDTO;
import joa.helpdesk.model.JoaHelpQuestionDTO;

public interface JoaMypageDAO {
	
	public JoaHelpQuestionDTO questionBorder(int idx);
	
	public JoaMypageMemberDTO memberInpo(String sid);
	
	public int salePrice(int price,int grade);
	
	public int getPlusGrade(int price,int grade);
	
	public List<JoaMypageOwnCouDTO> memberCoupon(String sid);
	
	public List<JoaMypageOwnCouDTO> memberCouponDate(String sid);
	
	public int memberCouponCnt(String sid);
	
	public int deleteMovie(Map map);
	
	public List<JoaMypageOwnCouDTO> memberUsedCoupon(String sid);

	public List<JoaMypageServiceDTO> memberService(String sid);
	
	public List<JoaMypageEventDTO> memberEventList(String sid);
	
	public List<JoaMypageEventDTO> endEventList();
	
	public List<JoaMypagePayProDTO> memberStore(String sid);
	
	public List<JoaMypagePayProDTO> memberPrice(String sid);
	
	public int memberDelete(String sid);
	
	public List<JoaMypageRivewDTO> memberReview(String sid);

	public List<JoaMyPagePayMovieDTO> memberPayMovie(String sid);
	
	public JoaMypageProfileDTO getProfile(String sid);
	
	public int insertProfile(Map map);
	
	public int updateProfile(JoaMypageProfileDTO dto);
	
	public List<AdminEventLuckBoardDTO> lucky_Guys();
	
	public AdminEventLuckBoardDTO imfine(int idx);
	
}

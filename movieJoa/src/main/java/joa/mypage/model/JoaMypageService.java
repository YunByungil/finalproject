package joa.mypage.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import joa.adminEvent.model.AdminEventLuckBoardDTO;
import joa.helpdesk.model.JoaHelpQuestionDTO;

public interface JoaMypageService {
	
	public List<JoaMypageStoreDTO> serchStore(String sid, Date prs_date_start, Date prs_date_end);
	
	public JoaHelpQuestionDTO questionBorder(int idx);
	
	public JoaMypageMemberDTO memberInpo(String sid);
	
	public int salePrice(int price,int grade);
	
	public int getPlusGrade(int price,int grade);
	
	public List<JoaMypageOwnCouDTO> memberCoupon(String sid);
	
	public List<JoaMypageOwnCouDTO> memberCouponDate(String sid);
	
	public int memberCouponCnt(String sid);
	
	public int deleteMovie(String sid, int idx);
	
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
	
	public int insertProfile(String pro_id, String pro_nickname, String pro_image);
	
	public int updateProfile(JoaMypageProfileDTO dto);
	
	public List<AdminEventLuckBoardDTO> lucky_Guys();
	
	public AdminEventLuckBoardDTO imHappy(int idx);
}

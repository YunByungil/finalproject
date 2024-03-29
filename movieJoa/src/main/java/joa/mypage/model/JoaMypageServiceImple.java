package joa.mypage.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import joa.adminEvent.model.AdminEventLuckBoardDTO;
import joa.helpdesk.model.JoaHelpQuestionDTO;

public class JoaMypageServiceImple implements JoaMypageService {
	
	private JoaMypageDAO JoaMypageDao;
	
	public JoaMypageServiceImple(JoaMypageDAO joaMypageDao) {
			super();
			JoaMypageDao = joaMypageDao;
		}
	
	public JoaMypageServiceImple() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public AdminEventLuckBoardDTO imHappy(int idx) {
		AdminEventLuckBoardDTO dto = JoaMypageDao.imfine(idx);
		return dto;
	}
	
	@Override
	public List<AdminEventLuckBoardDTO> lucky_Guys() {
		List<AdminEventLuckBoardDTO> list = JoaMypageDao.lucky_Guys();
		return list;
	}
	
	@Override
	public int updateProfile(JoaMypageProfileDTO dto) {
		int result = JoaMypageDao.updateProfile(dto);
		return result;
	}
	
	@Override
	public int insertProfile(String pro_id, String pro_nickname, String pro_image) {
		Map map = new HashMap();
		map.put("pro_id",pro_id);
		map.put("pro_nickname",pro_nickname);
		map.put("pro_image",pro_image);
		
		int result = JoaMypageDao.insertProfile(map);
		return result;
	}
	
	@Override
	public JoaMypageProfileDTO getProfile(String sid) {
		JoaMypageProfileDTO pdto = JoaMypageDao.getProfile(sid);
		return pdto;
	}
	
	@Override
	public JoaHelpQuestionDTO questionBorder(int idx) {
		JoaHelpQuestionDTO dto = JoaMypageDao.questionBorder(idx);
		return dto;
	}
	
	@Override
	public List<JoaMypageRivewDTO> memberReview(String sid) {
		List<JoaMypageRivewDTO> list = JoaMypageDao.memberReview(sid);
		return list;
	}
	
	@Override
	public JoaMypageMemberDTO memberInpo(String sid) {
		
		JoaMypageMemberDTO dto = JoaMypageDao.memberInpo(sid);
		
		return dto;
	}
	
	@Override
	public List<JoaMypageOwnCouDTO> memberCoupon(String sid) {
		List<JoaMypageOwnCouDTO> list = JoaMypageDao.memberCoupon(sid);
		return list;
	}
	@Override
	public List<JoaMypageOwnCouDTO> memberCouponDate(String sid) {
		List<JoaMypageOwnCouDTO> list = JoaMypageDao.memberCouponDate(sid);
		return list;
	}
	
	@Override
	public int memberCouponCnt(String sid) {
		int count = JoaMypageDao.memberCouponCnt(sid);
		return count;
	}
	
	@Override
	public int deleteMovie(String sid, int idx) {
		Map map = new HashMap();
		map.put("sid", sid);
		map.put("idx", idx);
		int result = JoaMypageDao.deleteMovie(map);
		return result;
	}
	
	@Override
	public List<JoaMypageOwnCouDTO> memberUsedCoupon(String sid) {
		List<JoaMypageOwnCouDTO> list = JoaMypageDao.memberUsedCoupon(sid);
		return list;
	}
	
	@Override
	public List<JoaMypageServiceDTO> memberService(String sid) {
		List<JoaMypageServiceDTO> list = JoaMypageDao.memberService(sid);
		return list;
	}
	
	@Override
	public List<JoaMypageEventDTO> memberEventList(String sid) {
		List<JoaMypageEventDTO> list = JoaMypageDao.memberEventList(sid);
		return list;
	}
	
	@Override
	public List<JoaMypageEventDTO> endEventList() {
		List<JoaMypageEventDTO> list = JoaMypageDao.endEventList();
		return list;
	}
	
	@Override
	public List<JoaMypagePayProDTO> memberStore(String sid) {
		List<JoaMypagePayProDTO> list = JoaMypageDao.memberStore(sid);
		return list;
	}
	
	@Override
	public int memberDelete(String sid) {
		int result = JoaMypageDao.memberDelete(sid);
		return result;
	}
	
	@Override
	public List<JoaMypagePayProDTO> memberPrice(String sid) {
		List<JoaMypagePayProDTO> list = JoaMypageDao.memberPrice(sid);
		return list;
	}
	
	
	@Override
	public List<JoaMyPagePayMovieDTO> memberPayMovie(String sid) {
		List<JoaMyPagePayMovieDTO> list = JoaMypageDao.memberPayMovie(sid);
		return list;
	}
	
	
	
	@Override
	public int salePrice(int price, int grade) {
		if(grade>=10000 && grade<25000){
			price -=price-(int)(price*0.07);; //할인
	//m_grade = "VIP";
			}
		if(grade>=25000 && grade<40000){
			price -= price-(int)(price*0.09); //할인
	//m_grade = "VVIP";
			}
		if(grade>=40000) {
			price -= price-(int)(price*0.1); //할인
	//m_grade = "VVIP";
			}
		return price;
	}
	


	@Override
	public int getPlusGrade(int price, int grade) {
			grade +=price-(int)(price*0.05);
		if(grade>=10000 && grade<25000){
			grade +=price-(int)(price*0.07); //멤버 테이블 grade컬럼에 갱신할 등급값
	//m_grade = "VIP";
			}
		if(grade>=25000 && grade<40000){
			grade += price-(int)(price*0.09); //멤버 테이블 grade컬럼에 갱신할 등급값
	//m_grade = "VVIP";
			}
		if(grade>=40000) {
			price += price-(int)(price*0.1); //멤버 테이블 grade컬럼에 갱신할 등급값
	//m_grade = "VVIP";
			}
		return grade;
	}

}

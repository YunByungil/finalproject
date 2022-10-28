package joa.mypage.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import joa.helpdesk.model.JoaHelpQuestionDTO;

public class JoaMypageDAOImple implements JoaMypageDAO {
	
	@Autowired
	private SqlSessionTemplate sqlMap;
	
	public JoaMypageDAOImple(SqlSessionTemplate sqlMap) {
		super();
		this.sqlMap = sqlMap;
	}
	
	public JoaMypageDAOImple() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int insertProfile(Map map) {
		int result = sqlMap.insert("insertProfile", map);
		return result;
	}
	
	@Override
	public JoaMypageProfileDTO getProfile(String sid) {
		JoaMypageProfileDTO dto = sqlMap.selectOne("getprofile",sid);
		return dto;
	}
	
	@Override
	public JoaHelpQuestionDTO questionBorder(int idx) {
		JoaHelpQuestionDTO dto = sqlMap.selectOne("questionBorder_s", idx);
		return dto;
	}
	
	@Override
	public JoaMypageMemberDTO memberInpo(String sid) {
		
		JoaMypageMemberDTO dto = sqlMap.selectOne("mypageInpo",sid);
		
		return dto;
	}
	
	@Override
	public int memberCouponCnt(String sid) {
		int count = sqlMap.selectOne("mypageCouponCnt",sid); 
		return count;
	}
	
	@Override
	public List<JoaMypageOwnCouDTO> memberCouponDate(String sid) {
		List<JoaMypageOwnCouDTO> list = sqlMap.selectList("mypageCouponDate",sid);
		return list;
	}
	
	@Override
	public List<JoaMypageOwnCouDTO> memberCoupon(String sid) {
		List<JoaMypageOwnCouDTO> list = sqlMap.selectList("mypageCoupon",sid);
		return list;

	}
	@Override
	public int deleteMovie(Map map) {
		int result = sqlMap.selectOne("MovieDelete",map);
		return result;
	}
	@Override
	public List<JoaMypageOwnCouDTO> memberUsedCoupon(String sid) {
		List<JoaMypageOwnCouDTO> list = sqlMap.selectList("mypageUsedCoupon",sid);
		return list;
	}
	
	@Override
	public List<JoaMypageServiceDTO> memberService(String sid) {
		List<JoaMypageServiceDTO> list = sqlMap.selectList("mypageService",sid);
		return list;
	}
	@Override
	public List<JoaMypageEventDTO> memberEventList(String sid) {
		List<JoaMypageEventDTO> list = sqlMap.selectList("mypageEvent",sid);
		return list;
	}
	
	@Override
	public List<JoaMypageEventDTO> endEventList() {
		List<JoaMypageEventDTO> list = sqlMap.selectList("mypageEndEvent");
		return list;
	}
	
	@Override
	public List<JoaMypagePayProDTO> memberStore(String sid) {
		List<JoaMypagePayProDTO> list = sqlMap.selectList("mypageStore", sid);
		return list;
	}
	
	@Override
	public int memberDelete(String sid) {
		int result = sqlMap.selectOne("memberDelete", sid);
		return result;
	}
	
	@Override
	public List<JoaMypagePayProDTO> memberPrice(String sid) {
		List<JoaMypagePayProDTO> list = sqlMap.selectList("mypagePrice", sid);
		return list;
	}
	
	@Override
	public List<JoaMypageRivewDTO> memberReview(String sid) {
		List<JoaMypageRivewDTO> list = sqlMap.selectList("memberReview", sid);
		return list;
	}
	

	@Override
	public List<JoaMyPagePayMovieDTO> memberPayMovie(String sid) {
		List<JoaMyPagePayMovieDTO> list = sqlMap.selectList("myPayMovie",sid);
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
			grade += price-(int)(price*0.1); //멤버 테이블 grade컬럼에 갱신할 등급값
	//m_grade = "VVIP";
			}
		return grade;
	}
	

}

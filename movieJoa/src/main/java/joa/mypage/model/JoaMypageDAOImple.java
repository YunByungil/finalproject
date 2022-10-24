package joa.mypage.model;

import org.mybatis.spring.SqlSessionTemplate;

public class JoaMypageDAOImple implements JoaMypageDAO {
	
	private SqlSessionTemplate sqlMap;
	
	@Override
	public JoaMypageMemberDTO memberInpo(String sid) {
		
		JoaMypageMemberDTO dto = sqlMap.selectOne("mypageInpo",sid);
		
		return dto;
	}
	
	public JoaMypageDAOImple(SqlSessionTemplate sqlMap) {
		super();
		this.sqlMap = sqlMap;
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

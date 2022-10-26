package joa.mypage.model;



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
	public JoaMypageMemberDTO memberInpo(String sid) {
		
		JoaMypageMemberDTO dto = JoaMypageDao.memberInpo(sid);
		
		return dto;
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

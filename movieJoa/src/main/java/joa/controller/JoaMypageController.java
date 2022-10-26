package joa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import joa.mypage.model.JoaMypageService;
import joa.mypage.model.JoaMypageMemberDTO;
@Controller
public class JoaMypageController {
	
	@Autowired
	private JoaMypageService JoaMypageService;
	
	@RequestMapping("/myPage.do")
	public ModelAndView myPage(@RequestParam(value="sid")String sid) {
		JoaMypageMemberDTO dto = JoaMypageService.memberInpo(sid);
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto", dto);
		mav.setViewName("joaMyPage/joaMyPage_myPage");
		return mav;
	}
	
	@RequestMapping("/myPage_tiket.do")
	public ModelAndView myPage_tiket() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("joaMyPage/joa_Mypage_ticketing");
		return mav;
	}
	@RequestMapping("/myPage_cancle_Coupon.do")
	public ModelAndView myPage_cancle_Coupon() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("joaMyPage/joa_Mypage_cancelCoupon");
		return mav;
	}
	
	@RequestMapping("/myPage_coupon.do")
	public ModelAndView myPage_coupon() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("joaMyPage/joa_Mypage_coupon");
		return mav;
	}
	
	@RequestMapping("/myPage_usedCoupon.do")
	public ModelAndView myPage_usedCoupon() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("joaMyPage/joa_Mypage_usedCoupon");
		return mav;
	}
	
	@RequestMapping("/myPage_GuidePoint.do")
	public ModelAndView myPage_GuidePoint() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("joaMyPage/joa_Mypage_GuidePoint");
		return mav;
	}
	
	@RequestMapping("/myPage_Point.do")
	public ModelAndView myPage_Point() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("joaMyPage/joa_Mypage_Point");
		return mav;
	}
	
	@RequestMapping("/myPage_Event.do")
	public ModelAndView myPage_Event() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("joaMyPage/joa_Mypage_Event");
		return mav;
	}
	@RequestMapping("/myPage_EndEvent.do")
	public ModelAndView myPage_EndEvent() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("joaMyPage/joa_Mypage_Event");
		return mav;
	}
	
	@RequestMapping("/myPage_Store.do")
	public ModelAndView myPage_Store() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("joaMyPage/joa_Mypage_myStore");
		return mav;
	}
	
	@RequestMapping("/myPage_Store_Payment.do")
	public ModelAndView myPage_Store_Payment() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("joaMyPage/joa_Mypage_myStore_Payment");
		return mav;
	}
	
	@RequestMapping("/myPage_PW_Check_P.do")
	public ModelAndView myPage_PW_Check_P() {
		String subject = "프로필 관리";
		String content = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;프로필 정보를 열람 시 비밀번호가 필요합니다.";
		String action = "myPage_Nname.do";
		ModelAndView mav = new ModelAndView();
		mav.addObject("action",action);
		mav.addObject("content", content);
		mav.addObject("subject", subject);
		mav.setViewName("joaMyPage/joa_Mypage_PW_Check");
		return mav;
	}
	
	@RequestMapping("/myPage_PW_Check_E.do")
	public ModelAndView myPage_PW_Check_E() {
		String subject = "회원탈퇴";
		String content = "회원 탈퇴하시려면 비밀번호가 필요합니다.<br>탈퇴 후 <d>1개월간</d> 같은 개인정보로 회원가입이 불가능합니다.<br><br>";
		String action = "myPage_secession.do";
		ModelAndView mav = new ModelAndView();
		mav.addObject("action",action);
		mav.addObject("content", content);
		mav.addObject("subject", subject);
		mav.setViewName("joaMyPage/joa_Mypage_PW_Check");
		return mav;
	}
	
	@RequestMapping("/myPage_PW_Check_M.do")
	public ModelAndView myPage_PW_Check_M() {
		String subject = "개인정보변경";
		String content = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;회원 정보를 수정하시려면 비밀번호가 필요합니다.";
		String action = "myPage_Profile.do";
		ModelAndView mav = new ModelAndView();
		mav.addObject("action",action);
		mav.addObject("content", content);
		mav.addObject("subject", subject);
		mav.setViewName("joaMyPage/joa_Mypage_PW_Check");
		return mav;
	}
	
	@RequestMapping("/myPage_myService.do")
	public ModelAndView myPage_myService() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("joaMyPage/joa_Mypage_myService");
		return mav;
	}
	
	@RequestMapping("/myPage_Profile.do")
	public ModelAndView myPage_Profile() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("joaMyPage/joa_Mypage_myProfile");
		return mav;
	}
	
	@RequestMapping("/myPage_secession.do")
	public ModelAndView myPage_secession() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("joaMyPage/joa_Mypage_msg");
		return mav;
	}
	
	@RequestMapping("/myPage_Nname.do")
	public ModelAndView myPage_Nname() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("joaMyPage/joa_Mypage_myNname");
		return mav;
	}
	
	@RequestMapping("/self_ATNTCN.do")
	public ModelAndView self_ATNTCN() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("joaMyPage/joa_Mypage_self_ATNTCN");
		return mav;
	}
}

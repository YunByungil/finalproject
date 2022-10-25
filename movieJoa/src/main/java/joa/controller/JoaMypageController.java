package joa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JoaMypageController {
	
	@RequestMapping("/myPage.do")
	public String myPage() {
		return "joaMyPage/joaMyPage_myPage";
	}
	
	@RequestMapping("/myPage_tiket.do")
	public ModelAndView myPage_tiket() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("joaMyPage/joa_Mypage_ticketing");
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

}

package joa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import joa.member.model.JoaMemberDAO;
import joa.member.model.JoaMemberDTO;

@Controller
public class JoaMemberJoinController {
	@Autowired
	private JoaMemberDAO joaMemberDao;
	
	@RequestMapping("/memberJoin.do")
	public String memberJoin() {
		return "joaMemberJoin/joaMemberJoin_memberJoin";
	}
	@RequestMapping("/memberJoinFormSubmit.do")
	public ModelAndView memberJoinSubmit(@ModelAttribute("dto") JoaMemberDTO dto) {
		int result=joaMemberDao.MemberJoin(dto);
		String msg=result>0?dto.getMem_id()+"님 회원가입을 축하합니다.":"회원 가입 실패";
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg",msg);
		mav.setViewName("joaMemberJoin/joaMemberJoin_msg");
		return mav;
	}
	@RequestMapping("/memberLogout.do")
	public ModelAndView memberLogout(HttpSession session) {
		session.invalidate();
		ModelAndView mav=new ModelAndView();
		String msg="성공적으로 로그아웃되었습니다.";
		mav.addObject("msg",msg);
		mav.setViewName("joaMemberJoin/joaMemberJoin_msg");
		return mav;
	}
	
}

package joa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import joa.adminMem.model.JoaAdminMemberDTO;
import joa.member.model.JoaMemberDAO;
import joa.member.model.JoaMemberDTO;
import joa.mypage.model.JoaMypageProfileDTO;
import joa.mypage.model.JoaMypageService;

@Controller
public class JoaLoginController {

	@Autowired
	private JoaMemberDAO joaMemberDao;
	
	@Autowired
	private JoaMypageService JoaMypageService;
	
	@RequestMapping("/memberLogin.do")
	public String memberLogin() {
		return "joaLogin/joaLogin_login";
	}
	@RequestMapping("/memberLoginSubmit.do")
	public ModelAndView memberLoginCheck(JoaMemberDTO dto, HttpServletRequest req) {
		JoaMemberDTO login_dto=joaMemberDao.memberLogin(dto);
		HttpSession session=req.getSession();
		String msg="";
		if(login_dto!=null) {
			msg="로그인 성공";
			session.setAttribute("userInfo",login_dto);
		}else {
			msg="로그인 실패!";
		}
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg",msg);
		mav.setViewName("joaMemberJoin/joaMemberJoin_msg");
		return mav;
	}
}

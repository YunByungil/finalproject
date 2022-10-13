package joa.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import joa.adminmember.model.JoaAdminMemberDAO;
import joa.member.model.JoaMemberDTO;

@Controller
public class AdminMemberController {
	
	@Autowired
	private JoaAdminMemberDAO joaAdminMemberDao; 

	@RequestMapping("/adminMember.do")
	public String adminMemberGo() {
		return "admin/adminMember/adminMember_member";
	}
	@RequestMapping("/adminMemberSearch.do")
	public ModelAndView adminMemberSearch(JoaMemberDTO dto) {
		List<JoaMemberDTO> list=joaAdminMemberDao.adminMemberList(dto);
		ModelAndView mav=new ModelAndView();
		mav.addObject("list",list);
		mav.setViewName("admin/adminMember/adminMember_member");
		return mav;
	}
}

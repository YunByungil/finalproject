package joa.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import joa.adminMember.model.JoaAdminMemberDAO;
import joa.adminMember.model.JoaAdminMemberDTO;
import joa.member.model.JoaMemberDTO;

@Controller
public class AdminMemberController {
	
	@Autowired
	private JoaAdminMemberDAO joaAdminMemberDao; 

	@RequestMapping("/adminMember.do")
	public ModelAndView adminMemberGo(@RequestParam(value="cp",defaultValue = "1")int cp) {
		ModelAndView mav=new ModelAndView();
		int totalCnt=joaAdminMemberDao.adminMemberTotalCnt();
		int listSize=10;
		int pageSize=5;
		String pageStr=joa.page.PageModule.makePage("/movieJoa/adminMember.do", totalCnt, listSize, pageSize, cp);
		List<JoaMemberDTO> list=joaAdminMemberDao.adminMeberList(listSize, cp);
		mav.addObject("list",list);
		mav.addObject("pageStr", pageStr);
		mav.setViewName("admin/adminMember/adminMember_member");
		return mav;
	}
	@RequestMapping("/adminMemberSearch.do")
	public ModelAndView adminMemberSearch(JoaMemberDTO dto) {
		List<JoaMemberDTO> list=joaAdminMemberDao.adminMemberList(dto);
		ModelAndView mav=new ModelAndView();
		mav.addObject("list",list);
		mav.setViewName("admin/adminMember/adminMember_member");
		return mav;
	}
	@RequestMapping("/adminMemberUpdate.do")
	public ModelAndView adminMemberUpdateGo(String id) {
		JoaMemberDTO dto=joaAdminMemberDao.adminMemberUpdate(id);
		ModelAndView mav=new ModelAndView();
		mav.addObject("dto", dto);
		mav.setViewName("admin/adminMember/adminMember_update");
		return mav;
	}
	@RequestMapping("/adminMemberUpdateConfirm.do")
	public ModelAndView adminMemberUpdateConfirm(JoaMemberDTO dto) {
		int result=joaAdminMemberDao.adminMemberUpdateGo(dto);
		ModelAndView mav=new ModelAndView();
		String msg=result>0?"수정 성공":"수정 실패";
		mav.addObject("msg",msg);
		mav.setViewName("admin/adminMember/adminMember_msg");
		return mav;
	}
	@RequestMapping("/adminMemberDelete.do")
	public ModelAndView adminMemberDelete(String id) {
		int result=joaAdminMemberDao.adminMemberDelete(id);
		ModelAndView mav=new ModelAndView();
		String msg=result>0?"삭제 성공":"삭제 실패";
		mav.addObject("msg",msg);
		mav.setViewName("admin/adminMember/adminMember_msg");
		return mav;
	}
	@RequestMapping("/adminMemberRegister.do")
	public String adminMemberRegisterGo() {
		return "admin/adminMember/adminMember_register";
	}
	@RequestMapping("/adminRegisterForm.do")
	public ModelAndView adminRegisterInsert(JoaAdminMemberDTO dto) {
		int result=joaAdminMemberDao.adminRegisterInsert(dto);
		String msg=result>0?"등록 성공":"등록 실패";
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", msg);
		mav.setViewName("admin/adminMember/adminMember_msg");
		return mav;
	}
	@RequestMapping("/adminMemberMain.do")
	public ModelAndView adminMemberMainGo() {
		ModelAndView mav=new ModelAndView();
		int memberAllCount=joaAdminMemberDao.memberAllCount();
		int currentMemberJoin=joaAdminMemberDao.currentMemberJoin();
		int adminAllCount=joaAdminMemberDao.adminAllCount();
		int memberGenderCount=joaAdminMemberDao.memberGenderCount();
		int arr[]=new int[5];
		int memberGradeCount=joaAdminMemberDao.memberGradeCount();
		arr=joaAdminMemberDao.memberAgeCount();
		mav.addObject("currentMemberJoin",currentMemberJoin);
		mav.addObject("memberAllCount", memberAllCount);
		mav.addObject("adminAllCount", adminAllCount);
		mav.addObject("memberGenderCount", memberGenderCount);
		mav.addObject("memberAgeCount", arr);
		mav.addObject("memberGradeCount",memberGradeCount );
		mav.setViewName("admin/adminMember/adminMember_main");
		return mav;
	}
	@RequestMapping("/adminMemberLoginSubmit.do")
	public ModelAndView adminMemberLogin(JoaAdminMemberDTO dto, HttpServletRequest req) {
		JoaAdminMemberDTO login_dto=joaAdminMemberDao.adminMemberLogin(dto);
		int memberAllCount=joaAdminMemberDao.memberAllCount();
		int currentMemberJoin=joaAdminMemberDao.currentMemberJoin();
		int adminAllCount=joaAdminMemberDao.adminAllCount();
		int memberGenderCount=joaAdminMemberDao.memberGenderCount();
		int arr[]=new int[5];
		int memberGradeCount=joaAdminMemberDao.memberGradeCount();
		arr=joaAdminMemberDao.memberAgeCount();
		HttpSession session=req.getSession();
		ModelAndView mav=new ModelAndView();
		String msg="";
		if(login_dto!=null) {
			msg="로그인 성공";
			session.setAttribute("adminInfo",login_dto);
			mav.addObject("currentMemberJoin",currentMemberJoin);
			mav.addObject("memberAllCount", memberAllCount);
			mav.addObject("adminAllCount", adminAllCount);
			mav.addObject("memberGenderCount", memberGenderCount);
			mav.addObject("memberAgeCount", arr);
			mav.addObject("memberGradeCount",memberGradeCount );
			mav.setViewName("admin/adminMember/adminMember_main");
		}else {
			msg="로그인 실패!";
			mav.addObject("msg",msg);
			mav.setViewName("admin/adminMember/adminMember_msg");
		}
		return mav;
	}
	@RequestMapping("/adminLogout.do")
	public ModelAndView adminMemberLogout(HttpSession session) {
		session.invalidate();
		ModelAndView mav=new ModelAndView();
		String msg="성공적으로 로그아웃되었습니다.";
		mav.addObject("msg",msg);
		mav.setViewName("joaMemberJoin/joaMemberJoin_msg");
		return mav;
	}
	@RequestMapping("/adminSearch.do")
	public ModelAndView adminList(@RequestParam(value="cp",defaultValue = "1")int cp) {
		ModelAndView mav=new ModelAndView();
		int totalCnt=joaAdminMemberDao.adminTotalCnt();
		int listSize=10;
		int pageSize=5;
		String pageStr=joa.page.PageModule.makePage("/movieJoa/adminMember.do", totalCnt, listSize, pageSize, cp);
		List<JoaAdminMemberDTO> list=joaAdminMemberDao.adminList(listSize, cp);
		mav.addObject("list",list);
		mav.addObject("pageStr", pageStr);
		mav.setViewName("admin/adminMember/adminMember_admin");
		return mav;
	}
	@RequestMapping("/adminSearchInfo.do")
	public ModelAndView adminSearchGo(JoaAdminMemberDTO dto) {
		List<JoaAdminMemberDTO> list=joaAdminMemberDao.adminList(dto);
		ModelAndView mav=new ModelAndView();
		mav.addObject("list",list);
		mav.setViewName( "admin/adminMember/adminMember_admin");
		return mav;
	}
	@RequestMapping("/adminUpdate.do")
	public ModelAndView adminUpadteGo(String id) {
		ModelAndView mav=new ModelAndView();
		JoaAdminMemberDTO dto=joaAdminMemberDao.adminUpdate(id);
		mav.addObject("dto", dto);
		mav.setViewName("admin/adminMember/adminMember_adminSearch");
		return mav;
	}
	@RequestMapping("/adminUpdateForm.do")
	public ModelAndView adminUpdateConfirm(JoaAdminMemberDTO dto) {
		int result=joaAdminMemberDao.adminUpdateGo(dto);
		ModelAndView mav=new ModelAndView();
		String msg=result>0?"수정 완료":"수정 실패";
		mav.addObject("msg", msg);
		mav.setViewName("admin/adminMember/adminMember_msg");
		return mav;
	}
	@RequestMapping("/adminDelete.do")
	public ModelAndView adminDeleteGo(String id) {
		int result=joaAdminMemberDao.adminDelete(id);
		ModelAndView mav=new ModelAndView();
		String msg=result>0?"탈퇴 성공":"탈퇴 실패";
		mav.addObject("msg",msg);
		mav.setViewName("admin/adminMember/adminMember_msg");
		return mav;
	}
	@RequestMapping("/adminGender.do")
	public ModelAndView adminGenderGo(String mem_gender) {
		ModelAndView mav=new ModelAndView();
		List<JoaMemberDTO> list=joaAdminMemberDao.memberGenderSelect(mem_gender);
		mav.addObject("list", list);
		mav.setViewName("admin/adminMember/adminMember_gender");
		return mav;
	}
	@RequestMapping("/adminGrade.do")
	public ModelAndView adminGradeGo() {
		ModelAndView mav=new ModelAndView();
		int gradeGeneral=joaAdminMemberDao.memberGradeGeneral();
		int gradeVip=joaAdminMemberDao.memberGradeVip();
		int gradeSvip=joaAdminMemberDao.memberGradeSvip();
		int gradeVvip=joaAdminMemberDao.memberGradeVvip();
		mav.addObject("general", gradeGeneral);
		mav.addObject("vip", gradeVip);
		mav.addObject("svip", gradeSvip);
		mav.addObject("vvip", gradeVvip);
		mav.setViewName("admin/adminMember/adminMember_grade");
		return mav;
	}

}

package joa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import joa.adminOwncou.model.AdminOwncouDTO;
import joa.adminOwncou.model.AdminOwncouService;

@Controller
public class AdminOwncouController {
	
	@Autowired
	private AdminOwncouService adminOwncouService;
	@RequestMapping(value={"/listOwncou.do","/searchOwncou.do"})
	public ModelAndView listOwnCou(
		@RequestParam(value="cp", defaultValue="1")int cp,
		@RequestParam(value="s_k",  defaultValue="--")String s_k,
		@RequestParam(value="s_v", defaultValue="--")String s_v) {
		int listSize=10;
		int pageSize=5;
		int totalCnt=adminOwncouService.adminOwncouTotalCnt(s_k, s_v);
		String pageStr=joa.page.PageModule.makePage("listOwncou.do", totalCnt, listSize, pageSize, cp);
		List<AdminOwncouDTO> owncouList=adminOwncouService.listOwncou(cp, listSize, s_k, s_v); 
		ModelAndView mav= new ModelAndView();
		mav.addObject("s_k",s_k);
		mav.addObject("s_v",s_v);
		mav.addObject("pageStr",pageStr);
		mav.addObject("owncouList",owncouList);
		mav.setViewName("admin/adminCoupon/adminCoupon_listOwncou");
		return mav;
	}
	
	@RequestMapping("/deleteOwncou.do")
	public ModelAndView deleteMovie(
			@RequestParam(value="own_idx", defaultValue="0")int own_idx) {
		int result = adminOwncouService.deleteOwncou(own_idx);
		String msg=result>0?"해당 쿠폰 발급 내역 삭제에 성공했습니다.":"해당 쿠폰 발급 내역 삭제에 실패했습니다.";
		System.out.println(result);
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg",msg);
		mav.addObject("nextPage","/movieJoa/listOwncou.do");
		mav.setViewName("admin/adminCoupon/msg");
		return mav;
	}

}

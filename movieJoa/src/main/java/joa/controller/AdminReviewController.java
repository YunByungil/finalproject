package joa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import joa.adminReview.model.AdminReviewService;
import joa.review.model.JoaReviewDTO;

@Controller
public class AdminReviewController {
	
	@Autowired
	private AdminReviewService adminReviewService;
	
	@RequestMapping(value={"/listReview.do","/searchReview.do"})
	public ModelAndView listReview(
			@RequestParam(value="cp", defaultValue="1")int cp,
			@RequestParam(value="s_k",  defaultValue="--")String s_k,
			@RequestParam(value="s_v", defaultValue="--")String s_v) {
		int totalCnt=adminReviewService.adminReviewTotalCnt(s_k, s_v);
		int listSize=10;
		int pageSize=5;
		String pageStr=joa.page.PageModule.makePage("listReview.do", totalCnt, listSize, pageSize, cp);
		List<JoaReviewDTO> reviewList=adminReviewService.listReview(cp, listSize, s_k, s_v);
		ModelAndView mav= new ModelAndView();
		mav.addObject("s_k",s_k);
		mav.addObject("s_v",s_v);
		mav.addObject("pageStr",pageStr);
		mav.addObject("reviewList",reviewList);
		mav.setViewName("admin/adminReview/adminReview_listReview");
		return mav;
	}
	
	@RequestMapping("/deleteReview.do")
	public ModelAndView deleteReview(
			@RequestParam(value="rev_idx", defaultValue="0")int rev_idx) {
		int result = adminReviewService.deleteReview(rev_idx);
		String msg=result>0?"해당 관란평 정보 삭제에 성공했습니다.":"해당 관람평 정보 삭제에 실패했습니다.";
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg",msg);
		mav.addObject("nextPage","/movieJoa/listReview.do");
		mav.setViewName("admin/adminReview/msg");
		return mav;
	}
	
	@RequestMapping("/detailReview.do")
	public ModelAndView reviewDetail(
			@RequestParam(value="rev_idx", defaultValue="0")int rev_idx) {
		JoaReviewDTO dto= adminReviewService.detailReview(rev_idx);
		ModelAndView mav=new ModelAndView();
		if (dto==null) {
			mav.addObject("msg","잘못된 접근입니다.");
			mav.setViewName("admin/adminReveiw/msg");
		}else {
			mav.addObject("dto",dto);
			mav.setViewName("admin/adminReview/adminReview_reviewDetail");
		}
		return mav;
	}
	
	
	
}

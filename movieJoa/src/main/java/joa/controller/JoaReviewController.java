package joa.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import joa.review.model.JoaReviewDAO;
import joa.review.model.JoaReviewDTO;

@Controller
public class JoaReviewController {

	@Autowired
	private JoaReviewDAO rdao;
	
	@RequestMapping("/commentWrite.do")
	public ModelAndView commentWrite(JoaReviewDTO dto) {
		ModelAndView mav=new ModelAndView();
		rdao.commentWrite(dto);
		return mav;
	}
	@RequestMapping("/commentReg.do")
	public ModelAndView commentList(
			@RequestParam(value="ot", required=false, defaultValue = "0") int ot) {
		ModelAndView mav=new ModelAndView();
		List<JoaReviewDTO> list=rdao.commentList(ot);
		mav.addObject("commentList", list);
		mav.setViewName("joaMovie/joaMovie_commentReg");
		return mav;
	}
	@RequestMapping("/commentUpdate.do")
	public ModelAndView commentUpdateForm(
			@RequestParam("rev_id")String rev_id,
			@RequestParam("rev_movie_title")String rev_movie_title) {
		ModelAndView mav=new ModelAndView();
		Map map=new HashMap();
		map.put("rev_id", rev_id);
		map.put("rev_movie_title", rev_movie_title);
		List<JoaReviewDTO> list=rdao.updateList(map);
		mav.addObject("commentUpdateList", list);
		mav.setViewName("joaMovie/joaMovie_commentUpdate");
		return mav;
	}
	@RequestMapping("/commentDelete.do")
	public ModelAndView commentDelete(
			@RequestParam("rev_id")String rev_id,
			@RequestParam("rev_movie_title")String rev_movie_title) {
		ModelAndView mav = new ModelAndView();
		Map map=new HashMap();
		map.put("rev_id", rev_id);
		map.put("rev_movie_title", rev_movie_title);
		rdao.commentDelete(map);
		mav.setViewName("joaMovie/historyBack");
		return mav;
	}
}

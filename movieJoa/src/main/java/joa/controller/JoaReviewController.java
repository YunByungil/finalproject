package joa.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
		int result=rdao.commentWrite(dto);
		return mav;
	}
	@RequestMapping("/commentList.do")
	public ModelAndView commentList() {
		System.out.println("진입?");
		ModelAndView mav=new ModelAndView();
		List<JoaReviewDTO> list=rdao.commentList();
		
		System.out.println(list.get(0).getRev_id());
		mav.addObject("commentList", list);
		mav.setViewName("joaMovie/joaMovie_commentReg");
		return mav;
	}
}

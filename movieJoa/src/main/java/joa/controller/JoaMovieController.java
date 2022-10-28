package joa.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import joa.member.model.JoaMemberDTO;
import joa.movie.model.JoaMovieDAO;
import joa.movie.model.JoaMovieDTO;
import joa.review.model.JoaReviewDAO;
import joa.review.model.JoaReviewDTO;

@Controller
public class JoaMovieController {
	
	@Autowired
	private JoaMovieDAO mdao;
	
	@RequestMapping("/joaMovie.do")
	public ModelAndView joaMovie(
			@RequestParam(value="ot", required=false, defaultValue = "0") int ot) {
		List<JoaMovieDTO> list=mdao.movieList(ot);
		ModelAndView mav=new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("joaMovie/joaMovie_movie");
		return mav;
	}
	@RequestMapping("/joaPreMovie.do")
	public ModelAndView joaPreMovie() {
		ModelAndView mav=new ModelAndView();
		List<JoaMovieDTO> list=mdao.preMovieList();
		List<JoaMovieDTO> list2=mdao.preMovieDate();
		mav.addObject("list", list);
		mav.addObject("list2", list2);
		mav.addObject("now", new java.util.Date());
		mav.setViewName("joaMovie/joaMovie_preMovie");
		return mav;
	}
	@RequestMapping("/detailView.do")
	public ModelAndView detailView(
			@RequestParam("mov_idx")int mov_idx,
			HttpServletRequest req) {
		HttpSession session=req.getSession();
		JoaMemberDTO login_dto=(JoaMemberDTO) session.getAttribute("userInfo");
		String sid=login_dto==null?"":login_dto.getMem_id();
		ModelAndView mav=new ModelAndView();
		List<JoaMovieDTO> list=mdao.detailView(mov_idx);
		mav.addObject("list", list);
		mav.addObject("sid", sid);
		mav.setViewName("joaMovie/joaMovie_detailView");
		return mav;
	}
	@RequestMapping("/info.do")
	public ModelAndView info(
			@RequestParam("mov_idx")int mov_idx) {
		ModelAndView mav=new ModelAndView();
		List<JoaMovieDTO> list=mdao.detailView(mov_idx);
		if(!list.get(0).getMov_gender_percent().equals("0")) {
			String gp[]=list.get(0).getMov_gender_percent().split(",");
			String ap[]=list.get(0).getMov_age_percent().split(",");
			mav.addObject("mp", gp[0]);
			mav.addObject("wp", gp[1]);
			mav.addObject("a1p", ap[0]);
			mav.addObject("a2p", ap[1]);
			mav.addObject("a3p", ap[2]);
			mav.addObject("a4p", ap[3]);
			mav.addObject("a5p", ap[4]);
			mav.addObject("sw", "on");
		}else{
			mav.addObject("sw", "off");
		}
		mav.addObject("replaceChar", "\n");
		mav.setViewName("joaMovie/joaMovie_info");
		return mav;
	}

}

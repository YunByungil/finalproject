package joa.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import joa.movie.model.JoaMovieDAO;
import joa.movie.model.JoaMovieDTO;

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
		mav.addObject("list", list);
		mav.addObject("now", new java.util.Date());
		mav.setViewName("joaMovie/joaMovie_preMovie");
		return mav;
	}
	@RequestMapping("/detailView.do")
	public ModelAndView detailView(
			@RequestParam("mov_idx")int mov_idx) {
		ModelAndView mav=new ModelAndView();
		List<JoaMovieDTO> list=mdao.detailView(mov_idx);
		mav.addObject("list", list);
		mav.setViewName("joaMovie/joaMovie_detailView");
		return mav;
	}
}

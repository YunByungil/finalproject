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
			@RequestParam("mov_idx")int mov_idx) {
		ModelAndView mav=new ModelAndView();
		List<JoaMovieDTO> list=mdao.detailView(mov_idx);
		mav.addObject("list", list);
		mav.setViewName("joaMovie/joaMovie_detailView");
		return mav;
	}
	@RequestMapping("/info.do")
	public ModelAndView info(
			@RequestParam("mov_idx")int mov_idx) {
		ModelAndView mav=new ModelAndView();
		
		//junsung writed
		String buy_title="블랙 아담";
		double allMovCnt=mdao.allMovCnt();
		double selMovCnt=mdao.selMovCnt(buy_title);
		double bookPer_d=selMovCnt/allMovCnt*100;
		String bookPer=String.format("%.1f", bookPer_d);
		double allBookCnt=mdao.allBookCnt(buy_title);
		double manBookCnt=mdao.manBookCnt(buy_title);
		double manPer_d=manBookCnt/allBookCnt*100;
		String manPer=String.format("%.1f", manPer_d);
		double womanBookCnt=mdao.womanBookCnt(buy_title);
		double womanPer_d=womanBookCnt/allBookCnt*100;
		String womanPer=String.format("%.1f", womanPer_d);
		double oneBookCnt=mdao.oneBookPer(buy_title);
		double onePer_d=oneBookCnt/allBookCnt*100;
		String onePer=String.format("%.1f", onePer_d);
		double twoBookCnt=mdao.twoBookPer(buy_title);
		double twoPer_d=twoBookCnt/allBookCnt*100;
		String twoPer=String.format("%.1f", twoPer_d);
		double threeBookCnt=mdao.threeBookPer(buy_title);
		double threePer_d=threeBookCnt/allBookCnt*100;
		String threePer=String.format("%.1f", threePer_d);
		double fourBookCnt=mdao.fourBookPer(buy_title);
		double fourPer_d=fourBookCnt/allBookCnt*100;
		String fourPer=String.format("%.1f", fourPer_d);
		double fiveBookCnt=mdao.fiveBookPer(buy_title);
		double fivePer_d=fiveBookCnt/allBookCnt*100;
		String fivePer=String.format("%.1f", fivePer_d);
		Map map=new HashMap();
		map.put("buy_title", buy_title);
		map.put("mov_booking_percent", bookPer);
		map.put("mov_gender_percent", manPer+","+womanPer);
		map.put("mov_age_percent", onePer+","+twoPer+","+threePer+","+fourPer+","+fivePer);
		mdao.updateBookPer(map);
		mdao.updateGenderPer(map);
		mdao.updateGenderPer(map);
		
		mav.setViewName("joaMovie/joaMovie_info");
		return mav;
	}

}

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
		//junsung writed
//		List<JoaMovieDTO> aml=mdao.allMovieList();
//		double allMovCnt=mdao.allMovCnt();
//		for(int i=0;i<aml.size();i++) {
//			double selMovCnt=mdao.selMovCnt(aml.get(i).getMov_title());
//			double bookPer_d=selMovCnt/allMovCnt*100;
//			String bookPer=String.format("%.1f", bookPer_d);
//			Map map=new HashMap();
//			map.put("mov_title", aml.get(i).getMov_title());
//			map.put("mov_booking_percent", bookPer);
//			mdao.updateBookPer(map);
//		}
//		String payMov_mov_title="극장판 짱구는 못말려-수수께끼! 꽃피는 천하떡잎학교";
//		double allBookCnt=mdao.allBookCnt(payMov_mov_title);
//		double manBookCnt=mdao.manBookCnt(payMov_mov_title);
//		double manPer_d=manBookCnt/allBookCnt*100;
//		String manPer=String.format("%.1f", manPer_d);
//		double womanBookCnt=mdao.womanBookCnt(payMov_mov_title);
//		double womanPer_d=womanBookCnt/allBookCnt*100;
//		String womanPer=String.format("%.1f", womanPer_d);
//		double oneBookCnt=mdao.oneBookPer(payMov_mov_title);
//		double onePer_d=oneBookCnt/allBookCnt*100;
//		String onePer=String.format("%.1f", onePer_d);
//		double twoBookCnt=mdao.twoBookPer(payMov_mov_title);
//		double twoPer_d=twoBookCnt/allBookCnt*100;
//		String twoPer=String.format("%.1f", twoPer_d);
//		double threeBookCnt=mdao.threeBookPer(payMov_mov_title);
//		double threePer_d=threeBookCnt/allBookCnt*100;
//		String threePer=String.format("%.1f", threePer_d);
//		double fourBookCnt=mdao.fourBookPer(payMov_mov_title);
//		double fourPer_d=fourBookCnt/allBookCnt*100;
//		String fourPer=String.format("%.1f", fourPer_d);
//		double fiveBookCnt=mdao.fiveBookPer(payMov_mov_title);
//		double fivePer_d=fiveBookCnt/allBookCnt*100;
//		String fivePer=String.format("%.1f", fivePer_d);
//		Map map=new HashMap();
//		map.put("payMov_mov_title", payMov_mov_title);
//		map.put("mov_gender_percent", manPer+","+womanPer);
//		map.put("mov_age_percent", onePer+","+twoPer+","+threePer+","+fourPer+","+fivePer);
//		mdao.updateGenderPer(map);
//		mdao.updateAgePer(map);
		
		
		mav.setViewName("joaMovie/joaMovie_info");
		return mav;
	}

}

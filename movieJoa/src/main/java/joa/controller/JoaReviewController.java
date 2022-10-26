package joa.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import joa.review.model.JoaLikeDTO;
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
	@RequestMapping("/commentReg.do")
	public ModelAndView commentList(
			@RequestParam(value="ot", required=false, defaultValue = "0")int ot,
			@RequestParam(value="?cp", required=false, defaultValue = "1")int cp,
			@RequestParam("mov_idx")int mov_idx) {
		int totalCnt=rdao.totalCnt(mov_idx);
		int listSize=5;
		int pageSize=5;
		int start=(cp-1)*listSize+1;
		int end=cp*listSize;
		String pageStr=joa.page.PageModule.makePage("detailView.do?mov_idx="+mov_idx+"&show=1&ot="+ot+"&", totalCnt==0?totalCnt+1:totalCnt, listSize, pageSize, cp);
		ModelAndView mav=new ModelAndView();
		Map map=new HashMap();
		map.put("mov_idx", mov_idx);
		map.put("start", start);
		map.put("end", end);
		map.put("rev_id", "tester");
		List<JoaReviewDTO> list=rdao.commentList(ot, map);
		List<JoaLikeDTO> list2=rdao.likes(map);
		int checkId=rdao.checkId(map);
		mav.addObject("commentList", list);
		mav.addObject("pageStr", pageStr);
		mav.addObject("totalCnt", totalCnt);
		mav.addObject("list2", list2);
		mav.addObject("checkId", checkId);
		mav.setViewName("joaMovie/joaMovie_commentReg");
		return mav;
	}
	@RequestMapping("/commentUpdateForm.do")
	public ModelAndView commentUpdateForm(
			@RequestParam("rev_id")String rev_id,
			@RequestParam("mov_idx")int mov_idx) {
		ModelAndView mav=new ModelAndView();
		Map map=new HashMap();
		map.put("rev_id", rev_id);
		map.put("mov_idx", mov_idx);
		List<JoaReviewDTO> list=rdao.updateList(map);
		mav.addObject("commentUpdateList", list);
		mav.setViewName("joaMovie/joaMovie_commentUpdate");
		return mav;
	}
	@RequestMapping("/commentUpdate.do")
	public ModelAndView commentUpdate(JoaReviewDTO dto) {
		ModelAndView mav=new ModelAndView();
		rdao.commentUpdate(dto);
		return mav;
	}
	@RequestMapping("/commentDelete.do")
	public ModelAndView commentDelete(
			@RequestParam("rev_id")String rev_id,
			@RequestParam("rev_movie_title")String rev_movie_title) {
		ModelAndView mav = new ModelAndView();
		Map map=new HashMap();
		map.put("lik_writer_id", rev_id);
		map.put("lik_movie_title", rev_movie_title);
		rdao.commentDelete(map);
		mav.setViewName("joaMovie/historyBack");
		return mav;
	}
	@RequestMapping("/like.do")
	public ModelAndView like(
			@RequestParam("rev_idx")int rev_idx,
			@RequestParam("rev_id")String rev_id,
			@RequestParam("rev_movie_title")String rev_movie_title,
			@RequestParam("rev_like")int rev_like) {
		Map map=new HashMap();
		map.put("lik_movie_title", rev_movie_title);
		map.put("lik_writer_id", rev_id);
		map.put("lik_like_id", "tester");
		ModelAndView mav=new ModelAndView();
		int result=rdao.addLike(rev_idx, map);
		String result2=(rev_like+result)>rev_like?"♥ "+(rev_like+result):"♡ "+(rev_like+result);
		mav.addObject("result", result2);
		mav.addObject("rev_id", rev_id);
		mav.setViewName("joaMovie/joaMovie_like");
		return mav;
	}
	@RequestMapping("/likes.do")
	public ModelAndView likes(
			@RequestParam("likes")String likes) {
		ModelAndView mav=new ModelAndView();
		mav.addObject("likes", likes);
		mav.setViewName("joaMovie/joaMovie_likes");
		return mav;
	}
}

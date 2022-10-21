package joa.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import joa.adminMovie.model.AdminMovieDTO;
import joa.adminMovie.model.AdminMovieService;

@Controller
public class AdminMovieController {
	
	@Autowired
	private AdminMovieService adminMovieService;
	
	   private void insertPosterImg(MultipartFile mov_poster) {
	      try {
	         byte realPosterFile[] = mov_poster.getBytes();
	         File poster = new File("c:/work_space/movieJoa/movieJoa/src/main/webapp/img/movie_poster/" + mov_poster.getOriginalFilename());
	         FileOutputStream stream = new FileOutputStream(poster); 
	         stream.write(realPosterFile); 
	         stream.close(); 
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	   }

		
	@RequestMapping(value="/addMovieForm.do", method=RequestMethod.GET)
	public ModelAndView addMovie() {
		ModelAndView mav=new ModelAndView();
		String[] rateList = new String[5];
		rateList[0]="등급 선택";rateList[1]="전체";rateList[2]="12세";rateList[3]="15세";rateList[4]="청불";
		mav.addObject("rateList",rateList);
		mav.setViewName("admin/adminMovie/adminMovie_addMovie");
		return mav;
		
	}
	
   @RequestMapping(value="/addMovie.do" ,method=RequestMethod.POST)
	public ModelAndView addMovie(AdminMovieDTO dto, MultipartHttpServletRequest req) {
		
		 MultipartFile poster = req.getFile("poster");
		 insertPosterImg(poster);
		 
		 String mov_poster=poster.getOriginalFilename();
		 dto.setMov_poster(mov_poster);
		 
	   	int result = adminMovieService.addMovie(dto);
		String msg=result>0?"영화 정보 등록에 성공하였습니다.":"영화 정보 등록에 실패하였습니다.";
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg",msg);
		mav.addObject("nextPage","/movieJoa/listMovie.do");
		mav.setViewName("admin/adminMovie/msg");
		return mav;
		
   }

	@RequestMapping(value="/updateMovieForm.do" ,method=RequestMethod.GET)
	public ModelAndView updateMovie(
			@RequestParam(value="mov_idx", defaultValue="0")int mov_idx) {
			AdminMovieDTO dto= adminMovieService.detailMovie(mov_idx);
			ModelAndView mav=new ModelAndView();
			if (dto==null) {
				mav.addObject("msg","잘못된 접근입니다.");
				mav.setViewName("admin/adminMovie/msg");
			}else {
				String[] rateList = new String[4];
				rateList[0]="전체";rateList[1]="12세";rateList[2]="15세";rateList[3]="청불";
				mav.addObject("rateList",rateList);
				mav.addObject("dto",dto);
				mav.setViewName("admin/adminMovie/adminMovie_updateMovie");
			}
			return mav;
		
	}
	
	@RequestMapping(value="/updateMovie.do" ,method=RequestMethod.POST)
	public ModelAndView updateMovie(AdminMovieDTO dto, MultipartHttpServletRequest req) {
		
	     MultipartFile poster = req.getFile("poster");
		 insertPosterImg(poster);
		 
		 String mov_poster=poster.getOriginalFilename();
		 dto.setMov_poster(mov_poster);
		
		int result = adminMovieService.updateMovie(dto);
		String msg=result>0?"영화 정보 수정에 성공하였습니다.":"영화 정보 수정에 실패하였습니다.";
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg",msg);
		mav.addObject("nextPage","/movieJoa/listMovie.do");
		mav.setViewName("admin/adminMovie/msg");
		return mav;
	}
	
	
	@RequestMapping("/detailMovie.do")
	public ModelAndView movieDetail(
			@RequestParam(value="mov_idx", defaultValue="0")int mov_idx) {
		AdminMovieDTO dto= adminMovieService.detailMovie(mov_idx);
		ModelAndView mav=new ModelAndView();
		if (dto==null) {
			mav.addObject("msg","잘못된 접근입니다.");
			mav.setViewName("admin/adminMovie/msg");
		}else {
			mav.addObject("dto",dto);
			mav.setViewName("admin/adminMovie/adminMovie_movieDetail");
		}
		return mav;
	}
	
	@RequestMapping(value={"/listMovie.do","/searchMovie.do"})
	public ModelAndView listMovie(
			@RequestParam(value="cp", defaultValue="1")int cp,
			@RequestParam(value="s_k", defaultValue="--")String s_k, 
			@RequestParam(value="s_v", defaultValue="--")String s_v) {
		
		int totalCnt=adminMovieService.adminMovieTotalCnt(s_k, s_v);
		int listSize=10;
		int pageSize=5;
		String pageStr=joa.page.PageModule.makePage("listMovie.do", totalCnt, listSize, pageSize, cp);

		List<AdminMovieDTO> movieList=adminMovieService.listMovie(cp, listSize, s_k, s_v);
	
		ModelAndView mav= new ModelAndView();
		mav.addObject("pageStr",pageStr);
		mav.addObject("movieList",movieList);
		mav.addObject("s_k",s_k);
		mav.addObject("s_v",s_v);
		
		mav.setViewName("admin/adminMovie/adminMovie_listMovie");
		return mav;
	}
	
	@RequestMapping("/deleteMovie.do")
	public ModelAndView deleteMovie(
			@RequestParam(value="mov_idx", defaultValue="0")int mov_idx) {
		int result = adminMovieService.deleteMovie(mov_idx);
		String msg=result>0?"해당 영화 정보 삭제에 성공했습니다.":"해당 영화 정보 삭제에 실패했습니다.";
		System.out.println(result);
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg",msg);
		mav.addObject("nextPage","/movieJoa/listMovie.do");
		mav.setViewName("admin/adminMovie/msg");
		return mav;
	}

	
	
}

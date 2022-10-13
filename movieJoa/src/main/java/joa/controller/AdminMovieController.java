package joa.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

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
	
	   
	   /** 파일 복사 관련 메서드 */
	   private void copyInto(MultipartFile mov_poster) {
	      
	      System.out.println("파일명: " + mov_poster.getOriginalFilename());
	      
	      try {
	         byte bytes[] = mov_poster.getBytes();
	         File f = new File("c:/work_space/movieJoa/movieJoa/src/main/webapp/img/movie_poster" + mov_poster.getOriginalFilename());
	        
	         FileOutputStream fos = new FileOutputStream(f); 
	         fos.write(bytes); 
	         fos.close(); 
	         
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	   }
	
	@RequestMapping(value="/addMovieForm.do", method=RequestMethod.GET)
	public String addMovie() {
		return "admin/adminMovie/adminMovie_addMovie";
	}
	
   @RequestMapping(value="/addMovie.do" ,method=RequestMethod.POST)
	public ModelAndView addMovie(AdminMovieDTO dto/*, MultipartHttpServletRequest req*/) {
	   System.out.println(dto);
      
		/*
		 * MultipartFile mov_poster = req.getFile("mov_poster"); copyInto(mov_poster);
		 * String filename=mov_poster.getOriginalFilename();
		 */
	   	
	   	int result = adminMovieService.addMovie(dto);
		String msg=result>0?"영화 등록에 성공하였습니다.":"영화 등록에 실패하였습니다.";
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg",msg);
		mav.setViewName("admin/adminMovie/msg");
		return mav;
   }



	
	@RequestMapping("updateMovie.do")
	public String updateMovie() {
		return "admin/adminMovie/adminMovie_updateMovie";
	}
	
	@RequestMapping("movieDetail.do")
	public String movieDetail() {
		return "admin/adminMovie/adminMovie_movieDetail";
	}

}

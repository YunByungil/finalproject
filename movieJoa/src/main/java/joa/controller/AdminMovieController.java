package joa.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.System.Logger;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.i18n.*;
import org.springframework.stereotype.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import joa.adminMovie.model.AdminMovieDTO;
import joa.adminMovie.model.AdminMovieService;
import joa.adminMovie.model.MovieValidator;

@Controller
public class AdminMovieController {
	
	@Autowired
	private AdminMovieService adminMovieService;
 
	@ModelAttribute("vo") 
	public AdminMovieDTO initCommand() {
		return new AdminMovieDTO();
	} 

	public void copyInto(File f,MultipartFile upload) {
		
		try {
			byte bytes[]=upload.getBytes();
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(bytes);;
			fos.close();
			
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
	public ModelAndView addMovie(@Valid @ModelAttribute("vo") AdminMovieDTO dto, BindingResult errorResult,
			@RequestParam("poster")MultipartFile poster, HttpServletRequest req) {

		ModelAndView mav=new ModelAndView();
		int result=0;
	    String msg="";
	   
	    String path=req.getRealPath("/img/movie_poster");
	    String filename=poster.getOriginalFilename();
	    File f=new File(path+filename);		
		copyInto(f, poster);
		 
		 String mov_poster=poster.getOriginalFilename();
		 dto.setMov_poster(mov_poster);
		 
		 
		 new MovieValidator().validate(dto, errorResult);
			if(errorResult.hasErrors()) {
				System.out.println("errorResult:"+errorResult);
				String[] rateList = new String[5];
				rateList[0]="등급 선택";rateList[1]="전체";rateList[2]="12세";rateList[3]="15세";rateList[4]="청불";
				
				mav.addObject("rateList",rateList);
				mav.setViewName("admin/adminMovie/adminMovie_addMovie");
			}else {

			   	result = adminMovieService.addMovie(dto);
				msg=result>0?"영화 정보 등록에 성공하였습니다.":"영화 정보 등록에 실패하였습니다.";
				mav.addObject("msg",msg);
				mav.addObject("nextPage","/movieJoa/listMovie.do");
				mav.setViewName("admin/adminMovie/msg");
			}

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
	public ModelAndView updateMovie(@Valid @ModelAttribute("vo") AdminMovieDTO dto, BindingResult errorResult,
			@RequestParam("poster")MultipartFile poster, HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		int result=0;
		String msg="";
		String path=req.getRealPath("/img/movie_poster");
	    String filename=poster.getOriginalFilename();
	    File f=new File(path+filename);		
		copyInto(f, poster);
		 
		 String mov_poster=poster.getOriginalFilename();
		 dto.setMov_poster(mov_poster);
		 
		 new MovieValidator().validate(dto, errorResult);
			if(errorResult.hasErrors()) {
				System.out.println("errorResult:"+errorResult);
				String[] rateList = new String[4];
				rateList[0]="전체";rateList[1]="12세";rateList[2]="15세";rateList[3]="청불";
				mav.addObject("rateList",rateList);
				mav.setViewName("admin/adminMovie/adminMovie_updateMovie");
			}else {
				result = adminMovieService.updateMovie(dto);
				msg=result>0?"영화 정보 수정에 성공하였습니다.":"영화 정보 수정에 실패하였습니다.";
				mav.addObject("msg",msg);
				mav.addObject("nextPage","/movieJoa/listMovie.do");
				mav.setViewName("admin/adminMovie/msg");
			}
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

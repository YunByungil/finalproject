package joa.controller;

import java.util.List;
import joa.adminEvent.model.*;
import joa.event.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import joa.movie.model.JoaMovieDAO;
import joa.movie.model.JoaMovieDTO;

@Controller
public class IndexController {
	
	@Autowired
	private JoaMovieDAO mdao;
	private Joa_EventService joa_EventService;
	
	@RequestMapping("index.do")
	public ModelAndView index() {
		ModelAndView mav=new ModelAndView();
		List<JoaMovieDTO> list0=mdao.indexList0();
		List<JoaMovieDTO> list1=mdao.indexList1();
		mav.addObject("list0", list0);
		mav.addObject("list1", list1);
		mav.setViewName("index");
		return mav;
		
		
	}

}

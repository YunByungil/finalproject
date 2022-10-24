package joa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import joa.book.model.*;
import java.util.*;

@Controller
public class JoaTheaterController {
	
	@Autowired
	private JoaBookService joaBookService;

	@RequestMapping("/joaTheater.do")
	public ModelAndView base(@RequestParam(value = "sch_branch",defaultValue = "신촌")String sch_branch,
			@RequestParam(value = "sch_city",defaultValue = "서울")String sch_city) {
		ModelAndView mav = new ModelAndView();
		String[] testCity = {"서울","경기","인천","대전"};
		List<JoaBookDTO> branchList = joaBookService.theaterBranchList("서울");
		System.out.println(branchList.size());
		mav.addObject("testCity", testCity);
		mav.addObject("sch_city", sch_city);
		mav.addObject("sch_branch",sch_branch);
		mav.addObject("branchList", branchList);
		mav.setViewName("joaTheater/joaTheater_theater");
		return mav;
	}
}
